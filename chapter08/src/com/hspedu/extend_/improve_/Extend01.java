package com.hspedu.extend_.improve_;

import com.sun.xml.internal.fastinfoset.util.ValueArrayResourceException;

public class Extend01 {
    public static void main(String[] args) {
        Pupil pupil = new Pupil();
         pupil.name = "小明";
         pupil.age = 12;
        pupil.testing() ;
        pupil.setScore(60) ;
        pupil.showInfo();

        Graduate graduate = new Graduate();
        graduate.name = "小红";
        graduate.age = 18;
        graduate.testing();
        graduate.setScore(99);
        graduate.showInfo();
    }
}
