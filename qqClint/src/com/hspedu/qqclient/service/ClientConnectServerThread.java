package com.hspedu.qqclient.service;

import com.hspedu.qqcommon.Message;
import com.hspedu.qqcommon.MessageType;

import java.io.*;
import java.net.Socket;

/**
 * @author 唐子怡
 * @version 1.0
 * 客户端连接服务端的线程
 * <p>
 * run 方法，线程
 */
public class ClientConnectServerThread extends Thread {
    //该线程需要Socket
    private Socket socket;

    public ClientConnectServerThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {

        while (true) {
            try {
                System.out.println("客户端线程，等待读取从服务端发送的信息:");
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                Message message = (Message) ois.readObject();//如果服务器端没有 Message发送过来，线程会堵塞在这里
                //后续 需要处理这个Message
                //需要对这个message做校验
                if (message.getMesType().equals(MessageType.MESSAGE_RET_ONLINE_FRIEND)) {
                    //从服务端传来的数据类型 正确
                    //取出在线用户信息，并显示
                    String[] onlineUser = message.getContent().split(" ");
                    System.out.println("============在线用户显示=============");
                    //循环读取用户id
                    for (int i = 0; i < onlineUser.length; i++) {
                        System.out.println("用户: " + onlineUser[i]);
                    }
                } else if (message.getMesType().equals(MessageType.MESSAGE_TO_ALL_MES)) {//7
                    //如果服务器那里有消息发过来,输出一句话
                    System.out.println("\n" + message.getSender() + "对大家伙" + "说" + message.getContent());
                } else if (message.getMesType().equals(MessageType.MESSAGE_OFFLINE_MES)) {//9
                    System.out.println("\n" + message.getSender() + "对" + message.getGetter() + "离线发送了 " + message.getContent());

                } else if (message.getMesType().equals(MessageType.MESSAGE_COMM_MES)) {
                    //如果服务器那里有消息发过来,输出一句话
                    System.out.println("\n" + message.getSender() + "对" + message.getGetter() + "说" + message.getContent());
                } else if (message.getMesType().equals(MessageType.MESSAGE_FILE_MES)) {

                    System.out.println("\n" + message.getSender() + "给" + message.getGetter() + "发送文件" + message.getSrc() + "到对方的电脑目录" + message.getDest());
                    //在接到该文件的消息后，将该文件保存到磁盘
                    //取出message的文件字节数组，通过文件输出流写出到磁盘
                    FileOutputStream fos = new FileOutputStream(message.getDest());//写到目的路径上
                    fos.write(message.getFileByte());
                    fos.close();
                    System.out.println("保存成功！！！");
                } else {
                    System.out.println("暂时不做处理...");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }
}
