package xquery;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.RuleNode;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import xquery.antlr.XQueryBaseVisitor;
import xquery.antlr.XQueryParser;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by lichkkkk on 4/23/16.
 */
public class QueryVisitor extends XQueryBaseVisitor<QueryList> {

    public static boolean debugOn = false;

    private LinkedList<QueryList> stack = new LinkedList<>();

    private void debug(ParserRuleContext ctx) {
        if (!debugOn) return;
        System.out.println("CTX: " + ctx.getClass().getName());
        for (QueryList list : stack) {
            System.out.println("State : " + list);
        }
    }

    private QueryList rp(QueryList queryList, RuleNode ruleNode) {
        stack.push(queryList);
        QueryList res = visit(ruleNode);
        stack.pop();
        return res;
    }

    private QueryList rprp(QueryList queryList, RuleNode ruleNode) {
        if (queryList.size() == 0) return new QueryList();
        QueryList res = new QueryList();
        // DFS
        for (Node node : queryList) {
            QueryList tmpContext = new QueryList();
            tmpContext.add(node);
            QueryList rpSlashRp = rp(tmpContext, ruleNode);
            QueryList rpSlashSlashRp = rprp(tmpContext.children(), ruleNode);
            res = res.union(rpSlashRp).union(rpSlashSlashRp);
        }
        return res;
    }

    /*
     *  Visitor functions for "ap" (absolute path)
     *
     */

    @Override public QueryList visitDocSlashRp(XQueryParser.DocSlashRpContext ctx) {
        debug(ctx);

        String fileName = ctx.file_name().getText();
        File xmlFile = new File(ctx.file_name().getText());
        Document doc = null;
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            doc = builder.parse(xmlFile);
        } catch (Exception e) {
            e.printStackTrace();
            throw new Error("Open file error.");
        }

        QueryList context = new QueryList();
        context.add(doc);

        return rp(context, ctx.rp());
    }

    @Override public QueryList visitDocSlashSlashRp(XQueryParser.DocSlashSlashRpContext ctx) {
        debug(ctx);

        String fileName = ctx.file_name().getText();
        File xmlFile = new File(ctx.file_name().getText());
        Document doc = null;
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            doc = builder.parse(xmlFile);
        } catch (Exception e) {
            e.printStackTrace();
            throw new Error("Open file error.");
        }

        QueryList context = new QueryList();
        context.add(doc);

        return rprp(context, ctx.rp());
    }

    /*
     *  Visitor functions for "rp" (relative path)
     *
     */

    @Override public QueryList visitRpSlashRp(XQueryParser.RpSlashRpContext ctx) {
        debug(ctx);

        QueryList res1 = rp(stack.peek(), ctx.rp(0));
        QueryList res2 = rp(res1, ctx.rp(1));

        return res2;
    }

    @Override public QueryList visitRpSlashSlashRp(XQueryParser.RpSlashSlashRpContext ctx) {
        debug(ctx);

        QueryList midState = rp(stack.peek(), ctx.rp(0));
        QueryList res = rprp(midState, ctx.rp(1));

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

    @Override public QueryList visitStar(XQueryParser.StarContext ctx) {
        debug(ctx);

        QueryList res = new QueryList();
        for (Node node : stack.peek().children()) {
            res.add(node);
        }
        return res;
    }

    @Override public QueryList visitRpWithFilter(XQueryParser.RpWithFilterContext ctx) {
        debug(ctx);

        QueryList res1 = rp(stack.peek(), ctx.rp());
        QueryList res2 = rp(res1, ctx.f());

        return res2;
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
            if (!rp(tmpContext, ctx.rp()).isEmpty()) {
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
            QueryList res1 = rp(tmpContext, ctx.rp(0));
            QueryList res2 = rp(tmpContext, ctx.rp(1));
            if (!res1.valueIntersect(res2).isEmpty()) {
                res.add(node);
            }
        }
        return res;
    }

}
