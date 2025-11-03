// Symbol.java - Expanded with additional fields for project spec
class Symbol {
    private String name;
    private String type; // e.g., return type for methods, data type for variables
    private String kind; // "class", "interface", "method", "constructor", "field", "variable", "parameter"
    private String scope; // e.g., class_name, method_name
    private String visibility; // access level
    private String parent; // for classes: extends class
    private String implementedInterfaces; // comma-separated for classes
    private String parameterList; // comma-separated "type name" for methods/constructors
    private boolean isAbstract;
    private boolean isOverride;
    private String initialValue; // for variables/fields with initializer

    public Symbol(String name, String type, String kind, String scope, String visibility, String parent, String implementedInterfaces, boolean isAbstract, boolean isOverride, String parameterList, String initialValue) {
        this.name = name;
        this.type = type;
        this.kind = kind;
        this.scope = scope;
        this.visibility = visibility;
        this.parent = parent;
        this.implementedInterfaces = implementedInterfaces;
        this.isAbstract = isAbstract;
        this.isOverride = isOverride;
        this.parameterList = parameterList;
        this.initialValue = initialValue;
    }

    // Getters
    public String getName() { return name; }
    public String getType() { return type; }
    public String getKind() { return kind; }
    public String getScope() { return scope; }
    public String getVisibility() { return visibility; }
    public String getParent() { return parent != null ? parent : ""; }
    public String getImplementedInterfaces() { return implementedInterfaces != null ? implementedInterfaces : ""; }
    public boolean isAbstract() { return isAbstract; }
    public boolean isOverride() { return isOverride; }
    public String getParameterList() { return parameterList != null ? parameterList : ""; }
    public String getInitialValue() { return initialValue != null ? initialValue : ""; }

    @Override
    public String toString() {
        return String.format("%s | %s | %s | %s | %s | %s | %s | %s | %s | %s | %s",
                             name, type, kind, scope, visibility != null ? visibility : "",
                             getParent(), getImplementedInterfaces(), isAbstract, isOverride, getParameterList(), getInitialValue());
    }
}