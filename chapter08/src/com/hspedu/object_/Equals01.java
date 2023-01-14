package com.hspedu.object_;


public class Equals01 {
    public static void main(String[] args) {
        A a = new A();
        A b = a;
        A c = b;
        System.out.println(a == b);//true
        System.out.println(c == b);//true
        B d = a;
        System.out.println(d == a);//true
        //查看源码，把光标放在equals上，ctrl+B
        //或者 单击右键，转到，声明或用例。
        System.out.println("hello".equals("abc"));//equals 进行了方法的重写

        System.out.println("=====");
        Object obj1 = new Object();
        Object obj2 = obj1;
        System.out.println(obj1 ==obj2);
        System.out.println(obj1.equals(obj2 ) );
        System.out.println("=====");

        Integer integer1 = new Integer(1000);
        Integer integer2 = new Integer(1000);
        System.out.println( integer1 == integer2);//false
        System.out.println(integer1.equals(integer2 ));//true

        String s = new String("tzy");
        String tzy = new String("tzy");
        System.out.println( s == tzy);//false
        System.out.println(s.equals(tzy));//true
    }
}
/*
    //在 String 里面 equals 的源码
    public boolean equals(Object anObject) {
        if (this == anObject) {
            return true;
        }
        if (anObject instanceof String) {//判断是否是String类
            String anotherString = (String)anObject;//向下转型
            int n = value.length;
            if (n == anotherString.value.length) {//先判断字符串长度，再依次比较字符串是否相同
                char v1[] = value;
                char v2[] = anotherString.value;
                int i = 0;
                while (n-- != 0) {
                    if (v1[i] != v2[i])
                        return false;
                    i++;
                }
                return true;
            }
        }
        return false;
    }*/
/*
//在Integer里面equals的源码

public boolean equals(Object obj) {
    return (this == obj);
}*/
class B {
}

class A extends B {
}