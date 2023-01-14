package com.hspedu.homework;

public class Homework10 {
    public static void main(String[] args) {
        Doctor doctor1 = new Doctor("jack", 18, "教编程", "A", 60000);
        Doctor doctor2 = new Doctor("jack", 1, "教编程", "A", 60000);
        System.out.println( doctor1 .equals(doctor2) );
    }
}
