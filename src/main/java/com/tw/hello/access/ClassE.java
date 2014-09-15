package com.tw.hello.access;

public class ClassE {
    protected void testProtected(){
        System.out.println("The protected method is in ClassA");
    }
    void  testDefault(){
        System.out.println("The default method is in ClassA");
    }

    public static void main(String[] args) {
        ClassE a = new ClassE();
        a.testDefault();
    }
}
