# Compiler Project

This project is a **simple compiler** for a custom programming language implemented using **ANTLR 4.8** and **Java**. The compiler includes three main phases: **Lexical Analysis**, **Syntax Analysis**, **Symbol Table Construction**, and **Semantic Analysis**.

---

## 📘 Features

- ✅ Uses **ANTLR 4.8** for automatic Lexer and Parser generation
- ✅ **Token extraction** and categorization into 6 different categories
- ✅ **Symbol table construction** with complete information (classes, methods, variables, parameters, etc.)
- ✅ **Semantic analysis** with various semantic error checking
- ✅ Support for **classes, interfaces, inheritance, and implementation**
- ✅ Output in both **TXT** and **HTML** formats for all results
- ✅ Automatic processing of multiple input files (Input1.java through InputN.java)

---

## 🧩 Project Structure

```
Compiler Project/
│
├── antlr-4.8-complete.jar      # ANTLR library
├── Language.g4                  # Grammar definition file
├── Main.java                    # Main entry point
│
├── TokenExtractor.java          # Token extraction and display
├── SymbolTableBuilder.java      # Symbol table construction and display
├── SemanticAnalyzer.java        # Semantic analysis and error checking
│
├── Scope.java                   # Scope management
├── Symbol.java                  # Symbol model
├── LanguageVisitorImpl.java     # Visitor implementation for symbol table construction
│
├── Input1.java ... Input4.java  # Sample input files for testing
├── grun.bat                     # Script to run grammar in ANTLR (Windows)
│
├── Input1/                      # Output files for Input1.java
│   ├── tokens.txt
│   ├── tokens.html
│   ├── symbol_table.txt
│   ├── symbol_table.html
│   └── semantic_errors.txt
│
├── Input2/                      # Output files for Input2.java
│   └── ...
│
└── .idea/ .git/ .iml           # IntelliJ IDEA configuration files
```

---

## ⚙️ How to Run

### 1. Prerequisites

- **Java 8 or higher**
- **ANTLR 4.8** (included as `antlr-4.8-complete.jar` in the project)

### 2. Generate Lexer and Parser

Run the following command in terminal or CMD:

```bash
java -jar antlr-4.8-complete.jar Language.g4
```

This will generate `LanguageLexer.java` and `LanguageParser.java` files.

### 3. Compile the Project

```bash
# Windows
javac -cp .;antlr-4.8-complete.jar *.java

# Linux/Mac
javac -cp .:antlr-4.8-complete.jar *.java
```

### 4. Run the Program

The program automatically processes all files from `Input1.java` to `InputN.java`:

```bash
# Windows
java -cp .;antlr-4.8-complete.jar Main

# Linux/Mac
java -cp .:antlr-4.8-complete.jar Main
```

The program will automatically:
- Find files `Input1.java`, `Input2.java`, `Input3.java`, ...
- Create directories named `Input1/`, `Input2/`, ... for each file
- Perform three main tasks for each file

---

## 📂 Output Files

After execution, three types of output files are generated for each input file:

### 1. Token Files

| File | Path | Description |
|------|------|-------------|
| `tokens.txt` | `InputN/tokens.txt` | Token list in text format |
| `tokens.html` | `InputN/tokens.html` | Token list in HTML format with syntax highlighting |

**Token Categories:**
- Keywords
- Identifiers
- Literals
- Operators
- Separators
- Comments

### 2. Symbol Table Files

| File | Path | Description |
|------|------|-------------|
| `symbol_table.txt` | `InputN/symbol_table.txt` | Symbol table in text format |
| `symbol_table.html` | `InputN/symbol_table.html` | Symbol table in HTML format with styling |

