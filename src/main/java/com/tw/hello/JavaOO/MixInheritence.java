package com.tw.hello.javaOO;

/**
 * Created by tphuang on 9/12/14.
 */
public class MixInheritence {

    public static A MixInheritence(Class<A>... a) {
        return new A() {
            @Override
            public String say() {
                return "I am A";
            }
        };
    }

    public static B MixInheritence(Class<B> b) {
        return new B() {
            @Override
            public double say() {
                return 0.2;
            }
        };
    }

    public static A MixInheritence(A[] a) {
        return new A() {
            @Override
            public String say() {
                return "I am A";
            }
        };
    }

    public static B MixInheritence(B[] b) {
        return new B() {
            @Override
            public double say() {
                return 0.2;
            }
        };
    }

//    public static <T> T MixInheritence(Class<T> type) {
//        if(type == A.class) {
//            return (T)(new A() {
//                @Override
//                public String say() {
//                    return "I am A";
//                }
//            });
//        } else if(type == B.class) {
//            return (T)(new B() {
//                @Override
//                public double say() {
//                    return 0.2;
//                }
//            });
//        }
//
//        throw new RuntimeException();
//    }

    public static void main(String[] args) {
//        A a = MixInheritence(A.class);
//        System.out.println(a.say());
//        B b = MixInheritence(B.class);
//        System.out.println(b.say());


        A a = MixInheritence(new A[0]);
        System.out.println(a.say());
        B b = MixInheritence(new B[0]);
        System.out.println(b.say());
    }
}


interface  A {
    String say();
}

interface B {
    double say();
}
