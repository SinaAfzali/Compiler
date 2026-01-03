import java.io.FileNotFoundException;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.File;

public class Main {
    public static void main(String[] args) throws Exception {
        int fileNum = 1;
        while (true) {
            String inputFile = "Input" + fileNum + ".java";
            File input = new File(inputFile);
            if (!input.exists()) {
                if (fileNum == 1) {
                    System.err.println("خطا: هیچ فایلی با نام Input1.java پیدا نشد!");
                } else {
                    System.out.println("پردازش تمام شد. " + (fileNum - 1) + " فایل پردازش شد.");
                }
                break;
            }

            String outputDir = "Input" + fileNum;
            File dir = new File(outputDir);
            if (!dir.exists()) {
                dir.mkdirs(); // Create directory if not exists
            }

            System.out.println("\n=== پردازش فایل: " + inputFile + " ===");
            System.out.println("TASK 1: TOKEN EXTRACTION");
            try {
                TokenExtractor.extractTokens(inputFile, outputDir);
            } catch (FileNotFoundException e) {
                System.err.println("خطا: فایل " + inputFile + " پیدا نشد!");
                break;
            }

            System.out.println("\nTASK 2: SYMBOL TABLE CONSTRUCTION");
            SymbolTableBuilder.buildAndPrint(inputFile, outputDir);

            System.out.println("\nTASK 3: SEMANTIC ANALYSIS");
            SemanticAnalyzer.analyze(inputFile, outputDir);

            fileNum++;
        }
    }
}