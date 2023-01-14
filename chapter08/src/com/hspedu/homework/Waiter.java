package com.hspedu.homework;

public class Waiter extends Employee02{
    public Waiter(double salary) {
        super(salary);
    }
    public void print(){
        System.out.print("服务员 ");
        super.print();
    }
}
