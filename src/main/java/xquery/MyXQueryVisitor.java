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
public class MyXQueryVisitor extends XQueryBaseVisitor<MyNodeList> {

    private LinkedList<MyNodeList> state = new LinkedList<>();

    private void debug(ParserRuleContext ctx) {
        System.out.println("CTX: " + ctx.getClass().getName());
        for (MyNodeList list : state) {
            System.out.println("State : " + list);
        }
    }

    private MyNodeList rp(MyNodeList nodeList, RuleNode ruleNode) {
        state.push(nodeList);
        MyNodeList res = visit(ruleNode);
        state.pop();
        return res;
    }

    private MyNodeList rprp(MyNodeList nl, RuleNode ruleNode) {

        if (nl.getList().size() == 0) return new MyNodeList();

        MyNodeList res = new MyNodeList();
        for (Node node : nl.getList()) {
            MyNodeList tmp = new MyNodeList();
            tmp.getList().add(node);
            MyNodeList rpSlashRp = rp(tmp, ruleNode);
            MyNodeList rpSlashSlashRp = rprp(tmp.children(), ruleNode);
            res.union(rpSlashRp).union(rpSlashSlashRp);
        }
        return res;
    }

    @Override public MyNodeList visitDocSlashRp(XQueryParser.DocSlashRpContext ctx) {
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

        MyNodeList context = new MyNodeList();
        context.getList().add(doc);

        return rp(context, ctx.rp());
    }

    @Override public MyNodeList visitRpSlashRp(XQueryParser.RpSlashRpContext ctx) {
        debug(ctx);

        MyNodeList res1 = rp(state.peek(), ctx.rp(0));
        MyNodeList res2 = rp(res1, ctx.rp(1));

        return res2;
    }

    @Override public MyNodeList visitRpSlashSlashRp(XQueryParser.RpSlashSlashRpContext ctx) {
        debug(ctx);

        MyNodeList midState = rp(state.peek(), ctx.rp(0));

        return rprp(midState, ctx.rp(1));
    }

    @Override public MyNodeList visitTagName(XQueryParser.TagNameContext ctx) {
        debug(ctx);

        String tagName = ctx.tag_name().getText();
        MyNodeList res = new MyNodeList();
        for (Node node : state.peek().children().getList()) {
            if (node.getNodeName().equals(tagName)) {
                res.getList().add(node);
            }
        }
        return res;
    }

    @Override public MyNodeList visitStar(XQueryParser.StarContext ctx) {
        debug(ctx);

        return state.peek().children();
    }

}
