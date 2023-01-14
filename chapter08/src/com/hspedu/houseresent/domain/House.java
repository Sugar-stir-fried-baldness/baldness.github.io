package com.hspedu.houseresent.domain;

public class House {
//    编号 房主 电话 地址 月租 状态(未出租
    private int id ;
    private String name = "";
    private String phone = "";
    private String address = "";
    private double monthlyRent ;
    private String state = "";

    public House(int id, String name, String phone, String address, double monthlyRent, String state) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.monthlyRent = monthlyRent;
        this.state = state;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getMonthlyRent() {
        return monthlyRent;
    }

    public void setMonthlyRent(double monthlyRent) {
        this.monthlyRent = monthlyRent;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return      id +
                "\t\t" + name +
                "\t" + phone +
                "\t\t" + address +
                "\t" + monthlyRent +
                "\t\t" + state ;
    }
}
