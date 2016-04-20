// Generated from /home/lichkkkk/git/xquery-processor/src/main/resource/XPath.g4 by ANTLR 4.5.1
package xquery.antlr;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link XPathParser}.
 */
public interface XPathListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link XPathParser#init}.
	 * @param ctx the parse tree
	 */
	void enterInit(XPathParser.InitContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPathParser#init}.
	 * @param ctx the parse tree
	 */
	void exitInit(XPathParser.InitContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPathParser#value}.
	 * @param ctx the parse tree
	 */
	void enterValue(XPathParser.ValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPathParser#value}.
	 * @param ctx the parse tree
	 */
	void exitValue(XPathParser.ValueContext ctx);
}