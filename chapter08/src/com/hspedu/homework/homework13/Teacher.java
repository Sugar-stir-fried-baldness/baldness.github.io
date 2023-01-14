package com.hspedu.homework.homework13;

public class Teacher extends Person{
    private int Seniority;//工龄

    public Teacher(String name, int age, String gender, int seniority) {
        super(name, age, gender);
        Seniority = seniority;
    }

    public int getSeniority() {
        return Seniority;
    }

    public void setSeniority(int seniority) {
        Seniority = seniority;
    }
    public void study(){
        System.out.println("我承诺，我会认真教课");
    }

    @Override
    public String play() {
        return super.play()+"象棋";
    }
    public void printInfo(){
        System.out.println("老师的信息：");
        System.out.println( super.basicInfo() );
        System.out.println("工龄："+Seniority );
        study();
        System.out.println(play());
    }

    @Override
    public String toString() {
        return super.toString() +
                "Seniority=" + Seniority +
                '}';
    }
}
