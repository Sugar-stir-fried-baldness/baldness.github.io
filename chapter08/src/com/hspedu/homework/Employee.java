package com.hspedu.homework;

public class Employee {
    private String name;
    private double salary;
    private int day;
    private double grade;
    public Employee(String name, double salary, int day,double grade) {
        this.name = name;
        this.salary = salary;
        this.day = day;
        this.grade = grade;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }
    public void print(){
        System.out.println( name+" 工资是 "+salary*day*grade );
    }
}
