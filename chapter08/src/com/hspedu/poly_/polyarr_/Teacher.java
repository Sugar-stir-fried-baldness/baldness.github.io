package com.hspedu.poly_.polyarr_;

public class Teacher extends Person{
    private int salary;

    public String say(){
        return super.say() + "  salary = " + salary;
    }
    public void teach(){
        System.out.println("老师"+getName() +"正在教java...");
    }

    public Teacher(String name, int age, int salary) {
        super(name, age);
        this.salary = salary;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
