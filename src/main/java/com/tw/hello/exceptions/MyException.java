package com.tw.hello.exceptions;

public class MyException extends Exception{
    public MyException(){
        super();
    }
    public MyException(String msg){
        super(msg);
    }
    public MyException(String msg, Throwable throwable){
        super(msg, throwable);
    }
    public MyException(Throwable throwable){
        super(throwable);
    }
}

class ExceptionTest {
    public static void execute(String a) throws MyException {
        System.out.println("execute...");
        if("true".equals(a)){
            throw new MyException("参数不能为 true");
        }
    }

    public static void main(String[] args) throws MyException {

        execute("true");
    }
}

