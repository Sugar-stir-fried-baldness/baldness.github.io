package com.hspedu.poly_;

public class Master {
    private String name;

    public Master(String name) {
        this.name = name;
    }
    public void feed(Animal animal ,Food food){
        System.out.println("主人 "+ name + "给" + animal.getName()+" 喂 " + food.getFood());
    }
//     public void feed(Cat cat,Fish fish){
//         System.out.println("主人 "+ name + "给" + cat.getName()+" 喂 " + fish.getFood());
//
//     }
//    public void feed(Dog dog,Bone bone){
//        System.out.println("主人 "+ name + "给" + dog.getName()+" 喂 " + bone.getFood());
//
//    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
