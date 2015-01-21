package com.tw.hello.spring;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloTest {
    private Hello hello;

    @Before
    public void setUp() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-beans.xml");
        hello = (Hello) context.getBean("hello");

//        XmlBeanFactory factory = new XmlBeanFactory (new ClassPathResource("spring-beans.xml"));
//        hello = (Hello) factory.getBean("hello");

    }

    @Test
    public void testSayHello() throws Exception {
        hello.sayHello();
    }

    @Test
    public void testTalkMore() throws Exception {
        hello.talkMore();
    }
}