**Information stored in symbol table:**
- Name (symbol name)
- Type (data type)
- Kind (symbol type: class, method, field, variable, parameter, etc.)
- Scope
- Visibility (public, private, protected, internal)
- Parent (parent class)
- Interfaces (implemented interfaces)
- IsAbstract (whether it's abstract)
- IsOverride (whether it's an override)
- Params (parameter list)
- InitialValue (initial value)

### 3. Semantic Errors File

| File | Path | Description |
|------|------|-------------|
| `semantic_errors.txt` | `InputN/semantic_errors.txt` | List of semantic errors with line numbers |

---

## 🔍 Semantic Analysis

The semantic analyzer (`SemanticAnalyzer`) checks for various types of semantic errors:

### 1. Duplicate Definition Errors
- Duplicate class definitions
- Duplicate interface definitions
- Duplicate method definitions in the same scope
- Duplicate variable and parameter definitions

### 2. Inheritance Errors
- Circular inheritance in class hierarchy

### 3. Import Errors
- Importing undefined classes or interfaces

### 4. Access Errors
- Accessing `private` methods from outside the class
- Accessing `private` fields from outside the class

### 5. Parameter Mismatch Errors
- Parameter count mismatch in method calls
- Parameter type mismatch

### 6. Return Type Mismatch Errors
- Return value type mismatch with method definition
- Non-void methods that don't return a value
- Void methods that return a value

### 7. Assignment Type Mismatch Errors
- Assigning incompatible types (e.g., `int = String`)

### 8. Array Index Errors
- Using negative indices
- Using incorrect type for index (e.g., String instead of int)
- Index out of bounds (for constant indices)

### 9. Variable Access Errors
- Using undeclared variables
- Using variables in invalid scope

---

## 📋 Main Classes

| Class | Description |
|------|-------------|
| `Main.java` | Program entry point, automatically processes Input1 through InputN files |
| `Language.g4` | Grammar definition file |
| `TokenExtractor.java` | Extracts and categorizes tokens from Lexer |
| `SymbolTableBuilder.java` | Builds symbol table from Parse Tree |
| `SemanticAnalyzer.java` | Performs semantic analysis and error checking |
| `Symbol.java` | Symbol model (classes, methods, variables, etc.) |
| `Scope.java` | Manages scopes and symbol lookup |
| `LanguageVisitorImpl.java` | Visitor for traversing Parse Tree and building symbol table |

---

## 📝 Example Execution

### Input (Input1.java):
```java
class MainClass {
    public static void main(String[] args) {
        int x = 10;
        int y = x + 5;
    }
}
```

### Output (tokens.txt):
```
Category            | Text           | Line:Col
-----------------------------------------------------
Keywords            | class          | 1:1
Identifiers         | MainClass      | 1:7
...
```

### Output (symbol_table.txt):
```
Name        | Type    | Kind      | Scope              | Visibility | ...
MainClass   | class   | class     | class_MainClass    | public     | ...
main        | void    | method    | class_MainClass    | public     | ...
args        | String[]| parameter | method_main        |            | ...
x           | int     | variable  | method_main        |            | ...
y           | int     | variable  | method_main        |            | ...
```

### Output (semantic_errors.txt):
```
No semantic errors found.
```
Or if errors exist:
```
Line 5: Variable access error: Variable 'undefinedVar' is not declared
Line 10: Assignment type mismatch: Left side type (int) is incompatible with right side type (String)
```

---

## 🎯 Main Program Tasks

The program performs three main tasks for each input file:

### TASK 1: TOKEN EXTRACTION
- Extracts tokens from input file
- Categorizes tokens into 6 categories
- Generates `tokens.txt` and `tokens.html` files

### TASK 2: SYMBOL TABLE CONSTRUCTION
- Builds Parse Tree from input file
- Traverses Parse Tree using Visitor Pattern
- Constructs symbol table with all symbol information
- Generates `symbol_table.txt` and `symbol_table.html` files

### TASK 3: SEMANTIC ANALYSIS
- Performs semantic analysis based on symbol table and Parse Tree
- Checks for various semantic errors
- Generates `semantic_errors.txt` file with error list

---

## 📚 References

- [ANTLR 4 Documentation](https://www.antlr.org/)
- [ANTLR Mega Tutorial](https://tomassetti.me/antlr-mega-tutorial/)
- [Java ANTLR Integration Guide](https://github.com/antlr/antlr4/blob/master/doc/java-target.md)

---

## 👥 Developers

This project was developed by:

- **MohammadHosein Toghanian**
- **Sina Afzali**
- **Sasan Nikjoo**

---

## 📄 License

This project is designed for educational purposes. Use and modification are permitted with proper attribution.

---

## 🔧 Technical Notes

- The program uses **Visitor Pattern** for traversing Parse Tree
- Symbol table is managed as **Hierarchical Scope**
- Semantic analysis is performed based on **Symbol Table** and **Parse Tree**
- All error messages are in **Persian**
- HTML outputs are generated with appropriate **coloring** and **styling**

---

**Version:** 2.0  
**Last Updated:** 2024
