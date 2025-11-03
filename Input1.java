class MainClass {
    public static void main(String[] args) {
        int x = 5;
        print("Hello");
    }
}

class MyClass {
    int field1;
    String field2;

    MyClass(int param1) {
        field1 = param1;
    }

    void myMethod(int a) {
        int localVar = a * 2;
        print(localVar);
    }
}

interface MyInterface {
    int INTERFACE_FIELD = 42;

    void interfaceMethod(String list);
}