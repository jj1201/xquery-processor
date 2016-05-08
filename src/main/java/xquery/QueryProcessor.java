package xquery;

import xquery.antlr.*;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import org.w3c.dom.*;

import com.saxonica.xqj.SaxonXQDataSource;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xquery.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.StringWriter;

/**
 * TODO:
 *      ( xq ) cannot be recognized correctly
 *      WS between str_const is skipped
 *      XML transform is not correct when has external tags
 */

public class QueryProcessor {

    private static String test_query =
            "<result> { " +
            "for $a in doc(\"src/main/resource/test.xml\")/bookstore\n" +
                    "let $a := $a/*" +
                    "where some $b in $a satisfies empty($b/country)" +
                    "return ( \"asd\", $a)" +
            "} </result>";

    public static String nodeToString(Node node) throws Exception {
        StringWriter writer = new StringWriter();
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
        transformer.transform(new DOMSource(node), new StreamResult(writer));
        String output = writer.toString();
        return output.substring(output.indexOf("?>") + 3);
    }

    public static String evaluate(String query) throws Exception {

        // Init ANTLR
        ANTLRInputStream inputStream = new ANTLRInputStream(query);
        XQueryLexer lexer = new XQueryLexer(inputStream);
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        XQueryParser parser = new XQueryParser(tokenStream);
        ParseTree tree = parser.xq();

        // Visit
        QueryVisitor visitor = new QueryVisitor();
        QueryList res = visitor.visit(tree);

        // Build result String
        StringBuilder resStr = new StringBuilder();
        for (Node node : res) {
            if (resStr.length() > 0) { resStr.append('\n'); }
            resStr.append(nodeToString(node));
        }
        return resStr.toString();
    }

    public static String stdEvaluate(String query) throws Exception{

        XQDataSource ds = new SaxonXQDataSource();
        XQConnection conn = ds.getConnection();
        XQPreparedExpression exp = conn.prepareExpression(query);
        XQResultSequence result = exp.executeQuery();

        return result.getSequenceAsString(null);
    }

    public static boolean checkResult(String res1, String res2) {
        StringBuilder r1 = new StringBuilder();
        StringBuilder r2 = new StringBuilder();
        for (int i=0; i<res1.length(); i++) {
            char ch = res1.charAt(i);
            if (ch != '\t' && ch != '\n' && ch!= '\r' && ch != ' ') {
                r1.append(ch);
            }
        }
        for (int i=0; i<res2.length(); i++) {
            char ch = res2.charAt(i);
            if (ch != '\t' && ch != '\n' && ch!= '\r' && ch != ' ') {
                r2.append(ch);
            }
        }
        return r1.toString().equals(r2.toString());
    }

    public static void main( String[] args ) throws  Exception{

        // Read single query from file
        File queryFile = new File("src/main/resource/test.xql");
        byte[] queryBuf = new byte[4096];
        (new FileInputStream(queryFile)).read(queryBuf);
        String query = (new String(queryBuf)).trim();
//        query = test_query;
        System.out.println("---------Query--------\n" + query);

        String myRes = evaluate(query);
        System.out.println("---------Result--------\n" + myRes);

        String stdRes = stdEvaluate(query);
        if (myRes.equals(stdRes)) {
            System.out.println("---------Success-------");
        } else {
            System.out.println("---------Failed--------");
            System.out.println(stdRes);
        }
    }
}
