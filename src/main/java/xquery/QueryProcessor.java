package xquery;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import xquery.antlr.*;
import org.w3c.dom.*;

import java.util.List;

import javax.xml.xpath.*;
import javax.xml.parsers.*;

public class QueryProcessor {

    private static String fpath = "src/main/resource/test.xml";
    private static String rpath = "/bookstore[book/author = ebook/author]/./*";
    private static String query =
                        "let $moe := doc(src/main/resource/test.xml)/.\n" +
                        "$moe/bookstore[book/author = ebook/author]/./*";

    public static NodeList evaluate(String fp, String rp) {
        String query = fp + rp ; //"doc(" + fp + ")" + rp;
        // Init ANTLR
        ANTLRInputStream inputStream = new ANTLRInputStream(query);
        XQueryLexer lexer = new XQueryLexer(inputStream);
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        XQueryParser parser = new XQueryParser(tokenStream);
        ParseTree tree = parser.xq();

        // Visit
        QueryVisitor visitor = new QueryVisitor();
        return visitor.visit(tree);
    }

    public static NodeList stdEvaluate(String fp, String rp) throws Exception{
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(fp);
        XPathFactory xPathfactory = XPathFactory.newInstance();
        XPath xpath = xPathfactory.newXPath();
        XPathExpression expr = xpath.compile(rp);
        return (NodeList) expr.evaluate(doc, XPathConstants.NODESET);
    }

    public static boolean checkResult(NodeList myRes, NodeList stdRes) {

        System.out.println("Mine:");
        for (int i=0; i<myRes.getLength(); i++) {
            System.out.println(myRes.item(i).getTextContent());
        }

        System.out.println("STD:");
        for (int i=0; i<stdRes.getLength(); i++) {
            System.out.println(stdRes.item(i).getTextContent());
        }

        if (myRes.getLength() == stdRes.getLength()) {
            for (int i=0; i<myRes.getLength(); i++) {
                if (!myRes.item(i).isEqualNode(stdRes.item(i))) {
                    System.out.println("Failed:");
                    System.out.println(myRes.item(i).toString());
                    System.out.println(stdRes.item(i).toString());
                    return false;
                }
            }
        } else {
            System.out.println("Failed: Different Length");
            return false;
        }
        System.out.println("Succeed.");
        return true;
    }

    public static void main( String[] args ) throws  Exception{

        NodeList myRes = evaluate(query, "" /*fpath, rpath*/);

        NodeList stdRes = stdEvaluate(fpath, rpath);

        checkResult(myRes, stdRes);

    }
}
