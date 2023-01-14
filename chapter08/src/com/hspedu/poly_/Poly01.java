package com.hspedu.poly_;

public class Poly01 {
    public static void main(String[] args) {
        Master jack = new Master("jack");
        Dog dog = new Dog("大黄");
        Bone bone = new Bone("大棒骨");
        jack.feed(dog ,bone);

        Master lisa = new Master("lisa");
        Cat cat = new Cat("小红");
        Fish fish = new Fish("小黄鱼");
        System.out.println("+++======++=");
        lisa.feed(cat,fish);


    }
}
