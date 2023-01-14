package com.hspedu.poly_.polyparameter_;

public class Manger extends Employee{
    private int bonus;
    public Manger(String name, int salary, int bonus) {
        super(name, salary);
        this.bonus = bonus;
    }
    public int getAnnal(){
        //super.getAnnal()+"经理的年薪 = "+(getSalary()*12+bonus);
        return getSalary() *12 + getBonus() ;
    }
    public String manage(){
        return "经理 "+getName() +"正在工作...";
    }


    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }
}
