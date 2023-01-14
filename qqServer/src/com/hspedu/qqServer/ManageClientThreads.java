package com.hspedu.qqServer;

import java.util.HashMap;
import java.util.Iterator;

/**
 * @author 唐子怡
 * @version 1.0
 * 该类用于 管理 和客户端通信的线程
 * 用HashMap
 */
public class ManageClientThreads {
    private static HashMap<String ,ServerConnectClientThread> hm = new HashMap<>();

    public static HashMap<String, ServerConnectClientThread> getHm() {
        return hm;
    }

    //添加线程到hm 集合
    public static void addClientThread(String userId, ServerConnectClientThread serverConnectClientThread){
        hm.put(userId,serverConnectClientThread);
    }
    //通过 userId 获取 ServerConnectClientThread
    public static ServerConnectClientThread getClientThread(String userId){
        return hm.get(userId);
    }

    //移除
    public static void removeServerConnectClientThread(String userId){
        hm.remove(userId);
    }
    //编写方法，可以返回在线用户列表
    public static String getOnlineUser(){
        //遍历 hashmap 的key
        Iterator<String> iterator = hm.keySet().iterator();
        String onlineUserList = new String();
        while(iterator.hasNext()){
            onlineUserList += iterator.next().toString()+" ";
        }
        return  onlineUserList;
    }
}
