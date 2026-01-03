class MainClass {
    public static void main(String[] args) {
        // خطا: عدم تطابق نوع در انتساب (int = String)
        int x = "hello";
        
        // خطا: عدم تطابق نوع در انتساب (boolean = int)
        boolean flag = 5;
        
        // خطا: عدم تطابق نوع در انتساب (String = int)
        String str = 42;
        
        // خطا: استفاده از متغیر اعلان نشده
        int y = undefinedVar + 10;
        
        // خطا: استفاده از متغیر در اسکوپ غیرمجاز
        if (true) {
            int localVar = 5;
        }
        // خطا: localVar در این اسکوپ قابل دسترسی نیست
        print(localVar);
        
        // خطا: استفاده از متغیر به عنوان آرگومان که اعلان نشده
        print(anotherUndefined);
    }
}

class ScopeTest {
    private int privateField;
    public int publicField;
    
    public void testMethod() {
        int localVar = 10;
        
        // خطا: عدم تطابق نوع در انتساب (int = boolean)
        localVar = true;
        
        // خطا: عدم تطابق نوع در انتساب (int = String)
        privateField = "wrong";
    }
}

class AnotherClass {
    public void accessTest() {
        ScopeTest obj = new ScopeTest();
        
        // خطا: دسترسی به فیلد private از خارج کلاس
        int val = obj.privateField;
        
        // این درست است
        int val2 = obj.publicField;
    }
}
