// خطا: ایمپورت کلاس تعریف نشده
import UndefinedClass;
import AnotherUndefinedClass.*;

class MainClass {
    public static void main(String[] args) {
        int[] arr = new int[5];
        
        // خطا: اندیس منفی
        int val1 = arr[-1];
        
        // خطا: اندیس بزرگتر از سایز آرایه (برای اندیس ثابت)
        int val2 = arr[10];
        
        // خطا: نوع اندیس غیرصحیح (String به جای int)
        int val3 = arr["index"];
        
        // خطا: نوع اندیس غیرصحیح (char به جای int)
        int val4 = arr['a'];
        
        // خطا: نوع اندیس غیرصحیح (boolean به جای int)
        int val5 = arr[true];
        
        // خطا: استفاده از متغیر آرایه که آرایه نیست
        int notArray = 5;
        int val6 = notArray[0];
    }
}

// خطا: دور در ارث‌بری (ClassA -> ClassB -> ClassA)
class ClassA extends ClassB {
    int fieldA;
}

class ClassB extends ClassC {
    int fieldB;
}

class ClassC extends ClassA {
    int fieldC;
}

// خطا: دور در ارث‌بری (ClassD -> ClassE -> ClassD)
class ClassD extends ClassE {
    int fieldD;
}

class ClassE extends ClassD {
    int fieldE;
}

class ArrayTest {
    int[] arr = new int[3];
    
    public void testArray() {
        // خطا: اندیس منفی
        arr[-2] = 10;
        
        // خطا: اندیس بزرگتر از سایز (اندیس ثابت 5 برای آرایه سایز 3)
        arr[5] = 20;
        
        // خطا: نوع اندیس غیرصحیح
        arr[3.5] = 30;
    }
}
