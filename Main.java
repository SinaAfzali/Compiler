import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.io.*;
import java.nio.file.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        String code = new String(Files.readAllBytes(Paths.get("input.java")));

        System.out.println("========================================");
        System.out.println("Running ANTLR Lexer & Parser...");
        System.out.println("========================================");

        LanguageLexer lexer = new LanguageLexer(CharStreams.fromString(code));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        LanguageParser parser = new LanguageParser(tokens);

        ParseTree tree = parser.program(); // توکن‌ها مصرف می‌شوند

        List<Token> allTokens = tokens.getTokens();

        // تولید tokens.txt با دسته‌بندی ۶گانه
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("tokens.txt"))) {
            writer.write("=== TOKENS EXTRACTED FROM input.java ===\n\n");

            int[] counts = new int[6]; // شناسه، عملگر، کلیدواژه، جداکننده، عدد، مقدار ثابت

            for (Token token : allTokens) {
                if (token.getChannel() != Token.DEFAULT_CHANNEL) continue;

                String category = getCategory(token);
                String text = escapeText(token.getText());

                writer.write(String.format("%-15s | %s\n", category, text));

                // شمارش
                switch (category) {
                    case "IDENTIFIER" -> counts[0]++;
                    case "OPERATOR"   -> counts[1]++;
                    case "KEYWORD"    -> counts[2]++;
                    case "DELIMITER"  -> counts[3]++;
                    case "NUMBER"     -> counts[4]++;
                    case "LITERAL"    -> counts[5]++;
                }
            }

            writer.write("\n=== SUMMARY ===\n");
            writer.write("1. Identifiers      : " + counts[0] + "\n");
            writer.write("2. Operators        : " + counts[1] + "\n");
            writer.write("3. Keywords         : " + counts[2] + "\n");
            writer.write("4. Delimiters       : " + counts[3] + "\n");
            writer.write("5. Numbers          : " + counts[4] + "\n");
            writer.write("6. Literals         : " + counts[5] + "\n");
            writer.write("Total visible tokens: " + Arrays.stream(counts).sum() + "\n");
        }

        System.out.println("Tokens successfully generated → tokens.txt");

        System.out.println("\n========================================");
        System.out.println("Building Symbol Table...");
        System.out.println("========================================");

        ParseTreeWalker walker = new ParseTreeWalker();
        SymbolTableBuilder builder = new SymbolTableBuilder();
        walker.walk(builder, tree);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("symbol_table.txt"))) {
            builder.getGlobalTable().printToFile(writer, 0);
        }

        System.out.println("\n========================================");
        System.out.println("Symbol table successfully generated → symbol_table.txt");
        System.out.println("========================================");
    }

    private static String getCategory(Token token) {
        int type = token.getType();

        // 1. شناسه‌ها
        if (type == LanguageLexer.IDENTIFIER) return "IDENTIFIER";

        // 2. عملگرها
        if (isOperator(type)) return "OPERATOR";

        // 3. کلمات کلیدی
        if (isKeyword(type)) return "KEYWORD";

        // 4. جداکننده‌ها
        if (isDelimiter(type)) return "DELIMITER";

        // 5. اعداد
        if (type == LanguageLexer.INTLIT) return "NUMBER";

        // 6. مقادیر ثابت
        if (isLiteral(type)) return "LITERAL";

        return "UNKNOWN";
    }

    private static boolean isOperator(int type) {
        return type == LanguageLexer.PLUS || type == LanguageLexer.MINUS ||
               type == LanguageLexer.MULT || type == LanguageLexer.DIV ||
               type == LanguageLexer.MOD || type == LanguageLexer.ASSIGN ||
               type == LanguageLexer.EQ || type == LanguageLexer.NEQ ||
               type == LanguageLexer.LT || type == LanguageLexer.GT ||
               type == LanguageLexer.LE || type == LanguageLexer.GE ||
               type == LanguageLexer.AND || type == LanguageLexer.OR ||
               type == LanguageLexer.NOT;
    }

    private static boolean isKeyword(int type) {
        return type == LanguageLexer.CLASS || type == LanguageLexer.INTERFACE ||
               type == LanguageLexer.EXTENDS || type == LanguageLexer.IMPLEMENTS ||
               type == LanguageLexer.PUBLIC || type == LanguageLexer.PRIVATE ||
               type == LanguageLexer.PROTECTED || type == LanguageLexer.STATIC ||
               type == LanguageLexer.ABSTRACT || type == LanguageLexer.VOID ||
               type == LanguageLexer.IF || type == LanguageLexer.ELSE ||
               type == LanguageLexer.WHILE || type == LanguageLexer.FOR ||
               type == LanguageLexer.BREAK || type == LanguageLexer.CONTINUE ||
               type == LanguageLexer.RETURN || type == LanguageLexer.NEW ||
               type == LanguageLexer.THIS || type == LanguageLexer.IMPORT ||
               type == LanguageLexer.BOOLEAN || type == LanguageLexer.INT ||
               type == LanguageLexer.CHAR || type == LanguageLexer.STRING;
    }

    private static boolean isDelimiter(int type) {
        return type == LanguageLexer.SEMI || type == LanguageLexer.COMMA ||
               type == LanguageLexer.LBRACE || type == LanguageLexer.RBRACE ||
               type == LanguageLexer.LBRACK || type == LanguageLexer.RBRACK ||
               type == LanguageLexer.LPAREN || type == LanguageLexer.RPAREN ||
               type == LanguageLexer.DOT;
    }

    private static boolean isLiteral(int type) {
        return type == LanguageLexer.STRINGLIT || type == LanguageLexer.CHARLIT ||
               type == LanguageLexer.BOOLEANLIT || type == LanguageLexer.NULLLIT;
    }

    private static String escapeText(String text) {
        if (text == null) return "";
        return text
            .replace("\n", "\\n")
            .replace("\r", "\\r")
            .replace("\t", "\\t");
    }
}