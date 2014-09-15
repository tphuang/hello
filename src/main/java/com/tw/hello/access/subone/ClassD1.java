package com.tw.hello.access.subone;

public class ClassD1 {
    protected void testProtected(){
        System.out.printf("The protected method is in ClassD1");
    }

    void testDefault(){
        System.out.printf("The default method is in ClassD1");
    }

    public static void main(String[] args) {
        ClassD1 d1 = new ClassD1();
        ClassA a = new ClassA();

        a.testProtected();
        a.testDefault();
    }
}
