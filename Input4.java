class MainClass {
    public static void main(String[] args) {
        int[] arr = new int[5];
        int[] intArr = {1, 2, 3};
        print("Array Test: " + arr.length);
        int powVal = 2 ** 3;
        int minusVal = -powVal;
        print((minusVal + 10));
        print('A');
        print(null);
        print(this);
    }
}

class ArrayClass {
    private int[] fieldArr;

    public ArrayClass(int size) {
        fieldArr = new int[size];
    }

    public void arrayMethod(int[] paramArr) {
        int[] localArr = new int[3];
        localArr[0] = paramArr[0] * 2;
        print(localArr.length);
    }
}

interface ArrayInterface {
    char[] IF_FIELD = new char[2];

    void ifMethod(String[] sArr);
}