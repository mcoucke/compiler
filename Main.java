import org.antlr.v4.runtime.*;

public class Main {

    public static void main(String[] args) throws Exception {
        String file = args.length==0 ? "toto.pas" : args[0];

        CharStream input = CharStreams.fromFileName(file);
        PascalLexer lexer = new PascalLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        PascalParser parser = new PascalParser(tokens);
        Instruction[] pCode = parser.lire();
        if (pCode !=null) {
            PMachine machine = new PMachine(pCode);
            System.out.println(machine);
            System.out.println(parser.table);
            machine.exec();
        }
    }
}
