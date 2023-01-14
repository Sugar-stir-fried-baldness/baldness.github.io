package com.hspedu.poly_;

public class PolyMethod {
    public static void main(String[] args) {
        A a = new A();

    }
}
class A{
    public void say(){
        System.out.println("A方法被调用...");
    }
}
class B extends A{
    public int sum(int n1, int n2){
        return n1+n2;
    }
    public int sum(int n1, int n2, int n3){
        return n1 + n2 +n3;
    }
    public void say(){
        System.out.println("B方法被调用...");
    }
}
