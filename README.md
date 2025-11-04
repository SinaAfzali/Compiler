
# Simple Compiler Project using ANTLR and Java

This project implements a **simple compiler** for a custom programming language using **ANTLR 4.8**.  
It performs **lexical analysis**, **syntax analysis**, and **symbol table generation**, producing output in both text and HTML formats.

---

## 📘 Features

- Built using **ANTLR 4.8** for automatic Lexer and Parser generation  
- Supports variable declarations, expressions, and conditional blocks  
- Generates **Symbol Table** and **Token List** for each input file  
- Outputs results in **TXT** and **HTML** formats  
- Modular structure with dedicated classes for Scope, Symbol, and Token management  

---

## 🧩 Project Structure


Compiler Project/

--- ├── antlr-4.8-complete.jar         # ANTLR library

--- ├── Language.g4                    # Grammar definition

--- ├── Main.java                      # Main entry point

--- ├── TokenExtractor.java            # Extracts and prints tokens

--- ├── SymbolTableBuilder.java        # Builds symbol table

--- ├── Scope.java / Symbol.java       # Models for scopes and symbols

--- ├── LanguageVisitorImpl.java       # Visitor implementation for grammar

--- ├── Input1.java ... Input4.java    # Sample input files for testing

--- ├── grun.bat                       # Run grammar in ANTLR (Windows)

--- ├── Input1/

------    ├── tokens.txt / tokens.html

------    └── symbol_table.txt / symbol_table.html

└── .idea / .git / .iml            # IntelliJ IDEA configuration files

---

## ⚙️ How to Run

### 1. Prerequisites
- **Java 8 or higher**
- **ANTLR 4.8**  
  (Already included as `antlr-4.8-complete.jar` in the project folder)

### 2. Generate Lexer and Parser
Run the following command in terminal or CMD:

```bash
java -jar antlr-4.8-complete.jar Language.g4
```

This will generate the files LanguageLexer.java and LanguageParser.java.
### 3. Compile the Project
```bash
javac -cp .;antlr-4.8-complete.jar *.java
```

(Use : instead of ; on Linux/Mac)

### 4. Run the Program
To run the program on an input file (e.g., Input1.java):
```bash
java -cp .;antlr-4.8-complete.jar Main Input1.java
```


## 📂 Output Files
After execution, two types of output files are generated for each input:

### Output--------------------------TypeExample---------------------------------------------------PathDescription

Tokens------------------------------Input1/tokens.txt, Input1/tokens.html-------------------------Token list output

Symbol Table------------------------Input1/symbol_table.txt, Input1/symbol_table.html-------------Symbol table output

## Main Classes
ClassDescriptionMain.javaEntry point, runs compilation stepsLanguage.g4Grammar definition fileSymbol.javaRepresents symbols (variables, functions, etc.)Scope.javaManages variable scopesSymbolTableBuilder.javaBuilds the symbol table from parse treeTokenExtractor.javaExtracts token list from LexerLanguageVisitorImpl.javaVisitor for parse tree traversal

## Example Execution
Input (Input1.java):
int x = 10;
int y = x + 5;

Output (tokens.txt):
INT    x    =    10    ;
INT    y    =    x    +    5    ;

Output (symbol_table.txt):
Name    Type    Scope
x       int     global
y       int     global


## References


ANTLR 4 Documentation


ANTLR Mega Tutorial


Java ANTLR Integration Guide



## Developer
#### Developed by:
MohammadHosein_Toghanian

Sina_Afzali

Sasan_Nikjoo

## License
This project is for educational purposes only. Usage and modification are permitted with proper attribution.
