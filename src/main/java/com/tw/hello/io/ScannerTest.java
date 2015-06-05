package com.tw.hello.io;

import java.util.Scanner;

/**
 * Created by tphuang on 6/2/15.
 */
public class ScannerTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            int input = scanner.nextInt();
            if (input == 1) {
                System.out.println("星期一");
            } else if (input == 2) {
                System.out.println("星期二");
            } else {
                System.out.println("其他星期");
            }
        }



    }
}
