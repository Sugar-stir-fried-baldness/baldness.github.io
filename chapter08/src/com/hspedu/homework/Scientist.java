package com.hspedu.homework;

public class Scientist extends Employee02{
        private double bonus;

    public Scientist(double salary, double bonus) {
        super(salary);
        this.bonus = bonus;
    }
    public void print(){
        System.out.print("科学家 ");
        System.out.println(" 薪资 = "+(getSalary()*getMonth() +bonus));
    }
}
