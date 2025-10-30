# Lexical Analyzer & Symbol Table - Compiler Design Project

## 📖 Project Overview
**first phase**
The goal of this project is to **implement a Lexical Analyzer** and a **Symbol Table** in **Java** for a simplified version of the Java language (Java--).

### 🧠 Objectives
- Recognize and categorize tokens:
  - **Identifiers** (class names, method names, variables, etc.)
  - **Operators** (arithmetic, relational, logical, assignment, access)
  - **Keywords** (`class`, `public`, `if`, `else`, etc.)
  - **Delimiters** (`;`, `{}`, `()`, `[]`, `,`, `.`)
  - **Numbers** (integer literals)
  - **Literals** (string, char, boolean, null)
- Handle **invalid tokens** gracefully with clear error messages.
- Construct a **Symbol Table** to store information about identifiers, considering **scope hierarchy** (global, class, method, block).

---

## ⚙️ Features

### Lexical Analyzer
- Implemented in Java using **ANTLR**.
- Reads a source file in simplified Java syntax.
- Outputs a structured list of recognized tokens.

### Symbol Table
- Implemented as a **nested HashTable** (to represent scopes).
- Supports insertion and lookup operations:
  - `insert(identName, attributes)`
  - `lookup(identName)`
- Stores identifier details such as:
  - Type (class, method, variable, parameter, etc.)
  - Scope and access modifier
  - Data type, initial value, and parent class/interface

---

## 📂 Project Structure
