package com.hspedu.homework;

public class Manager extends Employee{
    private double bonus;
    public Manager(String name, double salary, int day,double grade) {
        super(name, salary, day,grade);

    }
    public void print(){
        System.out.print("经理 ");
        System.out.println( getName() +" 工资是 "+(bonus+getSalary() * getDay() * getGrade() ) );
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }
}
