package com.hspedu.poly_.polyarr_;

public class Student extends Person{
    private double score;

    public String say(){
        return super.say() + "  score = " + score;
    }
    public void student(){
        System.out.println("学生 "+getName()+"正在学java...");
    }
    public Student(String name,int age, double score) {
        super(name, age);
        this.score = score;
    }

    public double getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
