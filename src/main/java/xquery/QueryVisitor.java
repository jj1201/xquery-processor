package xquery;

import com.sun.org.apache.xerces.internal.dom.DocumentImpl;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.RuleNode;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import xquery.antlr.XQueryBaseVisitor;
import xquery.antlr.XQueryParser;

import javax.print.Doc;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * Overridden Visitor Class.
 *
 * Created by Chang Li on 4/23/16.
 */
public class QueryVisitor extends XQueryBaseVisitor<QueryList> {

    public static boolean debugOn = false;

    private LinkedList<QueryList> stack = new LinkedList<>();
    private VariableContext varContext= new VariableContext();

    private Document doc = new DocumentImpl();

    private void debug(ParserRuleContext ctx) {
        if (!debugOn) return;
        System.out.println("CTX: " + ctx.getClass().getName());
        for (QueryList list : stack) {
            System.out.println("State : " + list);
        }
        System.out.println("Var:" + varContext);
    }

    /*
     *  Core Helper Methods
     *
     */

    private QueryList visitNode(QueryList queryList, RuleNode ruleNode) {
        stack.push(queryList);
        QueryList res = visit(ruleNode);
        stack.pop();
        return res;
    }

    private QueryList visitDescendant(QueryList queryList, RuleNode ruleNode) {
        if (queryList.size() == 0) return new QueryList();
        QueryList res = new QueryList();
        // DFS
        for (Node node : queryList) {
            QueryList tmpContext = new QueryList();
            tmpContext.add(node);
            QueryList rpSlashRp = visitNode(tmpContext, ruleNode);
            QueryList rpSlashSlashRp = visitDescendant(tmpContext.children(), ruleNode);
            res = res.union(rpSlashRp).union(rpSlashSlashRp);
        }
        return res;
    }

    /*
     *  Visitor functions for "xq" (XQuery)
     *
     */

    @Override public QueryList visitVarAsXq(XQueryParser.VarAsXqContext ctx) {
        debug(ctx);

        QueryList res = new QueryList();
        for (Node n : varContext.getVar(ctx.var().getText())) {
            res.add(n);
        }
        return res;
    }

    @Override public QueryList visitStringAsXq(XQueryParser.StringAsXqContext ctx) {
        debug(ctx);

        QueryList res = new QueryList();
        String str = ctx.str_const().getText();
        // Need to delete quotes here
        res.add(doc.createTextNode(str.substring(1,str.length()-1)));
        return res;
    }

    @Override public QueryList visitApAsXq(XQueryParser.ApAsXqContext ctx) {
        debug(ctx);

        return visitNode(stack.peek(), ctx.ap());
    }

    @Override public QueryList visitXqSlashRp(XQueryParser.XqSlashRpContext ctx) {
        debug(ctx);

        QueryList res1 = visitNode(stack.peek(), ctx.xq());
        QueryList res2 = visitNode(res1, ctx.rp());

        return res2;
    }

    @Override public QueryList visitXqSlashSlashRp(XQueryParser.XqSlashSlashRpContext ctx) {
        debug(ctx);

        QueryList res1 = visitNode(stack.peek(), ctx.xq());
        QueryList res2 = visitDescendant(res1, ctx.rp());

        return res2;
    }

    @Override public QueryList visitParenthesisXq(XQueryParser.ParenthesisXqContext ctx) {
        debug(ctx);

        return visitNode(stack.peek(), ctx.xq());
    }

    @Override public QueryList visitXqCommaXq(XQueryParser.XqCommaXqContext ctx) {
        debug(ctx);

        QueryList res1 = visitNode(stack.peek(), ctx.xq(0));
        QueryList res2 = visitNode(stack.peek(), ctx.xq(1));

        return res1.union(res2);
    }

    @Override public QueryList visitTagNameXq(XQueryParser.TagNameXqContext ctx) {
        debug(ctx);

        QueryList subres = visitNode(stack.peek(), ctx.xq());
        Node resNode = doc.createElement(ctx.tag_name(0).getText());
        for (Node node : subres) {
            Node iNode = resNode.getOwnerDocument().importNode(node, true);
            resNode.appendChild(iNode);
        }
        QueryList res = new QueryList();
        res.add(resNode);
        return res;
    }

    @Override public QueryList visitLetXq(XQueryParser.LetXqContext ctx) {
        debug(ctx);

        varContext.pushContext();
        visitNode(stack.peek(), ctx.let());
        QueryList res = visitNode(stack.peek(), ctx.xq());
        varContext.popContext();

        return res;
    }

