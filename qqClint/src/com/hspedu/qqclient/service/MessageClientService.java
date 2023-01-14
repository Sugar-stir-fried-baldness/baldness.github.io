package com.hspedu.qqclient.service;

import com.hspedu.qqcommon.Message;
import com.hspedu.qqcommon.MessageType;


import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * @author 唐子怡
 * @version 1.0
 * 管理 客户端和服务端通信的方法
 */
public class MessageClientService {

    public void sentMessageToOne(String content,String getterId,String senderId){
        //将消息构建成message对象，通过对应的socket发送给服务器
        Message message = new Message();
        message.setMesType(MessageType.MESSAGE_COMM_MES);//3
        message.setContent(content);
        message.setGetter(getterId);
        message.setSender(senderId);
        message.setSendTime(new java.util.Date().toString());
        //显示发送时间
        System.out.println(senderId+" 给 "+getterId+"发"+content);
        //在通信线程中，读取到发送的message消息，并显示即可
        try {
            ObjectOutputStream oos =
                    new ObjectOutputStream(new ManageClientConnectServerThread().getClientConnectServerThread(senderId).getSocket().getOutputStream());
            oos.writeObject(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
