package com.hspedu.qqclient.service;

import java.util.HashMap;

/**
 * @author 唐子怡
 * @version 1.0
 * 该类 管理客户端连接到服务端的线程  的类
 *
 * 用集合管理线程
 */
public class ManageClientConnectServerThread {
//把多个线程放入 到hashMap集合，key就是用户id，value就是 线程
    private static HashMap<String,ClientConnectServerThread> hm = new HashMap<>();

    public static ClientConnectServerThread getClientConnectServerThread(String userid){
        return hm.get(userid);
    }
    //将某个线程加入到集合
    public static void addClientConnectServerThread(String userid,ClientConnectServerThread clientConnectServerThread){
        hm.put(userid,clientConnectServerThread);
    }

}
