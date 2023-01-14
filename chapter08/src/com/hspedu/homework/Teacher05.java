package com.hspedu.homework;

public class Teacher05 extends Employee02{
    private int classDay;
    private double classSal;

    public Teacher05(double salary,int classDay, double classSal) {
        super(salary);
        this.classDay = classDay;
        this.classSal = classSal;
    }
    public void print(){
        System.out.print("老师 ");
        System.out.println( " 薪资 = "+( getSalary()*getMonth() +classDay*classSal) );
    }

}
