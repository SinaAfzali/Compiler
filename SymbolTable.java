import java.io.*;
import java.util.*;

public class SymbolTable {
    public String scopeName;
    public SymbolTable parent;
    public Map<String, SymbolInfo> symbols = new LinkedHashMap<>();
    public List<SymbolTable> children = new ArrayList<>();

    public SymbolTable(String scopeName, SymbolTable parent) {
        this.scopeName = scopeName;
        this.parent = parent;
        if (parent != null) parent.children.add(this);
    }

    public void insert(SymbolInfo sym) {
        symbols.put(sym.name, sym);
    }

    public SymbolInfo lookup(String name) {
        SymbolTable curr = this;
        while (curr != null) {
            if (curr.symbols.containsKey(name))
                return curr.symbols.get(name);
            curr = curr.parent;
        }
        return null;
    }

    public void printToFile(BufferedWriter writer, int depth) throws IOException {
        String indent = "  ".repeat(depth);
        writer.write(indent + "Scope: " + scopeName);
        writer.newLine();
        for (SymbolInfo sym : symbols.values()) {
            writer.write(indent + "  " + sym);
            writer.newLine();
        }
        for (SymbolTable child : children) {
            if (!child.symbols.isEmpty()) {
                child.printToFile(writer, depth + 1);
            }
        }
    }
}