package com.tw.hello.access.subone;

public class ClassC extends ClassA {
//    @Override
//    protected void testProtected() {
//        super.testProtected();
//        System.out.printf("The protected method is in ClassC");
//    }

    @Override
    void testDefault() {
        super.testDefault();
        System.out.println("The default method is in ClassC");
    }

    public static void main(String[] args) {
        ClassA a = new ClassC();
        a.testProtected();
        a.testDefault();
        System.out.println(a instanceof ClassA);

        ClassC c = new ClassC();
        c.testProtected();
        c.testDefault();
    }
}
