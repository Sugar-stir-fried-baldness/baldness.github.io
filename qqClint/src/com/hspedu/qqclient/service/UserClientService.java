package com.hspedu.qqclient.service;

import com.hspedu.qqcommon.Message;
import com.hspedu.qqcommon.MessageType;
import com.hspedu.qqcommon.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @author 唐子怡
 * @version 1.0
 * 该类完成 用户登录验证 和 用户注册 等功能
 */
public class UserClientService {
    private User u  = new User();
    Socket socket;
    //根据userId 和 pwd到服务器验证该用户是否合法
    public boolean checkUser(String userId,String pwd){
        //创建 User 对象
        u.setUserid(userId);
        u.setPasswd(pwd);
        boolean b = false;
        //连接到服务端 ，发送 u对象

        try {
            socket = new Socket(InetAddress.getByName("127.0.0.1"),9999);//127.0.0.1
            //得到 ObjectOutputStream 对象
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(u);//发送user对象

            //读取从 服务器回复的 Message对象
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            Message mes =(Message) ois.readObject();

            if(mes.getMesType().equals(MessageType.MESSAGE_LOGIN_SUCCEED)){
                //成功,然后创建一个和服务器端保持通信的线程


                ClientConnectServerThread clientConnectServerThread = new ClientConnectServerThread(socket);
                //启动客户端
                clientConnectServerThread.start();
                //为了 后面用户端的扩展，将线程放入集合管理
                ManageClientConnectServerThread.addClientConnectServerThread(userId,clientConnectServerThread);


                b = true;
            }else{
                //如果登录失败，就不能启动和服务器通信的线程，关闭socket
                socket.close();

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return  b;
    }

    //向服务端请求在线用户列表
    public void onlineFriendList(){

        //发送一个Message对象
        Message message = new Message();
        message.setMesType(MessageType.MESSAGE_GET_ONLINE_FRIEND);
        message.setSender(u.getUserid());
        //发送给服务器

        try {
//            ObjectOutputStream oos =  new ObjectOutputStream(
//                    ManageClientConnectServerThread.getClientConnectServerThread(u.getUserid(), new ClientConnectServerThread(socket.getOutputStream()) );
            //从管理线程的集合中获取 clientConnectServerThread 对象
            ClientConnectServerThread clientConnectServerThread = new ManageClientConnectServerThread().getClientConnectServerThread(u.getUserid());
            //通过这个线程获取相关联的 socket对象
            Socket socket = clientConnectServerThread.getSocket();
            //得到当前线程对应的socket 相关联的 ObjectOutputStream对象
            ObjectOutputStream oos = new ObjectOutputStream( socket.getOutputStream());
            //将信息message写入 ， 传输到服务端
            oos.writeObject(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //编写方法，退出客户端，并给服务端发送一个退出系统的message对象
    public void logout(){
        Message message = new Message();
        message.setMesType(MessageType.MESSAGE_CLIENT_EXIT);
        message.setSender(u.getUserid());

        //发送message
        try {
           // ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            ObjectOutputStream oos = new ObjectOutputStream(
                    ManageClientConnectServerThread.getClientConnectServerThread(u.getUserid()).getSocket().getOutputStream());
            oos.writeObject(message);
            System.out.println(u.getUserid()+" 退出系统 ");
            System.exit(0);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
