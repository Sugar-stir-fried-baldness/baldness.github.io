package com.hspedu.houseresent.oop;

import java.util.Scanner;
public class HouseResentAppOop {
    private String details = " ";
    private boolean loop = true;
    private String id = "";
    private String name = "";
    private String phoneNumber = "";
    private String address = "";
    private double monthlyRent;
    private String state = "";
    private String choice = "";
    Scanner scanner = new Scanner(System.in);

    public void test() {
        do {
            //因为后面detail会改，但是 这个不能改，因此单独用一个函数将它存储起来
            System.out.println("------------------------房屋出租系统--------------------");
            System.out.println("\t\t\t\t1 新增房源");
            System.out.println("\t\t\t\t2 查找房源");
            System.out.println("\t\t\t\t3 删除房源");
            System.out.println("\t\t\t\t4 修改房屋信息");
            System.out.println("\t\t\t\t5 房屋列表");
            System.out.println("\t\t\t\t6 退     出");
            System.out.print("请选择(1-6)：");
            id = scanner.next();
            switch (id) {
                case "1":
                    this.houseAdd();break;

                case "2":
                    this.findHouse();break;

                case "3":
                    this.deleteHouse();break;

                case "4":
                    this.modifyHouse();break;

                case "5":showHouse();break;

                case "6":exit();break;

                default:

            }
        } while (loop);
    }

    public void detail() {
        System.out.println(details);
    }

    public void houseAdd() {
        System.out.println("---------------------添加房屋----------------------");
        System.out.print("姓名：");
        name = scanner.next();
        System.out.print("电话：");
        phoneNumber = scanner.next();
        System.out.print("地址：");
        address = scanner.next();
        System.out.print("租金：");
        monthlyRent = scanner.nextDouble();
        System.out.print("状态：");
        state = scanner.next();
        details += "\n\t" + name + "\t" + phoneNumber + "\t" + address + "\t" + monthlyRent + "\t" + state;
      //  System.out.println(details);
        System.out.println("------------------添加完成-----------------");
    }

    public void findHouse() {//查找房源
        System.out.println("---------------------查找房屋----------------------");
        System.out.print("请输入你要查找id: ");
        id = scanner.next();
        //显示

        this.showHouse();
        System.out.println();
    }

    public void deleteHouse() {
        System.out.println("---------------删除房屋---------------");
        System.out.print("请选择待删除编号(-1退出)");
        id = scanner.next();
        choice = scanner.next();
        while (true) {
            if (choice.equals("Y") || choice.equals("N")) {
                System.out.println("确认是否删除(Y/N):请小心选择：");
                System.out.println("请输入你的选择(Y/N)");
                if (choice.equals("Y")) {
                    System.out.println("---------------------修改完成----------------------");
                    return;
                }
            }

        }

    }

    public void modifyHouse() {
        System.out.println("-------------------修改房屋-----------------------");
        System.out.println("请选择待修改房屋编号(-1退出):");
        System.out.print("姓名：");
        name = scanner.next();
        System.out.print("电话：");
        phoneNumber = scanner.next();
        System.out.print("地址：");
        address = scanner.next();
        System.out.print("租金：");
        monthlyRent = scanner.nextDouble();
        System.out.print("状态：");
        state = scanner.next();
        if (this.state.equals("未出租") || this.state.equals("已出租")) {
            System.out.println("---------------------修改完成----------------------");
        } else {
            state = scanner.next();
        }
    }

    public void showHouse() {
        System.out.println("---------------------房屋列表----------------------");
        details += "\n\t房主" + "\t电话" + "\t地址" + "\t月租" + "\t状态";
        details += "\n\t" + name + "\t" + phoneNumber + "\t" + address + "\t" + monthlyRent + "\t" + state;
        System.out.println(details);
        System.out.println("---------------------房屋列表完成----------------------");
    }

    public void exit() {
        System.out.println("请输入你的选择(Y/N)");
        while (true) {

            if (choice.equals("Y") || choice.equals("N"))
                break;
            System.out.println("选择错误，请重新输入:");

        }

        if ("Y".equals(choice)) {

            loop = false;
            System.out.println("你退出了程序");
        }
    }
}