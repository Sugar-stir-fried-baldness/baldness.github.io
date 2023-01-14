package com.hspedu.extend_;

public class Graduate {
    public String name;
    public int age;
    private int score;

    public void setScore(int score) {
        this.score = score;
    }

    public void testing(){
        System.out.println("大学生 "+name+"正在考数学...");
    }

    public void showInfo(){
        System.out.println("学生名 "+name+"年龄 "+ age +"成绩为 "+score);
    }
}
