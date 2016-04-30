package xquery;

import xquery.antlr.*;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import org.w3c.dom.*;

import com.saxonica.xqj.SaxonXQDataSource;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xquery.*;

import java.io.StringWriter;

public class QueryProcessor {

    private static String test_query =
            "for $a in doc(\"src/main/resource/test.xml\")/bookstore\n" +
                    "return $a";

    public static String nodeToString(Node node) throws Exception {
        StringWriter writer = new StringWriter();
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.transform(new DOMSource(node), new StreamResult(writer));
        String output = writer.toString();
        return output.substring(output.indexOf("?>") + 2);
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

    public static void main( String[] args ) throws  Exception{

        String myRes = evaluate(test_query);

        String stdRes = stdEvaluate(test_query);

        if (myRes.equals(stdRes)) {
            System.out.println(myRes);
            System.out.print("Success");
        } else {
            System.out.println(myRes);
            System.out.println(stdRes);
        }
    }
}
