package com.hspedu.extend_.exercise;

public class ExtendsExercise01 {
    public static void main(String[] args) {
        B b = new B();  //调用的是B类的无参构造器
        //输出一个a abc 和b
    }
}
class A{
   public A(){
       System.out.println("a");
   }
   public A(String name){
       System.out.println("a name");
   }
}
class B extends A{
    public B(){
        this("abc");
        System.out.println("b");
    }
    public B(String name){
        System.out.println("b name");
    }
}