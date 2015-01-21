package com.tw.hello.exceptions;

class Exp1 {
    public int div(int a, int b) {
        return a / b;
    }
}

public class ArithmeticException {

    public static void main(String[] args) {
        Exp1 e = new Exp1();
        int i = e.div(8, 0);
        System.out.printf("i is %d\n", i);
    }
}
