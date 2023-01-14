package com.hspedu.homework.homework13;

public class Student extends Person{
    private String id;

    public Student(String name, int age, String gender, String id) {
        super(name, age, gender);
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public void study(){
        System.out.println("我承诺，我会好好学习");
    }
    public String play(){
        return super.play()+"足球";
    }
    public void printInfo(){
        System.out.println("学生的信息：");
        System.out.println( super.basicInfo() );
        System.out.println("学号："+id);
        study();
        System.out.println(play());
    }

    @Override
    public String toString() {
        return super.toString()+
                "Student{" +
                "id='" + id + '\'' +
                '}';
    }
}