    @Override public QueryList visitFlwrXq(XQueryParser.FlwrXqContext ctx) {
        debug(ctx);

        return visitNode(stack.peek(), ctx.flwr());
    }

    /*
     *  Visitor functions for FLWR
     *
     */

    @Override public QueryList visitFlwr(XQueryParser.FlwrContext ctx) {
        debug(ctx);

        QueryList res = new QueryList();
        String varName = ctx.var().getText();
        QueryList varList = visitNode(stack.peek(), ctx.xq());

        for (Node v : varList) {
            varContext.pushContext();
            QueryList tmpContext = new QueryList();
            tmpContext.add(v);
            varContext.putVar(varName, tmpContext);
            if (ctx.lwr() != null) {
                res = res.union(visitNode(stack.peek(), ctx.lwr()));
            } else {
                res = res.union(visitNode(stack.peek(), ctx.flwr()));
            }
            varContext.popContext();
        }

        return res;
    }

    @Override public QueryList visitLwr(XQueryParser.LwrContext ctx) {
        debug(ctx);

        if (ctx.let() != null) { visitNode(stack.peek(), ctx.let()); }
        if (ctx.where() != null) {
            if (visitNode(stack.peek(), ctx.where()) == null) {
                return new QueryList();
            }
        }
        return visitNode(stack.peek(), ctx.ret());
    }

    /*
     *  Visitor functions for "let" (letClause)
     *
     */

    @Override public QueryList visitLet(XQueryParser.LetContext ctx) {
        debug(ctx);

        int length = ctx.var().size();
        for (int i=0; i<length; i++) {
            QueryList varValue = visitNode(stack.peek(), ctx.xq(i));
            varContext.putVar(ctx.var(i).getText(), varValue);
        }
        return null;
    }

    /*
     *  Visitor functions for "where"
     *
     */

    @Override public QueryList visitWhere(XQueryParser.WhereContext ctx) {
        debug(ctx);

        /* "where return null" means cond is false*/
        return visitNode(stack.peek(), ctx.cond());
    }

    /*
     *  Visitor functions for "return"
     *
     */

    public static long timeForRet = 0;
    @Override public QueryList visitRet(XQueryParser.RetContext ctx) {
        debug(ctx);
        long start = System.nanoTime();
        QueryList res = visitNode(stack.peek(), ctx.xq());
        timeForRet += (System.nanoTime() - start);
        return res;
    }

    /*
     *  Join
     *
     */

    @Override public QueryList visitJoinXq(XQueryParser.JoinXqContext ctx) {
        debug(ctx);

        QueryList res = visitNode(stack.peek(), ctx.join());
        return res;
    }

    @Override public QueryList visitJoin(XQueryParser.JoinContext ctx) {
        debug(ctx);

        QueryList res = new QueryList();
        QueryList res1 = visitNode(stack.peek(), ctx.xq(0));
        QueryList res2 = visitNode(stack.peek(), ctx.xq(1));

        // If conditional list is empty, directly join
        if (ctx.jlist(0).tag_name() == null) {
            for (Node n1 : res1) {
                for (Node n2 : res2) {
                    res.add(mergeTuple(n1, n2));
                }
            }
            return res;
        }

        // Hash join
        HashMap<Integer, List<Node>> map = new HashMap<>();

        // Build the map
        for (Node n1 : res1) {
            StringBuilder keyBuilder = new StringBuilder();
            for (int i = 0; i < ctx.jlist(0).tag_name().size(); i++) {
                String attr1 = ctx.jlist(0).tag_name(i).getText();
                Node attrNode = getNodeFromTuple(attr1, n1);
                keyBuilder.append(getNodeKey(attrNode));
            }
            String key = keyBuilder.toString();
            if (!map.containsKey(key.hashCode())) {
                map.put(key.hashCode(), new LinkedList<Node>());
            }
            map.get(key.hashCode()).add(n1);
        }

        // Join
        for (Node n2 :res2) {
            StringBuilder keyBuilder = new StringBuilder();
            for (int i = 0; i < ctx.jlist(1).tag_name().size(); i++) {
                String attr2 = ctx.jlist(1).tag_name(i).getText();
                Node attrNode = getNodeFromTuple(attr2, n2);
                keyBuilder.append(getNodeKey(attrNode));
            }
            String key = keyBuilder.toString();
            List<Node> n1List = map.get(key.hashCode());
            if (n1List != null) {
                for (Node n1 : n1List) {
                    res.add(mergeTuple(n1, n2));
                }
            }
        }
        return res;
    }

