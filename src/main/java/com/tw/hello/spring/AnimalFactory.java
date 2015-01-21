package com.tw.hello.spring;

public class AnimalFactory {
//    静态工厂设计模式
    public static Animal getAnimal(String type) {
        if ("cat".equalsIgnoreCase(type)) {
            return new Cat();
        } else {
            return new Dog();
        }
    }
}
