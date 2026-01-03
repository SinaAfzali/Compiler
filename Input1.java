class MainClass {
    public static void main(String[] args) {
        int x = 5;
        print("Hello");
    }
}

// خطا: تعریف تکراری کلاس
class MyClass {
    int field1;
    String field2;
    
    // خطا: تعریف تکراری فیلد
    int field1;
    
    MyClass(int param1) {
        field1 = param1;
    }
    
    void myMethod(int a) {
        int localVar = a * 2;
        // خطا: تعریف تکراری متغیر
        int localVar = 10;
        print(localVar);
    }
    
    // خطا: تعریف تکراری متد با همان signature
    void myMethod(int a) {
        print(a);
    }
}

// خطا: تعریف تکراری کلاس
class MyClass {
    int anotherField;
}

interface MyInterface {
    int INTERFACE_FIELD = 42;
    
    // خطا: تعریف تکراری فیلد اینترفیس
    int INTERFACE_FIELD = 100;
    
    void interfaceMethod(String list);
    
    // خطا: تعریف تکراری متد اینترفیس
    void interfaceMethod(String list);
}

// خطا: تعریف تکراری اینترفیس
interface MyInterface {
    void anotherMethod();
}
