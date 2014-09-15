package com.tw.hello.access.subone;

public class ClassA {
    protected void testProtected(){
        System.out.println("The protected method is in ClassA");
    }
    void  testDefault(){
        System.out.println("The default method is in ClassA");
    }

    public static void main(String[] args) {
        ClassA a = new ClassA();
        a.testDefault();
    }
}
