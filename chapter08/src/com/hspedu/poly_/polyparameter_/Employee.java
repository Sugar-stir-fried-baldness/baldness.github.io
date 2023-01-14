package com.hspedu.poly_.polyparameter_;

public class Employee {
    private String name;
    private int salary;
    public int getAnnal(){
        //"annal salary = " +
        return getSalary() *12;
    }
    public Employee(String name,int salary){
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
