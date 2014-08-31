package com.tw.hello;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");
//        float f = 1.234f;
//        int i = (int) f;
//        System.out.println(f);
//        System.out.println(i);
//        System.out.println(Integer.MAX_VALUE + 1);
          System.out.println("return"+ myFun());

    }//main

    public static int myFun() {
        int i = 0;
        String s = null;
        try {
            s.toString();
            System.out.println("-try-");
            return 0;
        }catch (Exception ex){
            System.out.println("-catch-");
            ex.printStackTrace();
        }finally {
            System.out.println("-finally-");
            i =1;
        }
        i = 2;
        return i;

    }
}

