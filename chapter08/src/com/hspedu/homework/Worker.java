package com.hspedu.homework;

public class Worker extends Employee{



    public Worker(String name, double salary, int day, double grade) {
        super(name, salary, day,grade);

    }
    public void print(){
        System.out.print("普通员工 ");
        super.print();
    }

}
