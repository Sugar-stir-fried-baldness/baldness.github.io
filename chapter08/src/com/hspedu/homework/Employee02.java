package com.hspedu.homework;

public class Employee02 {
    private double salary;
    private int month;

    public Employee02(double salary) {
        this.salary = salary;

    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void print(){
        System.out.println("薪资 = "+salary +" 年薪 = "+salary*month);
    }
}
