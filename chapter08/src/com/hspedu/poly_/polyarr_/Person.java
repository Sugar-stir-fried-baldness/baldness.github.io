package com.hspedu.poly_.polyarr_;

public class Person {
    private String name;
    private int age;
    public String say(){
        return "name = " +name+" age = "+age;
    }
    public Person(String name,int age){
        this.name = name;
        this.age = age;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
}