    private String getNodeKey(Node node) {
        long start = System.nanoTime();
        StringBuilder res = new StringBuilder();
        res.append(node.getNodeName().hashCode());
        res.append(node.getTextContent().hashCode());
        return res.toString();
    }

    private Node getNodeFromTuple(String attr, Node tuple) {
        NodeList nodeList = tuple.getChildNodes();
        for (int i=0; i<nodeList.getLength(); i++) {
            if (nodeList.item(i).getNodeName().equals(attr)) {
                return nodeList.item(i).getFirstChild();
            }
        }
        throw new IllegalStateException();
    }


    private Node mergeTuple(Node tuple1, Node tuple2) {

        Node joinedNode = doc.createElement("tuple");
        NodeList nl1 = tuple1.getChildNodes();
        NodeList nl2 = tuple2.getChildNodes();
        for (int j=0; j<nl1.getLength(); j++) {
            Node iNode = doc.importNode(nl1.item(j), true);
            joinedNode.appendChild(iNode);
        }
        for (int j=0; j<nl2.getLength(); j++) {
            Node iNode = doc.importNode(nl2.item(j), true);
            joinedNode.appendChild(iNode);
        }

        return joinedNode;
    }

    /*
     *  Visitor functions for Conditions
     *
     */

    @Override public QueryList visitXqSomeCond(XQueryParser.XqSomeCondContext ctx) {
        debug(ctx);

        return visitNode(stack.peek(), ctx.some_cond());
    }

    @Override public QueryList visitSomeCond(XQueryParser.SomeCondContext ctx) {
        debug(ctx);

        QueryList res = null;
        String varName = ctx.var().getText();
        QueryList varList = visitNode(stack.peek(), ctx.xq());

        for (Node v : varList) {
            varContext.pushContext();
            QueryList tmpContext = new QueryList();
            tmpContext.add(v);
            varContext.putVar(varName, tmpContext);
            if (ctx.cond() != null) {
                res = visitNode(stack.peek(), ctx.cond());
            } else {
                res = visitNode(stack.peek(), ctx.some_cond());
            }
            varContext.popContext();
        }
        return res;
    }

    @Override public QueryList visitXqEmptyCond(XQueryParser.XqEmptyCondContext ctx) {
        debug(ctx);

        QueryList res = visitNode(stack.peek(), ctx.xq());
        if (res.isEmpty()) {
            return new QueryList();
        } else {
            return null;
        }
    }

    /*
     *  Visitor functions for value equal condition
     *
     */
     @Override public QueryList visitXqValueEqualCond(XQueryParser.XqValueEqualCondContext ctx) {
         debug(ctx);

         QueryList res1 = visitNode(stack.peek(), ctx.xq(0));
         QueryList res2 = visitNode(stack.peek(), ctx.xq(1));
         if (!res1.valueIntersect(res2).isEmpty()) {
             return new QueryList();
         } else {
             return null;
         }
     }

    /*
     *
     *  Visitor functions for id equal conditon
     */

    @Override public QueryList visitXqIdEqualCond(XQueryParser.XqIdEqualCondContext ctx) {
        debug(ctx);

        QueryList res1 = visitNode(stack.peek(), ctx.xq(0));
        QueryList res2 = visitNode(stack.peek(), ctx.xq(1));
        if (!res1.idIntersect(res2).isEmpty()) {
            return new QueryList();
        } else {
            return null;
        }
    }

    /*
     *  Visitor functions for parenthesis condition
     *
     */

    @Override public QueryList visitParenthesisCond(XQueryParser.ParenthesisCondContext ctx) {
        debug(ctx);

        QueryList res = visitNode(stack.peek(), ctx.cond());
        return res;
    }

    /*
     *  Visitor functions for and condition
     *
     */

    @Override public QueryList visitAndCond(XQueryParser.AndCondContext ctx) {
        debug(ctx);

        QueryList res1 = visitNode(stack.peek(), ctx.cond(0));
        QueryList res2 = visitNode(stack.peek(), ctx.cond(1));

        if (res1 == null || res2 == null) {
            return null;
        } else {
            return new QueryList();
        }
    }

