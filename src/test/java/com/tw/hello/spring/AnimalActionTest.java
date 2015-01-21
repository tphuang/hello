package com.tw.hello.spring;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnimalActionTest {
    private AnimalAction animalAction;

    @Before
    public void setUp() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-beans.xml");
        animalAction = (AnimalAction) context.getBean("animalAction");

    }

    @Test
    public void testAnimalSayHello() throws Exception {
        animalAction.animalSayHello();
    }
}
