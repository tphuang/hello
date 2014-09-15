package com.tw.hello.generics;

import java.util.Date;

//Gen1<A>声明了一个泛型类，这个T没有任何数据类型限制,同时T也可以为A等抽象表示的字符；
//实际上其相当于Object类型, 即class GenericsFoo<A extends Object>
class Gen1<A> {
    private A ob; //定义泛型成员变量

    Gen1() {
    }

    public Gen1(A ob) {
        this.ob = ob;
    }

    public A getOb() {
        return ob;
    }

    public void setOb(A ob) {
        this.ob = ob;
    }

    public void showType() {
        System.out.println("T的实际类型是: " + ob.getClass().getName());
    }
}

public class GenericDemo1 {
    public static void main(String[] args) {
    //定义泛型类Gen的一个Integer版本
        Gen1 intOb = new Gen1<Integer>();
//        intOb.setOb(10);
        intOb.setOb(new Date());

//        List<Integer> intList = new ArrayList<>();
        intOb.showType();
//        int i = intOb.getOb();
        System.out.println("value= " + intOb.getOb());
        System.out.println("----------------------------------");
    //定义泛型类Gen的一个String版本
//        Gen1<String> strOb = new Gen1<String>("Hello Gen1!");
//        strOb.showType();
//        String s = strOb.getOb();
//        System.out.println("value= " + s);

//        List myList = new ArrayList<String>();
//        Object o = myList.get(0);
    }


}