// Generated from D:/M1/Compil/projetcompilation\Pascal.g4 by ANTLR 4.8

    import java.util.*;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link PascalParser}.
 */
public interface PascalListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link PascalParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(PascalParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link PascalParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(PascalParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link PascalParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(PascalParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link PascalParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(PascalParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link PascalParser#deftypes}.
	 * @param ctx the parse tree
	 */
	void enterDeftypes(PascalParser.DeftypesContext ctx);
	/**
	 * Exit a parse tree produced by {@link PascalParser#deftypes}.
	 * @param ctx the parse tree
	 */
	void exitDeftypes(PascalParser.DeftypesContext ctx);
	/**
	 * Enter a parse tree produced by {@link PascalParser#deftype}.
	 * @param ctx the parse tree
	 */
	void enterDeftype(PascalParser.DeftypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link PascalParser#deftype}.
	 * @param ctx the parse tree
	 */
	void exitDeftype(PascalParser.DeftypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link PascalParser#vars}.
	 * @param ctx the parse tree
	 */
	void enterVars(PascalParser.VarsContext ctx);
	/**
	 * Exit a parse tree produced by {@link PascalParser#vars}.
	 * @param ctx the parse tree
	 */
	void exitVars(PascalParser.VarsContext ctx);
	/**
	 * Enter a parse tree produced by {@link PascalParser#var}.
	 * @param ctx the parse tree
	 */
	void enterVar(PascalParser.VarContext ctx);
	/**
	 * Exit a parse tree produced by {@link PascalParser#var}.
	 * @param ctx the parse tree
	 */
	void exitVar(PascalParser.VarContext ctx);
	/**
	 * Enter a parse tree produced by {@link PascalParser#defprocs}.
	 * @param ctx the parse tree
	 */
	void enterDefprocs(PascalParser.DefprocsContext ctx);
	/**
	 * Exit a parse tree produced by {@link PascalParser#defprocs}.
	 * @param ctx the parse tree
	 */
	void exitDefprocs(PascalParser.DefprocsContext ctx);
	/**
	 * Enter a parse tree produced by {@link PascalParser#defproc}.
	 * @param ctx the parse tree
	 */
	void enterDefproc(PascalParser.DefprocContext ctx);
	/**
	 * Exit a parse tree produced by {@link PascalParser#defproc}.
	 * @param ctx the parse tree
	 */
	void exitDefproc(PascalParser.DefprocContext ctx);
	/**
	 * Enter a parse tree produced by {@link PascalParser#defparams}.
	 * @param ctx the parse tree
	 */
	void enterDefparams(PascalParser.DefparamsContext ctx);
	/**
	 * Exit a parse tree produced by {@link PascalParser#defparams}.
	 * @param ctx the parse tree
	 */
	void exitDefparams(PascalParser.DefparamsContext ctx);
	/**
	 * Enter a parse tree produced by {@link PascalParser#defparam}.
	 * @param ctx the parse tree
	 */
	void enterDefparam(PascalParser.DefparamContext ctx);
	/**
	 * Exit a parse tree produced by {@link PascalParser#defparam}.
	 * @param ctx the parse tree
	 */
	void exitDefparam(PascalParser.DefparamContext ctx);
	/**
	 * Enter a parse tree produced by {@link PascalParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(PascalParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link PascalParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(PascalParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link PascalParser#insts}.
	 * @param ctx the parse tree
	 */
	void enterInsts(PascalParser.InstsContext ctx);
	/**
	 * Exit a parse tree produced by {@link PascalParser#insts}.
	 * @param ctx the parse tree
	 */
	void exitInsts(PascalParser.InstsContext ctx);
	/**
	 * Enter a parse tree produced by {@link PascalParser#inst}.
	 * @param ctx the parse tree
	 */
	void enterInst(PascalParser.InstContext ctx);
	/**
	 * Exit a parse tree produced by {@link PascalParser#inst}.
	 * @param ctx the parse tree
	 */
	void exitInst(PascalParser.InstContext ctx);
	/**
	 * Enter a parse tree produced by {@link PascalParser#read}.
	 * @param ctx the parse tree
	 */
	void enterRead(PascalParser.ReadContext ctx);
	/**
	 * Exit a parse tree produced by {@link PascalParser#read}.
	 * @param ctx the parse tree
	 */
	void exitRead(PascalParser.ReadContext ctx);
	/**
	 * Enter a parse tree produced by {@link PascalParser#write}.
	 * @param ctx the parse tree
	 */
	void enterWrite(PascalParser.WriteContext ctx);
	/**
	 * Exit a parse tree produced by {@link PascalParser#write}.
	 * @param ctx the parse tree
	 */
	void exitWrite(PascalParser.WriteContext ctx);
	/**
	 * Enter a parse tree produced by {@link PascalParser#affect}.
	 * @param ctx the parse tree
	 */
	void enterAffect(PascalParser.AffectContext ctx);
	/**
	 * Exit a parse tree produced by {@link PascalParser#affect}.
	 * @param ctx the parse tree
	 */
	void exitAffect(PascalParser.AffectContext ctx);
	/**
	 * Enter a parse tree produced by {@link PascalParser#forinst}.
	 * @param ctx the parse tree
	 */
	void enterForinst(PascalParser.ForinstContext ctx);
	/**
	 * Exit a parse tree produced by {@link PascalParser#forinst}.
	 * @param ctx the parse tree
	 */
	void exitForinst(PascalParser.ForinstContext ctx);
	/**
	 * Enter a parse tree produced by {@link PascalParser#ifinst}.
	 * @param ctx the parse tree
	 */
	void enterIfinst(PascalParser.IfinstContext ctx);
	/**
	 * Exit a parse tree produced by {@link PascalParser#ifinst}.
	 * @param ctx the parse tree
	 */
	void exitIfinst(PascalParser.IfinstContext ctx);
	/**
	 * Enter a parse tree produced by {@link PascalParser#whileinst}.
	 * @param ctx the parse tree
	 */
	void enterWhileinst(PascalParser.WhileinstContext ctx);
	/**
	 * Exit a parse tree produced by {@link PascalParser#whileinst}.
	 * @param ctx the parse tree
	 */
	void exitWhileinst(PascalParser.WhileinstContext ctx);
	/**
	 * Enter a parse tree produced by {@link PascalParser#repeatinst}.
	 * @param ctx the parse tree
	 */
	void enterRepeatinst(PascalParser.RepeatinstContext ctx);
	/**
	 * Exit a parse tree produced by {@link PascalParser#repeatinst}.
	 * @param ctx the parse tree
	 */
	void exitRepeatinst(PascalParser.RepeatinstContext ctx);
	/**
	 * Enter a parse tree produced by {@link PascalParser#callproc}.
	 * @param ctx the parse tree
	 */
	void enterCallproc(PascalParser.CallprocContext ctx);
	/**
	 * Exit a parse tree produced by {@link PascalParser#callproc}.
	 * @param ctx the parse tree
	 */
	void exitCallproc(PascalParser.CallprocContext ctx);
	/**
	 * Enter a parse tree produced by {@link PascalParser#params}.
	 * @param ctx the parse tree
	 */
	void enterParams(PascalParser.ParamsContext ctx);
	/**
	 * Exit a parse tree produced by {@link PascalParser#params}.
	 * @param ctx the parse tree
	 */
	void exitParams(PascalParser.ParamsContext ctx);
	/**
	 * Enter a parse tree produced by {@link PascalParser#param}.
	 * @param ctx the parse tree
	 */
	void enterParam(PascalParser.ParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link PascalParser#param}.
	 * @param ctx the parse tree
	 */
	void exitParam(PascalParser.ParamContext ctx);
	/**
	 * Enter a parse tree produced by {@link PascalParser#comp}.
	 * @param ctx the parse tree
	 */
	void enterComp(PascalParser.CompContext ctx);
	/**
	 * Exit a parse tree produced by {@link PascalParser#comp}.
	 * @param ctx the parse tree
	 */
	void exitComp(PascalParser.CompContext ctx);
	/**
	 * Enter a parse tree produced by {@link PascalParser#boolval}.
	 * @param ctx the parse tree
	 */
	void enterBoolval(PascalParser.BoolvalContext ctx);
	/**
	 * Exit a parse tree produced by {@link PascalParser#boolval}.
	 * @param ctx the parse tree
	 */
	void exitBoolval(PascalParser.BoolvalContext ctx);
	/**
	 * Enter a parse tree produced by {@link PascalParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(PascalParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link PascalParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(PascalParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link PascalParser#operation}.
	 * @param ctx the parse tree
	 */
	void enterOperation(PascalParser.OperationContext ctx);
	/**
	 * Exit a parse tree produced by {@link PascalParser#operation}.
	 * @param ctx the parse tree
	 */
	void exitOperation(PascalParser.OperationContext ctx);
	/**
	 * Enter a parse tree produced by {@link PascalParser#multexpr}.
	 * @param ctx the parse tree
	 */
	void enterMultexpr(PascalParser.MultexprContext ctx);
	/**
	 * Exit a parse tree produced by {@link PascalParser#multexpr}.
	 * @param ctx the parse tree
	 */
	void exitMultexpr(PascalParser.MultexprContext ctx);
	/**
	 * Enter a parse tree produced by {@link PascalParser#divexpr}.
	 * @param ctx the parse tree
	 */
	void enterDivexpr(PascalParser.DivexprContext ctx);
	/**
	 * Exit a parse tree produced by {@link PascalParser#divexpr}.
	 * @param ctx the parse tree
	 */
	void exitDivexpr(PascalParser.DivexprContext ctx);
	/**
	 * Enter a parse tree produced by {@link PascalParser#adresse}.
	 * @param ctx the parse tree
	 */
	void enterAdresse(PascalParser.AdresseContext ctx);
	/**
	 * Exit a parse tree produced by {@link PascalParser#adresse}.
	 * @param ctx the parse tree
	 */
	void exitAdresse(PascalParser.AdresseContext ctx);
}