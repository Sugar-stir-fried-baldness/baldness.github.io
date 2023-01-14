package com.hspedu.homework;

public class Homework05 {
    public static void main(String[] args) {
        Worker05 worker05 = new Worker05(2000);
        worker05.setMonth(12);
        worker05.print();
        Scientist scientist = new Scientist(6000,  20000);
        scientist.setMonth(15);
        scientist.print();
        Teacher05 teacher05 = new Teacher05(4000,  20,50);
        teacher05.setMonth(15);
        teacher05.print();
    }
}
