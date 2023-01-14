package com.hspedu.object_;

public class HashCode_ {
    public static void main(String[] args) {
        A a1 = new A();
        A a2 = new A();
        A a3 = a1;
        //指向的是不同的对象，hashCode值不一样
        System.out.println(a1.hashCode());
        System.out.println(a2.hashCode() );
        System.out.println(a3.hashCode() );
    }
}
class AA{}