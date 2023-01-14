package com.hspedu.poly_.polyparameter_;

public class Worker extends Employee{
    public Worker(String name, int salary) {
        super(name, salary);
    }

    public String work(){
        return "员工 "+getName() +"正在工作...";
    }
    public int getAnnal(){
        return super.getAnnal();
    }
}
