package com.hspedu.houseresent.service;

import com.hspedu.houseresent.domain.House;
import com.hspedu.houseresent.view.HouseView;

public class HouseService {
    private House[] houses;
    private int houseNum = 1;
    private int idCounter = 1;

    public House findById(int findId){//返回House对象，通过查找id

        //遍历数组
        for(int i = 0 ; i < houseNum; i++  ){
            if(findId == houses[i].getId()) {
               // System.out.println(houses[i]);
                return houses[i] ;
            }
        }
        return null;

    }

    public boolean del(int delId){//括号里是需要删除的id
        //这个方法主要是删除 , 1.那个编号是否是要删除的那个编号，如果是-1直接退出
        // 2.要通过编号id来删除
        //找到要删除的房屋信息对应的下标
        int index = -1;
        for(int i = index ; i < houseNum ; i++){
           if(delId == houses[i].getId()){
               index = i;//记录i的值
           }
        }
        //下标是 -1 ，退出
        if(index == -1){
            return false;//退出
        }
        //下标不是-1，
        for(int i = index ; i < houseNum -1 ; i++){//这里houseNum -1 因为最后一个已经被滞空
//交换，再将最后一个id滞空
            houses [i] = houses [i+1];
        }
        houses[--houseNum] = null;//houseNum总是比下标大1；
          return true;
    }
    public boolean add(House newHouses ){
        if(houseNum == houses.length){
            System.out.println("数组已满，不能继续添加...");
            return false;
        }
        //把房屋信息装进houses里面,再将num++，
        houses[houseNum++] = newHouses ;
        //先++idCounter再 将值set传入
         newHouses .setId(++idCounter);
        System.out.println("添加成功.....");
         return true;
    }
    //构造器
    public HouseService(int size){
        houses = new House[size];//当创建HouseService对象，指定数组大小

        //创建一个 初始化对象
        houses[0] = new House(1,"jack","118","海淀区",3000,"未出租");

    }
    public House[] list(){
        return houses;//House是对象，只能返回houses这个引用
    }
}
