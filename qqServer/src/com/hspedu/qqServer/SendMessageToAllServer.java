package com.hspedu.qqServer;

import com.hspedu.qqcommon.Message;
import com.hspedu.qqcommon.MessageType;
import com.hspedu.utils.Utility;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;

/**
 * @author 唐子怡
 * @version 1.0
 * 群发消息
 * 在服务器启动一条独立线程，专门负责发送推送新闻
 */
public class SendMessageToAllServer implements Runnable {

    @Override
    public void run() {
        while (true) {
            System.out.println("请输入群发消息内容：(exit退出)");
            String news = Utility.readString(100);
            if(news.equals("exit")){
                break;
            }
            Message message = new Message();
            message.setSender("服务器");
            message.setContent(news);
            message.setSendTime(new Date().toString());
            message.setMesType(MessageType.MESSAGE_TO_ALL_MES);
            System.out.println("服务器对所有人说:" + news);
            //获取message对应的socket ，，由于是hm,先得到线程
            HashMap<String, ServerConnectClientThread> hm = ManageClientThreads.getHm();

            Iterator<String> iterator = hm.keySet().iterator();//key-value key就是id,value就是线程
            while (iterator.hasNext()) {//遍历
                String onLineUserId = iterator.next().toString();
                //得到线程
                ServerConnectClientThread serverConnectClientThread = hm.get(onLineUserId);
                try {            //ObjectOutputStream oos = new ObjectOutputStream(hm.get(onLineUserId).getSocket().getOutputStream());
                    ObjectOutputStream oos = new ObjectOutputStream(serverConnectClientThread.getSocket().getOutputStream());
                    oos.writeObject(message);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

        }
    }
}
