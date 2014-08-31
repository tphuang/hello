package com.tw.hello;

import java.text.NumberFormat;
import java.util.regex.Pattern;

public class Calculator {

    private final static Pattern operatorPattern = Pattern.compile("(\\+|-|/|\\*)");
    private final static Pattern numbersPattern = Pattern.compile("\\d+(\\.\\d+)?");
    private NumberFormat numberFormat;

    public Calculator() {
        numberFormat = NumberFormat.getNumberInstance();
        numberFormat.setMaximumFractionDigits(4);
    }

    public String calculate(String expr) {
        String[] numbers = operatorPattern.split(expr);
        String[] operators = numbersPattern.split(expr);

        Float result = Float.valueOf(numbers[0]);

        for (int i = 1; i < numbers.length; i++) {
            String operator = operators[i];
            Float number = Float.valueOf(numbers[i]);
            if (operator.equals("+")) {
                result += number;

            } else if (operator.equals("-")) {
                result -= number;

            } else if (operator.equals("*")) {
                result *= number;

            } else if (operator.equals("/")) {
                result /= number;

            }
        }

        return numberFormat.format(result);
    }
}
