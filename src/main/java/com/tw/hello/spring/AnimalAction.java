package com.tw.hello.spring;

public class AnimalAction {
    private Animal animal;

//    public void animalSayHello() {
//        animal.sayHello();
//    }
//
//    public Animal getAnimal() {
//        return animal;
//    }
//
//    public void setAnimal(Animal animal) {
//        this.animal = animal;
//    }
//
//
////    Constructor
//    public AnimalAction(Animal animal) {
//        this.animal = animal;
//    }

//    接口注入
    public void animalSayHello() {
        try {
            animal = (Animal) Class.forName("com.tw.hello.spring.Cat").newInstance();
//            animal = Cat.class.newInstance();
//            animal = new Cat();
            animal.sayHello();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
