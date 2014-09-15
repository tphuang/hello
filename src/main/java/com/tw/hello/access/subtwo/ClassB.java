package com.tw.hello.access.subtwo;

import com.tw.hello.access.ClassE;
import com.tw.hello.access.subone.ClassA;

public class ClassB extends ClassA {
//    @Override
//    protected void testProtected() {
//        super.testProtected();
//        System.out.println("The protected method is in ClassB");
//    }


    public static void main(String[] args) {
        ClassB b = new ClassB();
        b.testProtected();
//        b.testDefault;
        //a.testProtected();编译不过原因是：proteced有 包权限和继承权限。
        //不同包情况下，只能通过子类访问；如果可以用static，protected访问权限失效。

        ClassA a = new ClassB();//compile vs runtime
        ClassA a1 = new ClassA();
//        a.testProtected();
//        a.testDefault();

        System.out.println(a instanceof ClassA);
        System.out.println(a instanceof ClassB);

        ClassE e = new ClassE();

    }
}


