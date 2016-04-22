package xquery;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import xquery.antlr.*;

/**
 * Hello world!
 *
 */
public class App {

    private static String xpath = "doc(j_caesar.xml)/PLAY/TITLE";

    public static void main( String[] args ) throws Exception {
        ANTLRInputStream inputStream = new ANTLRInputStream(xpath);
        XQueryLexer lexer = new XQueryLexer(inputStream);
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        XQueryParser parser = new XQueryParser(tokenStream);
        ParseTree tree = parser.ap();

        System.out.print(tree.toStringTree(parser));
    }
}
