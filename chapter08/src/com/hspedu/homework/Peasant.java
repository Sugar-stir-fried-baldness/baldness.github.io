package com.hspedu.homework;

public class Peasant extends Employee02{
    public Peasant(double salary) {
        super(salary);
    }
    public void print(){
        System.out.print("农民 ");
        super.print();
    }
}
