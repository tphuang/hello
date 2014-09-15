package com.tw.hello.generics;

import java.util.*;

public class WildcardGenericDemo {
    public static void main(String args[]) {
        CollectionGeneric<ArrayList> listFoo = null;
        listFoo = new CollectionGeneric<ArrayList>(new ArrayList());

        CollectionGeneric<? extends Collection> listFoo1 = null;
        listFoo1 = new CollectionGeneric<ArrayList>(new ArrayList());
        System.out.println(listFoo1.getClass().getName() + "实例化成功!");

        Gen1<? super Double> doubleGen1 = null;
        doubleGen1 = new Gen1<Object>(new Object());
        Gen1<? super Double> doubleGen2 = new Gen1<Object>("Hello,Fanpeng");
        doubleGen1.showType();

        List<? super Number> num1 = new ArrayList<Object>();
        num1.add(9);

        List<? extends Number> num2 = new ArrayList<Float>();
//        num2.add();
//        num2.add(2.6);

        System.out.println(
                testGeneric(new ArrayList<Integer>() {{
                    add(new Integer(3));
                }}).getClass());

        System.out.println(
                testGeneric(new ArrayList<Float>() {{
                    add(new Float(3f));
                }}).getClass());

//        testSuper(new ArrayList<Serializable>());
//
//        testSuper(new ArrayList<Number>());


    }

    public static <T extends Number> T testGeneric(List<T> list) {
        return list.get(0);
    }

    public static <T> void sort(List<T> list, Comparator<? super T> c) {
    }
//    public static <T super Number> T testSuper(List<T> list) {
//        return null
//
//    }

    List<? super Integer> integers = new ArrayList<Number>();
}


class A<T extends Number> {

}

//class B<T super Integer> {
//
//}


