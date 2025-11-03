import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.tree.ParseTree;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;
import java.io.PrintWriter;
import java.util.ArrayList;

public class SymbolTableBuilder {
    public static void buildAndPrint(String inputFile, String outputDir) throws Exception {
        InputStream is = new FileInputStream(inputFile);

        LanguageLexer lexer = new LanguageLexer(CharStreams.fromStream(is));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        LanguageParser parser = new LanguageParser(tokens);
        ParseTree tree = parser.program();

        if (parser.getNumberOfSyntaxErrors() > 0) {
            System.err.println("Syntax errors found. Cannot build symbol table.");
            return;
        }

        LanguageVisitorImpl visitor = new LanguageVisitorImpl();
        visitor.visit(tree);

        Scope st = visitor.getSymbolTable();
        List<Symbol> symbols = st.getAllSymbols();

        // Console print with tabs for flexible alignment
        System.out.println("\n=== SYMBOL TABLE (Full Project Spec) ===");
        System.out.println("Name\t| Type\t| Kind\t| Scope\t| Visibility\t| Parent\t| Interfaces\t| IsAbstract\t| IsOverride\t| Params\t| InitialValue");
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------");
        for (Symbol sym : symbols) {
            String vis = sym.getVisibility() != null ? sym.getVisibility() : "";
            String abs = sym.isAbstract() ? "true" : "false";
            String over = sym.isOverride() ? "true" : "false";
            String params = sym.getParameterList() != null ? sym.getParameterList() : "";
            String initial = sym.getInitialValue() != null ? sym.getInitialValue() : "";
            System.out.println(sym.getName() + "\t| " + sym.getType() + "\t| " + sym.getKind() + "\t| " + sym.getScope() + "\t| " + vis + "\t| " + sym.getParent() + "\t| " + sym.getImplementedInterfaces() + "\t| " + abs + "\t| " + over + "\t| " + params + "\t| " + initial);
        }

        if (symbols.isEmpty()) {
            System.out.println("No symbols found. Check visitor logic.");
        }

        PrintWriter txtWriter = null;
        StringBuilder htmlBuilder = new StringBuilder();
        try {
            String txtPath = outputDir + "/symbol_table.txt";
            txtWriter = new PrintWriter(txtPath, "UTF-8");
            htmlBuilder.append("<!DOCTYPE html>\n<html lang='fa' dir='rtl'><head><meta charset='UTF-8'><title>جدول نمادها</title>\n");
            htmlBuilder.append("<style>\n");
            htmlBuilder.append("body {font-family: 'Tahoma', Arial, sans-serif; margin: 20px; background: linear-gradient(to bottom, #f0f8ff, #e6f3ff); color: #333;}\n");
            htmlBuilder.append("h2 {color: #2c3e50; text-align: center; border-bottom: 4px solid #e74c3c; padding-bottom: 15px; font-size: 24px; text-shadow: 1px 1px 2px rgba(0,0,0,0.1);}\n");
            htmlBuilder.append("table {border-collapse: collapse; width: 100%; margin: 20px 0; box-shadow: 0 4px 15px rgba(0,0,0,0.1); background: white; border-radius: 10px; overflow-x: auto;}\n");
            htmlBuilder.append("th, td {border: 1px solid #bdc3c7; padding: 8px; text-align: right; transition: all 0.3s ease;}\n");
            htmlBuilder.append("th {background: linear-gradient(135deg, #e74c3c, #c0392b); color: white; font-weight: bold; text-shadow: 0 1px 2px rgba(0,0,0,0.3);}\n");
            htmlBuilder.append("tr:nth-child(even) {background-color: #f8f9fa;}\n");
            htmlBuilder.append("tr:hover {background-color: #fff3cd !important;}\n");
            htmlBuilder.append(".kind-method {background-color: #d5f4e6 !important; color: #27ae60;}\n");
            htmlBuilder.append(".kind-field {background-color: #d1ecf1 !important; color: #17a2b8;}\n");
            htmlBuilder.append(".kind-parameter {background-color: #fff3cd !important; color: #856404;}\n");
            htmlBuilder.append(".kind-variable {background-color: #f8d7da !important; color: #721c24;}\n");
            htmlBuilder.append(".kind-interface_field, .kind-interface_method {background-color: #e2e3e5 !important; color: #6c757d; font-style: italic;}\n");
            htmlBuilder.append(".kind-class {background-color: #e3f2fd !important; color: #1976d2;}\n");
            htmlBuilder.append(".kind-interface {background-color: #f3e5f5 !important; color: #7b1fa2;}\n");
            htmlBuilder.append(".footer {text-align: center; margin-top: 20px; font-size: 16px; color: #7f8c8d; background: #ecf0f1; padding: 10px; border-radius: 5px;}\n");
            htmlBuilder.append("</style></head><body><h2>جدول نمادهای استخراج‌شده (مشخصات کامل پروژه)</h2><table><tr><th>نام</th><th>نوع</th><th>نوع نماد</th><th>Scope</th><th>دسترسی</th><th>والد</th><th>اینترفیس‌ها</th><th>Abstract?</th><th>Override?</th><th>پارامترها</th><th>مقدار اولیه</th></th></table>");

            // Write to TXT
            txtWriter.println("=== SYMBOL TABLE (Full Project Spec) ===");
            txtWriter.println("Name\t| Type\t| Kind\t| Scope\t| Visibility\t| Parent\t| Interfaces\t| IsAbstract\t| IsOverride\t| Params\t| InitialValue");
            txtWriter.println("---------------------------------------------------------------------------------------------------------------------------------------------------");
            for (Symbol sym : symbols) {
                String vis = sym.getVisibility() != null ? sym.getVisibility() : "";
                String abs = sym.isAbstract() ? "true" : "false";
                String over = sym.isOverride() ? "true" : "false";
                String params = sym.getParameterList() != null ? sym.getParameterList() : "";
                String initial = sym.getInitialValue() != null ? sym.getInitialValue() : "";
                txtWriter.println(sym.getName() + "\t| " + sym.getType() + "\t| " + sym.getKind() + "\t| " + sym.getScope() + "\t| " + vis + "\t| " + sym.getParent() + "\t| " + sym.getImplementedInterfaces() + "\t| " + abs + "\t| " + over + "\t| " + params + "\t| " + initial);
            }

            if (symbols.isEmpty()) {
                txtWriter.println("No symbols found. Check visitor logic.");
            } else {
                txtWriter.println("Total symbols: " + symbols.size());
            }

            // HTML rows
            for (Symbol sym : symbols) {
                String vis = sym.getVisibility() != null ? sym.getVisibility() : "";
                String abs = sym.isAbstract() ? "بله" : "خیر";
                String over = sym.isOverride() ? "بله" : "خیر";
                String params = sym.getParameterList() != null ? sym.getParameterList() : "";
                String initial = sym.getInitialValue() != null ? sym.getInitialValue() : "";
                String kindClass = "kind-" + sym.getKind().replace("_", "");
                htmlBuilder.append("<tr class='" + kindClass + "'>");
                htmlBuilder.append("<td>" + escapeHtml(sym.getName()) + "</td><td>" + escapeHtml(sym.getType()) + "</td><td>" + escapeHtml(sym.getKind()) + "</td>");
                htmlBuilder.append("<td>" + escapeHtml(sym.getScope()) + "</td><td>" + escapeHtml(vis) + "</td><td>" + escapeHtml(sym.getParent()) + "</td>");
                htmlBuilder.append("<td>" + escapeHtml(sym.getImplementedInterfaces()) + "</td><td>" + abs + "</td><td>" + over + "</td>");
                htmlBuilder.append("<td>" + escapeHtml(params) + "</td><td>" + escapeHtml(initial) + "</td>");
                htmlBuilder.append("</tr>");
            }

            htmlBuilder.append("</table><div class='footer'>تعداد کل نمادها: " + symbols.size() + "</div></body></html>");

        } finally {
            if (txtWriter != null) txtWriter.close();
        }

        // Write HTML
        try (PrintWriter htmlWriter = new PrintWriter(outputDir + "/symbol_table.html", "UTF-8")) {
            htmlWriter.print(htmlBuilder.toString());
            System.out.println("Symbol table saved to " + outputDir + "/symbol_table.txt and " + outputDir + "/symbol_table.html");
        } catch (Exception e) {
            System.err.println("Error writing files: " + e.getMessage());
        }
    }

    private static String escapeHtml(String str) {
        if (str == null) return "";
        String escaped = str;
        escaped = escaped.replace("&", "&amp;");
        escaped = escaped.replace("<", "&lt;");
        escaped = escaped.replace(">", "&gt;");
        escaped = escaped.replace("\"", "&quot;");
        escaped = escaped.replace("'", "&#39;");
        return escaped;
    }
}