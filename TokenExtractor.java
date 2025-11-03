import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.CharStreams;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.PrintWriter;
import java.util.Set;
import java.util.HashSet;

public class TokenExtractor {
    private static final Set<String> KEYWORDS = new HashSet<>(Set.of(
        "'class'", "'public'", "'static'", "'void'", "'main'", "'String'", "'int'", "'print'", "'if'", "'else'", "'while'", "'for'", "'read'", "'break'", "'continue'", "'return'", "'abstract'", "'extends'", "'implements'", "'interface'", "'private'", "'protected'", "'internal'", "'@Override'", "'new'", "'this'", "'true'", "'false'", "'null'", "'boolean'", "'char'"
    ));

    public static void extractTokens(String inputFile, String outputDir) throws Exception {
        InputStream is = new FileInputStream(inputFile);

        LanguageLexer lexer = new LanguageLexer(CharStreams.fromStream(is));
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        tokens.fill();

        // Console print with categories
        System.out.println("=== TOKENS EXTRACTED (Categorized into 6 Types) ===");
        System.out.printf("%-20s | %-15s | %s\n", "Category", "Text", "Line:Col");
        System.out.println("-----------------------------------------------------");

        int count = 0;
        boolean hasTokens = false;
        PrintWriter txtWriter = null;
        StringBuilder htmlBuilder = new StringBuilder();
        try {
            String txtPath = outputDir + "/tokens.txt";
            String htmlPath = outputDir + "/tokens.html";
            txtWriter = new PrintWriter(txtPath, "UTF-8");
            htmlBuilder.append("<!DOCTYPE html>\n<html lang='fa' dir='rtl'><head><meta charset='UTF-8'><title>جدول توکن‌های استخراج‌شده</title>\n");
            htmlBuilder.append("<style>\n");
            htmlBuilder.append("body {font-family: 'Tahoma', Arial, sans-serif; margin: 20px; background-color: #f9f9f9; color: #333;}\n");
            htmlBuilder.append("h2 {color: #2c3e50; text-align: center; border-bottom: 3px solid #3498db; padding-bottom: 10px;}\n");
            htmlBuilder.append("table {border-collapse: collapse; width: 100%; margin: 20px 0; box-shadow: 0 2px 10px rgba(0,0,0,0.1); background: white; border-radius: 8px; overflow: hidden;}\n");
            htmlBuilder.append("th, td {border: 1px solid #ddd; padding: 12px; text-align: right; transition: background 0.3s;}\n");
            htmlBuilder.append("th {background: linear-gradient(135deg, #3498db, #2980b9); color: white; font-weight: bold; text-shadow: 0 1px 2px rgba(0,0,0,0.2);}\n");
            htmlBuilder.append("tr:nth-child(even) {background-color: #f8f9fa;}\n");
            htmlBuilder.append("tr:hover {background-color: #e8f4fd !important; transform: scale(1.01); box-shadow: 0 2px 5px rgba(0,0,0,0.1);}\n");
            htmlBuilder.append("td:first-child {font-weight: bold; color: #27ae60;}\n");
            htmlBuilder.append(".footer {text-align: center; margin-top: 20px; font-size: 14px; color: #7f8c8d;}\n");
            htmlBuilder.append("@media (max-width: 768px) {table {font-size: 12px; overflow-x: auto; display: block; white-space: nowrap;}}\n");
            htmlBuilder.append("</style>\n</head><body><h2>توکن‌های استخراج‌شده از فایل (دسته‌بندی شده به 6 نوع)</h2><table><tr><th>دسته‌بندی</th><th>متن</th><th>خط</th><th>ستون</th></tr>\n");

            txtWriter.println("=== TOKENS EXTRACTED (Categorized into 6 Types) ===");
            txtWriter.printf("%-20s | %-15s | %s\n", "Category", "Text", "Line:Col");
            txtWriter.println("-----------------------------------------------------");

            for (Token token : tokens.getTokens()) {
                if (token.getType() == Token.EOF) {
                    break;
                }
                int typeIndex = token.getType();
                String type = LanguageLexer.VOCABULARY.getSymbolicName(typeIndex);
                if (type == null) {
                    type = LanguageLexer.VOCABULARY.getLiteralName(typeIndex);
                    if (type == null) {
                        type = "UNKNOWN: " + typeIndex;
                    }
                }
                String text = token.getText();
                if (text != null && !text.trim().isEmpty()) {
                    String category = getTokenCategory(type, text);
                    System.out.printf("%-20s | %-15s | %d:%d\n", category, text, token.getLine(), token.getCharPositionInLine() + 1);
                    txtWriter.printf("%-20s | %-15s | %d:%d\n", category, text, token.getLine(), token.getCharPositionInLine() + 1);

                    htmlBuilder.append("<tr><td>").append(escapeHtml(category)).append("</td><td>").append(escapeHtml(text)).append("</td><td>")
                               .append(token.getLine()).append("</td><td>").append(token.getCharPositionInLine() + 1).append("</td></tr>\n");
                    count++;
                    hasTokens = true;
                }
            }
            if (!hasTokens) {
                System.out.println("ERROR: No tokens! File content (first 5 lines):");
                try {
                    Files.readString(Paths.get(inputFile)).lines().limit(5).forEach(System.out::println);
                } catch (IOException e) {
                    System.out.println("Cannot read file for debug.");
                }
            } else {
                System.out.println("Total tokens: " + count);
                txtWriter.println("Total tokens: " + count);
                htmlBuilder.append("</table><div class='footer'>تعداد کل توکن‌ها: ").append(count).append("</div>");
            }

            // Close HTML
            htmlBuilder.append("</body></html>");
        } finally {
            if (txtWriter != null) txtWriter.close();
        }

        // Write HTML
        try (PrintWriter htmlWriter = new PrintWriter(outputDir + "/tokens.html", "UTF-8")) {
            htmlWriter.print(htmlBuilder.toString());
            System.out.println("Tokens saved to " + outputDir + "/tokens.txt and " + outputDir + "/tokens.html");
        } catch (Exception e) {
            System.err.println("Error writing files: " + e.getMessage());
        }
    }

