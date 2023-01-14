package com.hspedu.homework;

public class Worker05 extends Employee02 {
    public Worker05(double salary) {
        super(salary);
    }
    public void print(){
        System.out.print("工人 ");
        super.print();
    }
}
