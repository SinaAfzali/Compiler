import org.antlr.v4.runtime.*;
import java.nio.file.*;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class Code {
    public static void main(String[] args) throws Exception {
        String code = new String(Files.readAllBytes(Paths.get("Code.java")));
        Language lexer = new Language(CharStreams.fromString(code));
        Token t;

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("tokens.txt"))) {
            while ((t = lexer.nextToken()).getType() != Token.EOF) {
                String name = lexer.getVocabulary().getSymbolicName(t.getType());
                if ("IDENTIFIER".equals(name) || name.matches("PLUS|MINUS|MULT|DIV|MOD|POWER|EQ|NEQ|LT|GT|LE|GE|AND|OR|NOT|ASSIGN")) {
                    writer.write((name == "IDENTIFIER" ? name : "OPERATOR-" + name) + " : " + t.getText());
                    writer.newLine();
                }
            }
        }

        System.out.println("Tokens saved to tokens.txt");
    }
}
