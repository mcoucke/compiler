// Generated from D:/M1/Compil/projetcompilation\Pascal.g4 by ANTLR 4.8

    import java.util.*;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link PascalParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface PascalVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link PascalParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(PascalParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link PascalParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(PascalParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link PascalParser#deftypes}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeftypes(PascalParser.DeftypesContext ctx);
	/**
	 * Visit a parse tree produced by {@link PascalParser#deftype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeftype(PascalParser.DeftypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link PascalParser#vars}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVars(PascalParser.VarsContext ctx);
	/**
	 * Visit a parse tree produced by {@link PascalParser#var}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVar(PascalParser.VarContext ctx);
	/**
	 * Visit a parse tree produced by {@link PascalParser#defprocs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefprocs(PascalParser.DefprocsContext ctx);
	/**
	 * Visit a parse tree produced by {@link PascalParser#defproc}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefproc(PascalParser.DefprocContext ctx);
	/**
	 * Visit a parse tree produced by {@link PascalParser#defparams}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefparams(PascalParser.DefparamsContext ctx);
	/**
	 * Visit a parse tree produced by {@link PascalParser#defparam}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefparam(PascalParser.DefparamContext ctx);
	/**
	 * Visit a parse tree produced by {@link PascalParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(PascalParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link PascalParser#insts}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInsts(PascalParser.InstsContext ctx);
	/**
	 * Visit a parse tree produced by {@link PascalParser#inst}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInst(PascalParser.InstContext ctx);
	/**
	 * Visit a parse tree produced by {@link PascalParser#read}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRead(PascalParser.ReadContext ctx);
	/**
	 * Visit a parse tree produced by {@link PascalParser#write}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWrite(PascalParser.WriteContext ctx);
	/**
	 * Visit a parse tree produced by {@link PascalParser#affect}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAffect(PascalParser.AffectContext ctx);
	/**
	 * Visit a parse tree produced by {@link PascalParser#forinst}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForinst(PascalParser.ForinstContext ctx);
	/**
	 * Visit a parse tree produced by {@link PascalParser#ifinst}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfinst(PascalParser.IfinstContext ctx);
	/**
	 * Visit a parse tree produced by {@link PascalParser#whileinst}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileinst(PascalParser.WhileinstContext ctx);
	/**
	 * Visit a parse tree produced by {@link PascalParser#repeatinst}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRepeatinst(PascalParser.RepeatinstContext ctx);
	/**
	 * Visit a parse tree produced by {@link PascalParser#callproc}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCallproc(PascalParser.CallprocContext ctx);
	/**
	 * Visit a parse tree produced by {@link PascalParser#params}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParams(PascalParser.ParamsContext ctx);
	/**
	 * Visit a parse tree produced by {@link PascalParser#param}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParam(PascalParser.ParamContext ctx);
	/**
	 * Visit a parse tree produced by {@link PascalParser#comp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComp(PascalParser.CompContext ctx);
	/**
	 * Visit a parse tree produced by {@link PascalParser#boolval}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolval(PascalParser.BoolvalContext ctx);
	/**
	 * Visit a parse tree produced by {@link PascalParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(PascalParser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link PascalParser#operation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOperation(PascalParser.OperationContext ctx);
	/**
	 * Visit a parse tree produced by {@link PascalParser#multexpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultexpr(PascalParser.MultexprContext ctx);
	/**
	 * Visit a parse tree produced by {@link PascalParser#divexpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDivexpr(PascalParser.DivexprContext ctx);
	/**
	 * Visit a parse tree produced by {@link PascalParser#adresse}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdresse(PascalParser.AdresseContext ctx);
}