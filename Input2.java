class MainClass {
    public static void main(String[] args) {
        int x = 5;
        print("Test Abstract Class");
    }
}

abstract class BaseClass {
    protected int baseField;
}

abstract class MyAbstractClass implements TestInterface {
    private String abstractField;

    public MyAbstractClass(String paramName, int paramInt) {
        abstractField = paramName;
        baseField = paramInt;
    }

    @Override
    public void testMethod(int p) {
        int local = p + 10;
        print(local);
    }
}

interface TestInterface {
    int TEST_CONST = 100;
    void testMethod(int p);
}

interface AnotherInterface {
    void anotherMethod();
}