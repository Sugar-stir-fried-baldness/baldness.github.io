package com.hspedu.houseresent.view;

import com.hspedu.houseresent.domain.House;
import com.hspedu.houseresent.service.HouseService;
import com.hspedu.houseresent.utils.Utility;

public class HouseView {

    private char key = ' ';
    private boolean loop = true;

    //这里 要在外面创建这个houses这个对象 **** 很重要
    //在view里面调用service方法，这个就很重要
    private HouseService housesService = new HouseService(10);

    public void updateHouse(){
        System.out.println("====================修改房屋=================");
        System.out.print("请选择待修改房屋编号(-1退出)");
        int updateId = Utility.readInt();
        if(updateId == -1){
            System.out.println("====================退出修改房屋=================");
            return;
        }
        //首先需要查找id，看存不存在，然后再找要修改的东西

        //老师提示：  返回的是引用类型【即 ：就是数组里的元素
        //因此老师在后面对house.setXxx(),就会修改HouseService数组的元素
        House house = housesService.findById(updateId);
        if(house == null){
            System.out.println("====================修改房屋信息不存在=================");
        }
        System.out.print("姓名("+house.getName() +"):");
        String name = Utility.readString(8,"");
        //如果用户直接回车表示不修改该信息，默认""
        if(! "".equals(name)){//修改
            house.setName(name);
        }

        System.out.print("电话("+house.getPhone() +"):");
        String phone = Utility.readString(12,"");
        if(! "".equals(phone)){//修改
            house.setPhone(phone);
        }

        System.out.print("地址("+house.getAddress() +"):");
        String address = Utility.readString(12,"");
        if(! "".equals(address)){//修改
            house.setAddress(address) ;
        }
        System.out.print("租金("+house.getMonthlyRent() +"):");
        int rent = Utility.readInt(4);
        if(rent != -1){//修改
            house.setMonthlyRent(rent);
        }
        System.out.print("状态("+house.getState() +"):");
        String state = Utility.readString(4,"");
        if(! "".equals(state)){//修改
            house.setState(state);
        }
    }
    public void exit(){
       char c =  Utility.readConfirmSelection() ;
       if(c == 'Y'){
           loop = false;
       }
    }
    public void findHouse(){
        System.out.println("====================查找房屋=================");
        System.out.print("请输入你要查找的id:");
        int id = Utility.readInt();
        //调用方法
        House house = housesService.findById(id);
        if(house != null){
            System.out.println(house);
        }
        else{
            System.out.println("查找的房屋id不存在");
        }
    }
//删除界面
    public void delHouse(){
        System.out.println("====================删除房屋=================");
        System.out.println("请选择待删除房屋编号(-1退出):");
        int id = Utility.readInt() ;//需要加一个判断
        if(id == -1){
            System.out.println("====================退出删除房屋信息=================");
            return;
        }
        System.out.println("确认是否删除(Y/N):请小心选择:");
        System.out.println("请输入你的选择(Y/N)");
        char choice = Utility.readMenuSelection();
        if(choice == 'Y' ){
           if(housesService.del(id) ) {
               System.out.println("====================删除房屋成功=================");
           }else {
               System.out.println("====================房屋的id不存在，删除失败=================");
           }
        }else {
            System.out.println("====================放弃删除房屋信息=================");
        }
    }
    public void addHouse( ){
        System.out.println("---------------------添加房屋----------------------");
        System.out.print("姓名：");
        String name = Utility.readString(8) ;
        System.out.print("电话：");
      String phoneNumber = Utility.readString(10);
        System.out.print("地址：");
     String address = Utility.readString(4);
        System.out.print("租金：");
       int monthlyRent = Utility.readInt() ;
        System.out.print("状态：");
        String state  = Utility.readString(3);
        House newHoses = new House(0, name, phoneNumber, address, monthlyRent, state);
        //调用add( )
        if(housesService.add(newHoses)){
            System.out.println("------------------添加完成-----------------");
        }else{
            System.out.println("------------------添加失败-----------------");
        }

    }
    public void listHouses(){
        System.out.println("====================添加房屋=================");
        System.out.println("编号\t\t房主\t\t电话\t\t地址\t\t月租\t\t状态(未出租/已出租)");
//先创建一个service的对象，然后调用housesService的list()方法
        //前面已经声明了housesService的大小
        House[]  houses = housesService.list();
        for (int i = 0; i < houses.length; i++) {
            if(houses[i] == null){
                break;
            }
            System.out.println(houses[i]);
        }
        System.out.println("====================添加完成=================");
    }
    //主菜单
    public void mainMenu() {
        do {
            System.out.println("====================房屋出租系统=================");
            System.out.println("\t\t\t1 新 增 房 源");
            System.out.println("\t\t\t2 查 找 房 屋");
            System.out.println("\t\t\t3 删 除 房 屋");
            System.out.println("\t\t\t4 修 改 房 屋 信 息");
            System.out.println("\t\t\t5 房 屋 列 表");
            System.out.println("\t\t\t6 退        出");
            System.out.print("请选择(1-6)：");
            key = Utility.readChar();
            switch (key) {
                case '1'://添加房屋
                    addHouse();
                    break;
                case '2':
                    findHouse();
                    break;
                case '3':
                    delHouse();
                    break;
                case '4':
                    updateHouse();
                    break;
                case '5':
                  listHouses() ;
                    break;
                case '6':
                    exit();
                    break;
                default:
                    System.out.println("nothing...");
            }


        } while (loop);

    }
}