package com.hspedu.modifier;

public class B {//类
    //需要先建一个方法
    public void say(){
        A a = new A();
        //同一个包
        System.out.println("n1 = "+ a.n1 +"n2 = "+a.n2 +"n3 = "+a.n3);
    }

}
