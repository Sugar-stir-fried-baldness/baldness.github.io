package com.hspedu.homework;

public class Homework04 {
    public static void main(String[] args) {
        Manager jack = new Manager("jack", 100, 10,1.2);
        jack.setBonus(2000);
        jack.print() ;
        Worker lisa = new Worker("lisa", 100, 10, 1.0);
        lisa.print();
    }
}
