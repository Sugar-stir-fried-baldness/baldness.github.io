package com.hspedu.extend_.exercise;

public class Computer {
    private String cpu;
    private int memory;
    private int disk;
    //由于是私人的，因此需要一个构造器将他
    public Computer(String cpu, int memory,int disk){
        this.cpu = cpu;
        this.memory = memory;
        this.disk = disk;
    }
    public String getDetail(){
       // System.out.println("cpu = "+cpu +" memory = "+ memory +" disk = "+disk);
        return "cpu = "+cpu +" memory = "+ memory +" disk = "+disk ;
    }
    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public int getMemory() {
        return memory;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }

    public int getDisk() {
        return disk;
    }

    public void setDisk(int disk) {
        this.disk = disk;
    }
}
