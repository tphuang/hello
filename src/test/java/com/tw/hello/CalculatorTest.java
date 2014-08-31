package com.tw.hello;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CalculatorTest {

    private Calculator calculator;

    @Before
    public void before() throws Exception {
        calculator = new Calculator();
    }

    @Test
    public void should_get_0_when_0_add_0() throws Exception {
        assertExprResult("0+0", "0");
    }

    @Test
    public void should_get_2_when_1_add_1() throws Exception {
        assertExprResult("1+1", "2");
    }

    @Test
    public void should_get_1_when_2_minux_1() throws Exception {
        assertExprResult("2-1", "1");
    }

    @Test
    public void should_get_1_dot_44_when_1_dot_2_multiply_1_dot_2() throws Exception {
        assertExprResult("1.2*1.2", "1.44");
    }

    @Test
    public void should_get_1_dot_2_when_1_dot_2_div_1_dot_2() throws Exception {
        assertExprResult("1.44/1.2", "1.2");
    }

    @Test
    public void should_get_6_when_1_add_2_multiply_3_minux_3() throws Exception {
        assertExprResult("1+2*3-3", "6");
    }

    private void assertExprResult(String expr, String result) {
        String actualResult = calculator.calculate(expr);

        assertThat(actualResult, is(result));
    }

}