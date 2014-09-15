package com.tw.hello.generics;

public class GenericMethod {
    public <T> void f(T x) {
        System.out.println(x.getClass().getName());
    }

    public static <E> void printArray(E[] inputArray) {
        // 输出数组元素
        for (E element : inputArray) {
            System.out.printf("%s  ", element);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        GenericMethod ea = new GenericMethod();
        ea.f(" ");
        ea.f(10);
        ea.f('a');
        ea.f(ea);

        // 创建不同类型数组： Integer, Double 和 Character
        System.out.println("testPrintArray");
        Integer[] intArray = {1, 2, 3, 4, 5};
        Double[] doubleArray = {1.1, 2.2, 3.3, 4.4};
        Character[] charArray = {'H', 'E', 'L', 'L', 'O'};

        System.out.println("Array integerArray contains:");
        printArray(intArray); // 传递一个整型数组

        System.out.println("\nArray doubleArray contains:");
        printArray(doubleArray); // 传递一个双精度型数组

        System.out.println("\nArray characterArray contains:");
        printArray(charArray); // 传递一个字符型型数组
    }

}