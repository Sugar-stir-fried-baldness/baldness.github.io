package com.hspedu.object_;

public class EqualsExercise01 {
    public static void main(String[] args) {

        Person p1 = new Person("jack", 18, 'l');
        Person p2 = new Person("smith", 18, 'l');
        System.out.println(p1.equals(p2));

    }
}
class Person{//Object类的子类
    private String name;
    private int age;
    private char gender;
    public Person(String name, int age, char gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }
    //判断两个Person对象的内容是否相等，如果两个Person对象的各个属性,
    //值都一样，则返回true，反之false
    public boolean equals(Object obj){
        if( this == obj){
            return true;
        }
        if(obj instanceof Person){//判断传入的obj是不是Person
            Person p = (Person) obj;//向下转型
            //依次判断属性是否相同
            return this.age == p.age && this.name ==p.name && this.gender ==p.gender;
        }
        return false;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }
}