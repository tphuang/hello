package com.tw.hello.JavaBasic;

class IfElseDemo {
    public static void main(String[] args) {
        int testscore1 = 78;
        char grade1 = rate(testscore1);
        System.out.println("Grade = " + grade1);

        int testscore2 = 96;
        char grade2 = rate(testscore2);
        System.out.println("Grade = " + grade2);

        int testscore3 = 86;
        char grade3 = rate(testscore3);
        System.out.println("Grade = " + grade3);

        int testscore4 = 78;
        char grade4 = rate2(testscore4);
        System.out.println("Grade = " + grade4);
    }

    private static char rate(int testscore) {
        char grade;

        if (testscore >= 90) {
            grade = 'A';
        } else if (testscore >= 80) {
            grade = 'B';
        } else if (testscore >= 70) {
            grade = 'C';
        } else if (testscore >= 60) {
            grade = 'D';
        } else {
            grade = 'F';
        }
        return grade;
    }

    private static char rate2(int testscore) {
        char grade;

        if (testscore >= 90) {
            grade = 'A';
        }
        if (testscore >= 80) {
            grade = 'B';
        }
        if (testscore >= 70) {
            grade = 'C';
        }
        if (testscore >= 60) {
            grade = 'D';
        } else {
            grade = 'F';
        }
        return grade;
    }
}
