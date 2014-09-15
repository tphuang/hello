package com.tw.hello.exceptions;

public class TestException {
    public static boolean test() {
        try {
            System.out.println("This is in try block!");
            return true;
        } catch (Exception e){
            System.out.println("This is in catch block!");
            return false;
        }finally {
            System.out.println("This is in finally block!");
            return false;
        }
    }

    public static void main(String[] args) {
        boolean a = test();
        System.out.println(a);
    }
}
