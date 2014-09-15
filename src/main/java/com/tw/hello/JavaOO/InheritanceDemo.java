package com.tw.hello.javaOO;


interface FaceA {
    boolean isMan();
}

interface FaceB {
    String isMan();
}

class FaceC {
    String isMan(){
        return "";
    }
}

abstract class FaceD {
    abstract String isMan();
}

class MixedFace1 implements FaceA {

    @Override
    public boolean isMan() {
        return false;
    }
}

class MixedFace2 implements FaceB {

    @Override
    public String isMan() {
        return null;
    }
}

class MixedFace3 extends FaceC {
    @Override
    public String isMan() {
        return "";
    }
}

class FaceClassTest {
    public static boolean isMan() {
        return true;
    }

    public static void main(String[] args) {
//        FaceC faceC = new FaceC(); //包含的方法
//        faceC.isMan(); //String isMan();

        FaceA faceA1 = new MixedFace1();
        FaceB faceB1 = (FaceB) new MixedFace1();
        faceA1.isMan();
        faceB1.isMan();

        System.out.println(faceA1 instanceof FaceA);
        System.out.println(faceB1 instanceof FaceB);
        System.out.println(faceB1 instanceof MixedFace1);

        FaceB faceB2 = new MixedFace2();
        FaceA faceA2 = (FaceA) new MixedFace2();
        faceB2.isMan();
        faceA2.isMan();


        FaceC faceC3 = new MixedFace3();
        FaceA faceA3 = (FaceA) new MixedFace3();

        faceC3.isMan();
        faceA3.isMan();
    }

}