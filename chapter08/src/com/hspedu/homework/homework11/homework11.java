package com.hspedu.homework.homework11;

public class homework11 {
    public static void main(String[] args) {
        Person person1 = new Student();
        person1.run() ;
        person1.study() ;
        //Person person2 = new Person();
        Student student1 = (Student) person1;
        student1.run() ;
        student1.study() ;

    }
}
