package com.hspedu.encap;

public class Account {
    String name;
    int balance; //余额
    String password;//密码

    public String info(){
        //可以增加一个权限的校验，来判断是否显示密码if(){} else 你没有权限
        return "这个人的name = "+name+" balance = "+balance+" password = "+password;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name.length() >= 2 && name.length() <= 4){
            this.name = name;
        }
        else{
            System.out.println("请重新输入name");
        }
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        if(balance > 20){
            this.balance = balance;
        }
        else{
            System.out.println("您的余额低于20，请重新输入balance！");
         //   System.out.println("");
            this.balance = 0;
        }
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if(password.length() ==6 ){
            this.password = password;
        }
        else{
            System.out.println("请输入 6位 的密码！");
        }
    }
}
