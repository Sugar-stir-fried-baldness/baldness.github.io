package com.hspedu.qqServer;

import com.hspedu.qqcommon.Message;
import com.hspedu.qqcommon.MessageType;

import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * @author 唐子怡
 * @version 1.0
 * 该类的一个对象 和某个客户通信的线程
 */
public class ServerConnectClientThread extends Thread {
    private Socket socket;
    private String userId;

    public ServerConnectClientThread(Socket socket, String userId) {
        this.socket = socket;
        this.userId = userId;
    }

    public Socket getSocket() {
        return socket;
    }

    @Override
    public void run() {

        while (true) {
            try {
                System.out.println("服务器和客户端" + userId + "保持通信，保持通信...");
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                Message message = (Message) ois.readObject();
                //后面会使用message ，根据message的类型，做相应的业务
                if (message.getMesType().equals(MessageType.MESSAGE_GET_ONLINE_FRIEND)) {//返回在线用户 4
                    //客户端要在线用户
                    /*
                    在线用户列表形式 100 200 300
                     */
                    System.out.println(message.getSender() + " 要在线用户列表");
                    String onlineUser = ManageClientThreads.getOnlineUser();
                    //返回message
                    //构建 一个Message对象,返回给客户端
                    Message message2 = new Message();
                    message2.setMesType(MessageType.MESSAGE_RET_ONLINE_FRIEND);
                    message2.setContent(onlineUser);//将在管理与客户的线程里面 获得的用户信息传给 “返回客户端的Message对象”
                    message2.setGetter(message.getSender());//客户端发送的 有中转站 服务端再次传输给客户端
                    //返回给客户端
                    ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                    oos.writeObject(message2);//将message2传输给客户端

//                } else if (message.getMesType().equals(MessageType.MESSAGE_OFFLINE_MES)) {// 离线9
//                    // message.setSender(message.getGetter());
//                    //根据message获取getter id，然后再得到对象的线程
//                    /**
//                     * 用户登录后，到服务端查找，如果getter = userid ，就取出集合中的id对应 的message对象，
//                     * 发送给客户端即可
//                     */
//                    new OfflineUserThread().SendOfflineMessage(message.getContent(), message.getSender(), message.getGetter());
//
////                    ServerConnectClientThread serverConnectClientThread = ManageClientThreads.getClientThread(message.getGetter());
////                    ObjectOutputStream oos = new ObjectOutputStream(serverConnectClientThread.getSocket().getOutputStream());
////                    oos.writeObject(message);
//
                }  else if (message.getMesType().equals(MessageType.MESSAGE_COMM_MES)) {// 私聊3



                    // message.setSender(message.getGetter());
                    //根据message获取getter id，然后再得到对象的线程
                    ServerConnectClientThread serverConnectClientThread = ManageClientThreads.getClientThread(message.getGetter());
                    ObjectOutputStream oos = new ObjectOutputStream(serverConnectClientThread.getSocket().getOutputStream());
                    oos.writeObject(message);
                } else if (message.getMesType().equals(MessageType.MESSAGE_CLIENT_EXIT)) {//客户端要退出 6
                    System.out.println(message.getSender() + "退出...");
                    //将客户端对应的线程，从集合中移除
                    ManageClientThreads.removeServerConnectClientThread(message.getSender());
                    socket.close();//关闭连接
                    break;//退出循环
                } else if (message.getMesType().equals(MessageType.MESSAGE_FILE_MES)) {//8 发送文件
                    ServerConnectClientThread serverConnectClientThread = ManageClientThreads.getClientThread(message.getGetter());
                    ObjectOutputStream oos = new ObjectOutputStream(serverConnectClientThread.getSocket().getOutputStream());
                    oos.writeObject(message);
                } else {
                    System.out.println("其他类型的message，现在先不管..");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
