class MainClass {
    public static void main(String[] args) {
        TestClass obj = new TestClass();
        
        // خطا: دسترسی به متد private از خارج کلاس
        obj.privateMethod(5);
        
        // خطا: عدم تطابق تعداد پارامترها (انتظار 2، دریافت 1)
        obj.publicMethod(10);
        
        // خطا: عدم تطابق نوع پارامتر (انتظار int، دریافت String)
        obj.publicMethod("test", 20);
        
        // خطا: عدم تطابق ترتیب پارامترها
        obj.publicMethod("test", 20);
    }
}

class TestClass {
    private int field;
    
    // متد private
    private void privateMethod(int x) {
        field = x;
    }
    
    // متد public با 2 پارامتر
    public void publicMethod(int a, int b) {
        field = a + b;
    }
    
    // خطا: عدم تطابق نوع در بازگشت متد (انتظار int، برگرداندن String)
    public int returnIntMethod() {
        return "wrong type";
    }
    
    // خطا: عدم تطابق نوع در بازگشت متد (انتظار void، برگرداندن مقدار)
    public void voidMethod() {
        return 5;
    }
    
    // خطا: متد باید مقدار برگرداند اما return ندارد
    public int mustReturnInt() {
        print("no return");
    }
}
