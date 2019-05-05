package me.btcjp.java;

import java.util.ArrayList;
import java.util.List;

public class GeneriCat {
    public static void main(String[] args) {
        List<Animal> animals = new ArrayList<Animal>();
        List<Cat> cats = new ArrayList<Cat>();
        List<Carfield> carfields = new ArrayList<Carfield>();

        animals.add(new Animal());
        cats.add(new Cat());
        carfields.add(new Carfield());

        // 编译出错，只能赋值 Cat 或 Cat子类的集合
        // List<? extends Cat> extendsCatFromAnimal = animals;
        List<? super Cat> superCatFromAnimal = animals;

        List<? extends Cat> extendsCatFromCat = cats;
        List<? super Cat> superCatFromCat = cats;

        List<? extends Cat> extendsCatFromCarfield = carfields;
        // 编译出错，只能赋值 Cat 或 Cat父类的集合
        // List<? super Cat> superCatFromCarfield = carfields;

        // 下面三条语句均编译出错, <? extends T> 均无法进行add操作
//        extendsCatFromCat.add(new Animal());
//        extendsCatFromCat.add(new Cat());
//        extendsCatFromCarfield.add(new Carfield());

        // 编译出错，只能添加Cat的子类的集合
//        superCatFromCat.add(new Animal());
        superCatFromCat.add(new Cat());
        superCatFromCat.add(new Carfield());

        Object catExtends2 = extendsCatFromCat.get(0);
        Cat catExtends1 = extendsCatFromCat.get(0);
        // 编译出错, Cat集合从Carfield赋值而来，但类型擦除后，不知道哦类型的
//        Carfield carfield1 = extendsCatFromCarfield.get(0);

        Object catSuper1 = superCatFromCat.get(0);
        // 编译出错 <? super T> 操作能返回元素，但只能返回Object对象
//        Cat catSuper2 = superCatFromCat.get(0);
    }
}

class Animal {
    private String name = "animal";
}

class Cat extends Animal {
    private String name = "cat";
}

class Carfield extends Cat {
    private String name = "carfield";
}
