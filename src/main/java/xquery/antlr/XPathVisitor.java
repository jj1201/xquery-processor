// Generated from /home/lichkkkk/git/xquery-processor/src/main/resource/XPath.g4 by ANTLR 4.5.1
package xquery.antlr;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link XPathParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface XPathVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link XPathParser#init}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInit(XPathParser.InitContext ctx);
	/**
	 * Visit a parse tree produced by {@link XPathParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValue(XPathParser.ValueContext ctx);
}