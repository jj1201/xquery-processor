package xquery;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import xquery.antlr.*;
import org.w3c.dom.*;

import java.util.List;

import javax.xml.xpath.*;
import javax.xml.parsers.*;

/**
 * Hello world!
 *
 */
public class App {

    private static String fpath = "doc(src/main/resource/j_caesar.xml)";
    private static String rpath = "/PLAY//TITLE";

    public static void main( String[] args ) throws  Exception{

        // Init ANTLR
        ANTLRInputStream inputStream = new ANTLRInputStream(fpath + rpath);
        XQueryLexer lexer = new XQueryLexer(inputStream);
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        XQueryParser parser = new XQueryParser(tokenStream);
        ParseTree tree = parser.ap();

        MyXQueryVisitor visitor = new MyXQueryVisitor();
        MyNodeList res = visitor.visit(tree);
        System.out.println("Mine:");
        for (int i=0; i<res.getLength(); i++) {
            System.out.println(res.item(i).getTextContent());
        }

        System.out.println("STD:");
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse("src/main/resource/j_caesar.xml");
        XPathFactory xPathfactory = XPathFactory.newInstance();
        XPath xpath = xPathfactory.newXPath();
        XPathExpression expr = xpath.compile(rpath);
        NodeList nl = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);
        for (int i=0; i<nl.getLength(); i++) {
            System.out.println(nl.item(i).getTextContent());
        }

        if (res.getLength() == nl.getLength()) {
            boolean succeed = true;
            for (int i=0; i<nl.getLength(); i++) {
                if (!res.item(i).getTextContent().equals(nl.item(i).getTextContent())) {
                    System.out.println(res.item(i).getTextContent() + " -- " +
                                        nl.item(i).getTextContent());
                    succeed = false;
                    break;
                }
            }
            if (succeed) {
                System.out.println("Succeed.");
            }
        }
    }
}