    private static String getTokenCategory(String type, String text) {
        if (KEYWORDS.contains(type)) {
            return "Keywords";
        } else if ("Identifier".equals(type)) {
            return "Identifiers";
        } else if (type.endsWith("Literal")) {
            return "Literals";
        } else if (isOperator(type)) {
            return "Operators";
        } else if (isSeparator(type)) {
            return "Separators";
        } else if ("LINE_COMMENT".equals(type) || "MULTILINE_COMMENT".equals(type)) {
            return "Comments";
        } else {
            return "Others";
        }
    }

    private static boolean isOperator(String type) {
        return "AND".equals(type) || "OR".equals(type) || "LT".equals(type) || "LE".equals(type) || "GT".equals(type) || "GE".equals(type) ||
               "EQEQ".equals(type) || "NEQ".equals(type) || "PLUS".equals(type) || "MINUS".equals(type) || "TIMES".equals(type) || "DIV".equals(type) ||
               "MOD".equals(type) || "POWER".equals(type) || "NOT".equals(type) || "DOTLENGTH".equals(type) || "EQ".equals(type);
    }

    private static boolean isSeparator(String type) {
        return "LP".equals(type) || "RP".equals(type) || "LSB".equals(type) || "RSB".equals(type) ||
               "'{'".equals(type) || "'}'".equals(type) || "';'".equals(type);
    }

    private static String escapeHtml(String str) {
        if (str == null) return "";
        return str.replace("&", "&amp;").replace("<", "&lt;").replace(">", "&gt;").replace("\"", "&quot;").replace("'", "&#39;");
    }
}