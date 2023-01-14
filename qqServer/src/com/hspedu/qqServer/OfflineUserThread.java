package com.hspedu.qqServer;

import com.hspedu.qqcommon.Message;
import com.hspedu.qqcommon.MessageType;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author 唐子怡
 * @version 1.0
 * 离线用户线程
 *
 * 实现离线留言：如果某个用户不在线，登陆后，可以接受离线的消息
 * 实现离线发文件：如果某个用户不在线，登陆后，可以接受离线的文件
 *
 * 服务端：
 * 1.当有客户发消息，如果用户不在线
 * 2.先把离线消息message存放到服务的ConcurrentHashMap
 * 3.用户登录后，到服务端查找，如果getter = userid ，就取出集合中的id对应 的message对象，发送给客户端即可
 *
 */
public class OfflineUserThread {
    //存放离线message db
    private static ConcurrentHashMap<String, ArrayList<Message>> hm = new ConcurrentHashMap<>();

    public static ConcurrentHashMap<String, ArrayList<Message>> getHm() {
        return hm;
    }

    public static void setHm(ConcurrentHashMap<String, ArrayList<Message>> hm) {
        OfflineUserThread.hm = hm;
    }
//    public static ArrayList addConcurrentHashMap(String userId, ArrayList message){
//        return hm.put(userId,message);
//    }

    //判断用户是在线还是离线

    public void SendOfflineMessage(String content,String sender,String getter){
        Message message = new Message();
        message.setMesType(MessageType.MESSAGE_OFFLINE_MES);//9
        message.setSender(sender);
        message.setGetter(getter);
        message.setSendTime(new Date().toString());
        System.out.println(sender+"对"+getter+"离线发送了 "+content);

        /**
         * 把离线消息message存放到服务的ConcurrentHashMap
         */
        ArrayList<Message> message2 = new ArrayList<>();
        message2.add(message);
        hm.put(sender,message2);
        //获取message对应的socket ，，由于是hm,先得到线程
       // HashMap<String, ServerConnectClientThread> hm = ManageClientThreads.getHm();

        /**
         * 用户登录后，到服务端查找，如果getter = userid ，就取出集合中的id对应 的message对象，
         * 发送给客户端即可
         */
        //
       /* Iterator<String> iterator = hm.keySet().iterator();//key-value key就是id,value就是线程
        while (iterator.hasNext()) {//遍历
            String onLineUserId = iterator.next().toString();
            //得到线程,将信息写入 传输给客户端
            ServerConnectClientThread serverConnectClientThread = hm.get(onLineUserId);
            try {            //ObjectOutputStream oos = new ObjectOutputStream(hm.get(onLineUserId).getSocket().getOutputStream());
                ObjectOutputStream oos = new ObjectOutputStream(serverConnectClientThread.getSocket().getOutputStream());
                oos.writeObject(message);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }*/
    }

}
