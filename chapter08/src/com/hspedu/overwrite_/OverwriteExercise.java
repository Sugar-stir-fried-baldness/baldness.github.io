package com.hspedu.overwrite_;

public class OverwriteExercise {
    public static void main(String[] args) {
        Person jack = new Person("jack", 12);
        Student lisa = new Student("jack", 12,"lisa", 66);
       // jack.say();
        System.out.println(lisa.say() );
    }
}
