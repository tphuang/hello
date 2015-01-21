package com.tw.hello.spring;

public class HelloAction {

    private String visitorName;
    private Hello hello;

    public String getVisitorName() {
        return visitorName;
    }

    public void setVisitorName(String visitorName) {
        this.visitorName = visitorName;
    }

    public Hello getHello() {
        return hello;
    }

    public void setHello(Hello hello) {
        this.hello = hello;
    }


    public void greeting() {
        System.out.println("Greeting to\t" + visitorName);
        hello.sayHello();
        hello.talkMore();
    }
}
