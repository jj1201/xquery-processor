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

import java.io.*;

/**
 * A Simple XQuery Processor
 *
 * Chang Li, Jiajia Chen
 * May. 12
 */

public class QueryProcessor {

    public static boolean stdCheck = false;

    /**
     * Helper function. Represent a node as a String
     * @param node org.w3c Node
     * @return  the String representation of the input
     * @throws Exception
     */
    public static String nodeToString(Node node) throws Exception {
        StringWriter writer = new StringWriter();
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
        transformer.transform(new DOMSource(node), new StreamResult(writer));
        return writer.toString();
    }

    /**
     * Main function of query-processor. Input a String type query, return
     * String type result.
     *
     * @param query Query in a string type
     * @return  String representation of the query result
     * @throws Exception
     */
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
            String str = nodeToString(node);
            if (node.getNodeType() != Node.TEXT_NODE) {
                resStr.append(str.substring(str.indexOf("?>") + 2));
                resStr.append('\n');
            } else {
                resStr.append(str.substring(str.indexOf("?>") + 2));
            }
        }
        return resStr.toString().trim();
    }

    /**
     * Get query result with Saxon Standard Library. Used to check the
     * correctness of our own result.
     *
     * @param query Query in a String type
     * @return String representation of the query result
     * @throws Exception
     */
    public static String stdEvaluate(String query) throws Exception{

        XQDataSource ds = new SaxonXQDataSource();
        XQConnection conn = ds.getConnection();
        XQPreparedExpression exp = conn.prepareExpression(query);
        XQResultSequence result = exp.executeQuery();

        return result.getSequenceAsString(null);
    }

    /**
     * Main Function. Fetch query from "test.sql" file and process it. Print
     * out the result as well as write it back into the "result.xml" file.
     *
     * @param args Not used yet
     * @throws Exception
     */
    public static void main( String[] args ) throws  Exception{

        if (args.length != 2) {
            System.out.println("Please indicate input and output file path.");
            return;
        }
        String input = args[0];
        String output = args[1];

        // Read single query from file
        File queryFile = new File(input);
        byte[] queryBuf = new byte[4096];
        (new FileInputStream(queryFile)).read(queryBuf);
        String query = (new String(queryBuf)).trim();
        System.out.println("---------Query--------\n" + query);

        // Processing and Timing
        long startTime = System.nanoTime();
        String myRes = evaluate(query);
        long endTime = System.nanoTime();

        System.out.println("---------Result--------\n" + myRes);
        System.out.println("\n----Time use : "+(endTime-startTime)/1000000+"ms----");

        // Write result into file
        File resultFile = new File(output);
        FileOutputStream outputStream = new FileOutputStream(resultFile);
        outputStream.write(myRes.getBytes());

        // If stdCheck == True, check the result with Saxon's result
        if (stdCheck) {
            String stdRes = stdEvaluate(query);
            if (myRes.equals(stdRes)) {
                System.out.println("---------Saxon Check: Success-------");
            } else {
                System.out.println("---------Saxon Check: Failed--------");
                System.out.println(stdRes);
            }
        }
    }
}
