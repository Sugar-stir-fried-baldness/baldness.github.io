package com.hspedu.extend_.exercise;

public class NotePad extends Computer{
    private String color;

    public NotePad(String cpu, int memory, int disk, String color) {
        super(cpu, memory ,disk);
        this.color = color;
    }
    public void printInfo(){
        System.out.println(getDetail() +"color = "+color);
        //假如这里需要用getDetail()函数，则函数需要有返回值
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }
}
