// Generated from /home/lichkkkk/git/xquery-processor/src/main/resource/XQuery.g4 by ANTLR 4.5.1
package xquery.antlr;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link XQueryParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface XQueryVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link XQueryParser#ap}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAp(XQueryParser.ApContext ctx);
	/**
	 * Visit a parse tree produced by {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRp(XQueryParser.RpContext ctx);
	/**
	 * Visit a parse tree produced by {@link XQueryParser#f}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitF(XQueryParser.FContext ctx);
	/**
	 * Visit a parse tree produced by {@link XQueryParser#file_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFile_name(XQueryParser.File_nameContext ctx);
	/**
	 * Visit a parse tree produced by {@link XQueryParser#tag_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTag_name(XQueryParser.Tag_nameContext ctx);
	/**
	 * Visit a parse tree produced by {@link XQueryParser#att_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtt_name(XQueryParser.Att_nameContext ctx);
}