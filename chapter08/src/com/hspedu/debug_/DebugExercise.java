package com.hspedu.debug_;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DebugExercise {
    public static void main(String[] args) {
        Person jack = new Person(18,"jack");
        System.out.println(jack);
        Date date = null;

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        System.out.println("=========");
        date = new Date();
        System.out.println(sdf.format(date));
    }
}
class Person{
    private int age;
    private String name;

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
