package com.tw.hello.spring;

public class Hello {
    private String name;

    private String age;

    public Hello(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void sayHello() {
        System.out.println("Hello ! " + name);
    }

    public void talkMore(){
        System.out.println("Name: " + name + "\t Age:" + age);
    }
}
