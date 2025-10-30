import java.util.*;

public class SymbolInfo {
    public String name;
    public String kind;
    public String dataType;
    public String access;
    public String parent;
    public boolean isAbstract;
    public String value;
    public List<SymbolInfo> parameters = new ArrayList<>();
    public List<String> interfaces = new ArrayList<>();

    public SymbolInfo(String name, String kind) {
        this.name = name;
        this.kind = kind;
        this.access = "default";
        this.isAbstract = false;
        this.value = "null";
    }

    public boolean isStatic() {
        return value != null && value.contains("static=true");
    }

    @Override
    public String toString() {
        String staticStr = isStatic() ? " | static=true" : "";
        String cleanValue = isStatic() ? "null" : value;
        if (cleanValue == null) cleanValue = "null";

        return String.format(
            "%-12s | kind=%-10s | type=%-10s | access=%-10s | parent=%-10s | abstract=%-5s%s | value=%-15s | params=%s | interfaces=%s",
            name, kind, dataType != null ? dataType : "null", access, parent != null ? parent : "null",
            isAbstract, staticStr, cleanValue, parameters, interfaces
        );
    }
}