package com.tw.hello.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "spring-beans.xml");

        Hello hello = (Hello) context.getBean("hello");
        hello.sayHello();

        hello.talkMore();

    }
}
