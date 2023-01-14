package com.hspedu.extend_.improve_;
//父类
public class Student {
    public String name;
    public int age;
    private int score;

    public void setScore(int score) {
        this.score = score;
    }
    public void showInfo(){
        System.out.println("学生名 "+name+" 年龄 "+ age +" 成绩为 "+score);
    }
}
