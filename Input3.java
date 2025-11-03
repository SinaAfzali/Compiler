class MainClass {
    public static void main(String[] args) {
        boolean flag = true;
        int i = 0;
        if (i < 5) {
            while (flag) {
                i = i + 1;
                if (i == 3) {
                    flag = false;
                } else {
                    print(i);
                }
                if (i > 2) break;
            }
        } else {
            for (int j = 0; j < 2; j = j + 1) {
                print(j);
                continue;
            }
        }
        read(i);
    }
}

class ImplClass implements MyInterface {
    public void interfaceMethod(boolean b, String s) {
        if (b && s.length > 0) {
            print(s);
        }
    }
}

interface MyInterface {
    int INTERFACE_FIELD = 42 + 10;

    void interfaceMethod(boolean b, String s);
}