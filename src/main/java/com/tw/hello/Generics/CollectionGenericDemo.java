package com.tw.hello.generics;


import java.util.ArrayList;
import java.util.Collection;

class CollectionGeneric<T extends Collection> {
    private T x;

    public CollectionGeneric(T x) {
        this.x = x;
    }

    public T getX() {
        return x;
    }

    public void setX(T x) {
        this.x = x;
    }
}

public class CollectionGenericDemo {
    public static void main(String args[]) {
        CollectionGeneric<ArrayList> genericList = null;
        genericList = new CollectionGeneric<ArrayList>(new ArrayList());
        System.out.println("实例化成功!");
    }
}
