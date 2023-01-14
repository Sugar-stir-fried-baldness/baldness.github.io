package com.hspedu.extend_.improve_;

public class Sub extends Base{//子类
    public Sub(){
        System.out.println("sub()...");
    }
    public  void sayOk(String[] args) {
        System.out.println(n1+ " " + n2 +" "+ n3 +" "+ getN4());
        showTest400() ;
    }
}