    /*
     *  Visitor functions for or condition
     *
     */

    @Override public QueryList visitOrCond(XQueryParser.OrCondContext ctx) {
        debug(ctx);

        QueryList res1 = visitNode(stack.peek(), ctx.cond(0));
        QueryList res2 = visitNode(stack.peek(), ctx.cond(1));

        if (res1 == null && res2 == null) {
            return null;
        } else {
            return new QueryList();
        }
    }

    /*
     *  Visitor functions for not condition
     *
     */

    @Override public QueryList visitNotCond(XQueryParser.NotCondContext ctx) {
        debug(ctx);

        QueryList res1 = visitNode(stack.peek(), ctx.cond());

        if (res1 != null) {
            return null;
        } else {
            return new QueryList();
        }
    }

    /*
     *  Visitor functions for "ap" (absolute path)
     *
     */

    @Override public QueryList visitDocSlashRp(XQueryParser.DocSlashRpContext ctx) {
        debug(ctx);

        String fileName = ctx.file_name().getText();
        fileName = fileName.substring(1, fileName.length()-1); // delete quotes
        File xmlFile = new File(fileName);
        Document currDoc = null;
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            currDoc = builder.parse(xmlFile);
        } catch (Exception e) {
            e.printStackTrace();
            throw new Error("Open file error.");
        }

        QueryList context = new QueryList();
        context.add(currDoc);

