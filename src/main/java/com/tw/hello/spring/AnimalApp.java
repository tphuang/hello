package com.tw.hello.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnimalApp {
    public static void main(String args[]){
        ApplicationContext context =
                new ClassPathXmlApplicationContext("spring-factory.xml");
        Animal cat = context.getBean("cat", Animal.class);
        cat.sayHello();
        Animal dog = context.getBean("dog", Animal.class);
        dog.sayHello();
    }
}
