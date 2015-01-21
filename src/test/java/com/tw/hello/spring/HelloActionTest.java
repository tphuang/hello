package com.tw.hello.spring;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloActionTest {
    HelloAction helloAction;

    @Before
    public void setUp() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-beans.xml");
        helloAction = (HelloAction) context.getBean("helloAction");
    }

    @Test
    public void testGreeting() throws Exception {
        helloAction.greeting();
    }
}