        return visitNode(context, ctx.rp());
    }

    @Override public QueryList visitDocSlashSlashRp(XQueryParser.DocSlashSlashRpContext ctx) {
        debug(ctx);

        String fileName = ctx.file_name().getText();
        fileName = fileName.substring(1, fileName.length()-1); // delete quotes
        File xmlFile = new File(fileName);
        Document currDoc = null;
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            currDoc = builder.parse(xmlFile);
        } catch (Exception e) {
            e.printStackTrace();
            throw new Error("Open file error.");
        }

        QueryList context = new QueryList();
        context.add(currDoc);

        return visitDescendant(context, ctx.rp());
    }

    /*
     *  Visitor functions for "rp" (relative path)
     *
     */

    @Override public QueryList visitRpSlashRp(XQueryParser.RpSlashRpContext ctx) {
        debug(ctx);

        QueryList res1 = visitNode(stack.peek(), ctx.rp(0));
        QueryList res2 = visitNode(res1, ctx.rp(1));

        return res2;
    }

    @Override public QueryList visitRpSlashSlashRp(XQueryParser.RpSlashSlashRpContext ctx) {
        debug(ctx);

        QueryList midState = visitNode(stack.peek(), ctx.rp(0));
        QueryList res = visitDescendant(midState, ctx.rp(1));

        return res;
    }

    @Override public QueryList visitTagName(XQueryParser.TagNameContext ctx) {
        debug(ctx);

        String tagName = ctx.tag_name().getText();
        QueryList res = new QueryList();
        for (Node node : stack.peek().children()) {
            if (node.getNodeName().equals(tagName)) {
                res.add(node);
            }
        }
        return res;
    }

    @Override public QueryList visitDot(XQueryParser.DotContext ctx) {
        debug(ctx);

        QueryList res = new QueryList();
        for (Node node : stack.peek()) {
            res.add(node);
        }
        return res;
    }

    @Override public QueryList visitDoubleDot(XQueryParser.DoubleDotContext ctx) {
        debug(ctx);

        QueryList res = stack.peek().parent();
        return res;
    }


    @Override public QueryList visitStar(XQueryParser.StarContext ctx) {
        debug(ctx);

        QueryList res = new QueryList();
        for (Node node : stack.peek().children()) {
            res.add(node);
        }
        return res;
    }

    @Override public QueryList visitText (XQueryParser.TextContext ctx) {
        debug(ctx);

        QueryList res = new QueryList();
        for(Node node : stack.peek()) {
            res.add(node.getFirstChild());
        }
        return res;
    }

    @Override public QueryList visitAttName(XQueryParser.AttNameContext ctx ) {
        debug(ctx);

        QueryList res = new QueryList();
        String attName = ctx.att_name().getText();
        for(Node node : stack.peek()) {
            if(node.hasAttributes()) {
                Node att = node.getAttributes().getNamedItem(attName);
                if (att != null) res.add(att);
            }
        }

        return res;
    }

    @Override public QueryList visitParenthesisRp(XQueryParser.ParenthesisRpContext ctx) {
        debug(ctx);

        QueryList res = visitNode(stack.peek(), ctx.rp());
        return res;
    }


    @Override public QueryList visitRpWithFilter(XQueryParser.RpWithFilterContext ctx) {
        debug(ctx);

        QueryList res1 = visitNode(stack.peek(), ctx.rp());
        QueryList res2 = visitNode(res1, ctx.f());

        return res2;
    }

    @Override public QueryList visitRpCommaRp(XQueryParser.RpCommaRpContext ctx) {
        debug(ctx);

        QueryList res1 = visitNode(stack.peek(), ctx.rp(0));
        QueryList res2 = visitNode(stack.peek(), ctx.rp(1));
        QueryList res = res1.union(res2);

        return res;
    }
    /*
     *  Visitor functions for "f" (filter)
     *
     */

    @Override public QueryList visitRpFilter(XQueryParser.RpFilterContext ctx) {
        debug(ctx);

        QueryList res = new QueryList();
        for (Node node : stack.peek()) {
            QueryList tmpContext = new QueryList();
            tmpContext.add(node);
            if (!visitNode(tmpContext, ctx.rp()).isEmpty()) {
                res.add(node);
            }
        }
        return res;
    }

    @Override public QueryList visitValueEqualFilter(XQueryParser.ValueEqualFilterContext ctx) {
        debug(ctx);

        QueryList res = new QueryList();
        for (Node node : stack.peek()) {
            QueryList tmpContext = new QueryList();
            tmpContext.add(node);
            QueryList res1 = visitNode(tmpContext, ctx.rp(0));
            QueryList res2 = visitNode(tmpContext, ctx.rp(1));
            if (!res1.valueIntersect(res2).isEmpty()) {
                res.add(node);
            }
        }
        return res;
    }

    @Override public QueryList visitIDEqualFilter(XQueryParser.IDEqualFilterContext ctx) {
        debug(ctx);

        QueryList res = new QueryList();
        for(Node node : stack.peek()) {
            QueryList tmpContext = new QueryList();
            tmpContext.add(node);
            QueryList res1 = visitNode(tmpContext, ctx.rp(0));
            QueryList res2 = visitNode(tmpContext, ctx.rp(1));
            if(!res1.idIntersect(res2).isEmpty()) {
                res.add(node);
            }
        }
        return res;
    }

    @Override public QueryList visitParenthesisFilter(XQueryParser.ParenthesisFilterContext ctx) {
        debug(ctx);

        QueryList res = new QueryList();
        for (Node node : stack.peek()) {
            QueryList tmpContext = new QueryList();
            tmpContext.add(node);
            if (!visitNode(tmpContext, ctx.f()).isEmpty()) {
                res.add(node);
            }
        }
        return res;

    }

    @Override public QueryList visitAndFilter(XQueryParser.AndFilterContext ctx) {
        debug(ctx);

        QueryList res1 = new QueryList();
        QueryList res2 = new QueryList();
        for (Node node : stack.peek()) {
            QueryList tmpContext = new QueryList();
            tmpContext.add(node);
            if (!visitNode(tmpContext, ctx.f(0)).isEmpty()) {
                res1.add(node);
            }
            if (!visitNode(tmpContext, ctx.f(1)).isEmpty()) {
                res2.add(node);
            }

        }
        res1 = res1.valueIntersect(res2);
        return res1;

    }

    @Override public QueryList visitOrFilter(XQueryParser.OrFilterContext ctx) {
        debug(ctx);

        QueryList res1 = new QueryList();
        QueryList res2 = new QueryList();
        for (Node node : stack.peek()) {
            QueryList tmpContext = new QueryList();
            tmpContext.add(node);
            if (!visitNode(tmpContext, ctx.f(0)).isEmpty()) {
                res1.add(node);
            }
            if (!visitNode(tmpContext, ctx.f(1)).isEmpty()) {
                res2.add(node);
            }

        }
        res1 = res1.union(res2);
        return res1;

    }

    @Override public QueryList visitNotFilter(XQueryParser.NotFilterContext ctx) {
        debug(ctx);

        QueryList res = new QueryList();
        for (Node node : stack.peek()) {
            QueryList tmpContext = new QueryList();
            tmpContext.add(node);
            if (!visitNode(tmpContext, ctx.f()).isEmpty()) {
                res.add(node);
            }
        }
        res = stack.peek().subtract(res);
        return res;
    }
}
