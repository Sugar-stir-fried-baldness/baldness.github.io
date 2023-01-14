package com.hspedu.poly_.detail_;

import com.hspedu.modifier.A;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

public class PolyDetail03 {
    public static void main(String[] args) {
        Object obj1 = "Hello";
        //aa编译类型 AA，运行类型是 BB
        AA aa = new AA();
        //instanceof 看的是运行内存
        System.out.println(aa instanceof AA);//true
        System.out.println(aa instanceof BB);//false
        AA bb = new BB();
        System.out.println(bb instanceof AA);//true
        System.out.println(bb instanceof BB);//true
        Object obj = new Object();
       System.out.println(obj instanceof AA);//false
        String str = "hello";
        System.out.println(str instanceof Object);//true
        Object obj01 = null;
        System.out.println(obj01 instanceof AA);//false
    }
}
class AA{ }
class BB extends AA{}
