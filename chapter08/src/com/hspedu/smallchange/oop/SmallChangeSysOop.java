package com.hspedu.smallchange.oop;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/*
该类是完成零钱通的各个功能的类，面向对象编程
1) 先完成显示菜单，并可以选择
2) 完成零钱通明细. 3) 完成收益入账
4) 消费
5) 退出
* */
public class SmallChangeSysOop {
    boolean loop = true;
    Scanner scanner = new Scanner(System.in);
    String key = "" ;
    //2:完成零钱通明细
    String details = "------------零钱通明细----------";
    //3.完成收益入账
    //完成数据的初始化
    double money = 0;
    double balance = 0;
    Date date = null;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm");
    //4.消费
    String note = "";
    //5.用户输入4后，需要确认输入的是否是y/n
    String choice = "";

    public void showMenu(){
        do{//因为菜单至少要打印一次，所以用do while
            System.out.println("========零钱通菜单=========");
            System.out.println("\t\t\t\t1 零钱通明细");
            System.out.println("\t\t\t\t2 收益入账");
            System.out.println("\t\t\t\t3 消费");
            System.out.println("\t\t\t\t4 退    出");
            System.out.print("请选择(1-4):");
            key = scanner.next() ;
            //  date =new Date();
            switch(key){
                case "1":this.detail() ;
                    break;

                case "2": this.income();
                    break;
                case "3":this.pay();
                    break;
                case "4":
                    this.exit();

                    break;//只有将loop置为false才会退出循环，否则就只是退出switch语句
                default:
                    System.out.println("您输入的数错误.....");
            }
        }while(loop);
    }
    public void detail(){
        System.out.println(details);//这里明明可以直接输出“零钱通明细”，但是它用details来表示，why
        //现在知道了，是为了记录数据，在获得收益之后 输出 1就会显示所有的明细，但假如只输出字 就没有 金额时间
        System.out.println();
    }
    public void income(){
        System.out.print("收益金额：");
        money = scanner.nextDouble();
        balance +=money;
        date = new Date();
        if(money <= 0){
            System.out.println("收益金额应该大于 0;");
            return;//break必须添加，否则就
        }
        //只显示一次是因为没有+=
        details += "\n收益入账\t+"+money+"\t"+sdf.format(date)+"\t" +"余额:"+balance;
        // System.out.println(details);

    }
    public void pay(){
        System.out.print("消费金额：");
        money = scanner.nextDouble();
        if(money <= 0 || money >= balance){
            System.out.println("消费金额有误;");
            return;
        }
        System.out.print("消费说明：");
        note = scanner.next();
        date = new Date();
        balance -= money;
        details += "\n"+note+"\t-"+money+"\t"+sdf.format(date)+"\t" +"余额:"+balance;
    }
    public void exit(){
        System.out.print("请输入y/n:");
        while(true){
            choice = scanner.next();

            if(choice.equals("y") || choice.equals("n"))
                break;
            System.out.println("您的输入不正确，请输入y/n ");
        }
        if("y".equals(choice)){//if里面不能用 == 判断，==比较的是地址，会判断成false ，equal才行
            loop = false;
            System.out.println("退出零钱通系统...");
        }
    }
}
