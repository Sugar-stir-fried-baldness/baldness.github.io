package com.hspedu.homework;

public class LabeledPoint extends Point{
    private String name;

    public LabeledPoint( String name,double x, double y) {
        super(x, y);
        this.name = name;
    }
}
