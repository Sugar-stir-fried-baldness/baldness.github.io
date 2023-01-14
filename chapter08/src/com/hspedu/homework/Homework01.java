package com.hspedu.homework;

import java.util.Arrays;

public class Homework01 {
    public static void main(String[] args) {
       Person[] persons = new Person[3];
         persons[0] = new Person("jack", 18, "打怪兽");
        persons[1] = new Person("smith", 17, "打怪兽");
         persons[2] = new Person("mack", 18, "打怪兽");
         //使用冒泡排序 ，根据年龄大小排序

        Person temp = null;

        for (int i = 0; i < persons.length-1 ; i++) {
            for (int j = 0; j < persons.length -1-i ; j++) {
                if(( persons[j].getAge() ) <  persons[j+1].getAge() ){
                    temp = persons[j];
                    persons[j] = persons[j+1];
                    persons[j+1] = temp;
                }
            }
        }
        //输出
        for (int i = 0; i < persons.length ; i++) {
            System.out.println(persons[i]);
        }
    }
}

 class Person {
    private String name = "";
    private int age ;
    private String job;
    //初始化Person对象数组
    public Person(String name, int age, String job) {
        this.name = name;
        this.age = age;
        this.job = job;
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

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", job='" + job + '\'' +
                '}';
    }
}
