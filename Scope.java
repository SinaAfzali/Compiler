import java.util.*;

class Scope {
    private List<Map<String, Symbol>> scopes = new ArrayList<>();
    private Stack<String> scopeNames = new Stack<>();
    private int currentIndex = -1;
    private Map<String, Symbol> currentScope;

    public Scope() {
        // Global scope
        Map<String, Symbol> globalMap = new HashMap<>();
        scopes.add(globalMap);
        currentScope = globalMap;
        scopeNames.push("global");
        currentIndex = 0;
    }

    public void pushScope(String scopeName) {
        currentIndex++;
        Map<String, Symbol> newScope = new HashMap<>();
        scopes.add(newScope);
        currentScope = newScope;
        scopeNames.push(scopeName);
    }

    public void popScope() {
        if (currentIndex > 0) {
            scopeNames.pop();
            currentIndex--;
            currentScope = scopes.get(currentIndex);
        }
    }

    public void addSymbol(Symbol sym) {
        if (currentScope != null) {
            currentScope.put(sym.getName(), sym);
        }
    }

    public Symbol getSymbol(String name) {
        for (int i = currentIndex; i >= 0; i--) {
            if (scopes.get(i).containsKey(name)) {
                return scopes.get(i).get(name);
            }
        }
        return null;
    }

    public List<Symbol> getAllSymbols() {
        List<Symbol> all = new ArrayList<>();
        for (Map<String, Symbol> scope : scopes) {  // All scopes
            all.addAll(scope.values());
        }
        return all;
    }

    public String currentScopeName() {
        if (!scopeNames.isEmpty()) {
            return scopeNames.peek();
        }
        return "global";
    }
}