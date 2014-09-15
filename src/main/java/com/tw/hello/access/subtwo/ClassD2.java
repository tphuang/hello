package com.tw.hello.access.subtwo;

import com.tw.hello.access.subone.ClassA;

public class ClassD2 {
    protected void testProtected(){
        System.out.printf("The protected method is in ClassD2");
    }

    void testDefault(){
        System.out.printf("The default method is in ClassD2");
    }

    public static void main(String[] args) {
        ClassD2 d2 = new ClassD2();
        ClassA a = new ClassA();

//        a.testProtected();
//        a.testDefault();
    }
}
