package com.hspedu.qqServer;

import com.hspedu.qqcommon.Message;
import com.hspedu.qqcommon.MessageType;
import com.hspedu.qqcommon.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author 唐子怡
 * @version 1.0
 */
public class QQServer {
    private ServerSocket ss = null;

    //private static ConcurrentHashMap<String, ArrayList<Message>> db = new ConcurrentHashMap<>();

    public QQServer(){

        try {
            System.out.println("服务器在 9999 端口监听....");
            new Thread(new SendMessageToAllServer()).start();
            ss = new ServerSocket(9999);

            //由于 在
            while(true) {//当合某个客户端 连接后，会继续监听，因此用while
                Socket socket = ss.accept();
                //得到socket相关联对象的输入流，
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                User u = (User) ois.readObject();//读取客户端发送的user对象

                ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());

                //创建一个Message对象，来回复客户端
                Message message = new Message();


                //验证 客户端传来的 用户信息是否符合规范 -->(这里 后面需要用HashMap 集合来...这里先用固定的来写)
                if( u.getPasswd().equals("123456")){//合法，就登录,需要Message
                    //u.getUserid().equals("100") &&
                    message.setMesType(MessageType.MESSAGE_LOGIN_SUCCEED);//成功
                    //把信息message打回去
                    oos.writeObject(message);
                    //创建一个线程，和客户端保持通信，该线程需要持有socket对象
                    ServerConnectClientThread serverConnectClientThread = new ServerConnectClientThread(socket, u.getUserid());
                    //启动该线程
                    serverConnectClientThread.start();

                    //把该线程对象，放入到一个集合中，进行管理+-
                    ManageClientThreads.addClientThread(u.getUserid(), serverConnectClientThread);





                }else{//登录失败,就不能启动和服务器通信的线程，
                    //把Message 的类型 置为false(2)
                    message.setMesType(MessageType.MESSAGE_LOGIN_FAIL);
                    oos.writeObject(message);//即使 登录失败也需要 将信息打回去
                    //关闭socket
                    socket.close();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                ss.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
