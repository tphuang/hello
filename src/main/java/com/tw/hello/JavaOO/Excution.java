package com.tw.hello.javaOO;

class Parent {
    public static String p_StaticField = "p_StaticField";
    public String p_Field = "p_Field";

    static {
        System.out.println(p_StaticField);
        System.out.println("Parent Static init");
    }

    {
        System.out.println(p_Field);
        System.out.println("Parent init");
    }

    public Parent() {
        System.out.println("Parent constructor");
    }
    public static void sayHello(){
        System.out.println("Parent sayHello");
    }
}

class SubClass extends Parent {
    public static String s_StaticField = "s_StaticField";
    public String s_Field = "s_Field";

    static {
        System.out.println(s_StaticField);
        System.out.println("SubClass Static init");
    }

    {
        System.out.println(s_Field);
        System.out.println("SubClass init");
    }

    public SubClass() {
        super();
        System.out.println("SubClass constructor");
    }

    public static void sayHello(){
        System.out.println("SubClass sayHello");
    }

}//SubClass


public class Excution {
    public static void main(String[] args) {
       Parent parent = new Parent();
       SubClass subClass = new SubClass();
       Parent.sayHello();
       SubClass.sayHello();
    }
}