package com.hspedu.qqclient.service;

import com.hspedu.qqcommon.Message;
import com.hspedu.qqcommon.MessageType;

import java.io.*;

/**
 * @author 唐子怡
 * @version 1.0
 * 该类完成文件传输服务
 */
public class FileClientService {
    /**
     * @param senderId 发送者id
     * @param getterId 接受者id
     * @param src      源文件路径
     * @param dest     要发送到的目的文件路径
     */
    public void sendFileToOne(String senderId, String getterId, String src, String dest) {
        Message message = new Message();
        message.setMesType(MessageType.MESSAGE_FILE_MES);//8
        message.setSender(senderId);
        message.setGetter(getterId);
        message.setSrc(src);
        message.setDest(dest);
        //1.读取文件，，，先把文件.jpg读取到客户端，字节数组
        FileInputStream fileInputStream = null;
        //将文件名src转化成字节数组
        byte[] fileBytes = new byte[(int) new File(src).length()];
        //2.将文件对应的字节数组封装到message对象
        try {
            fileInputStream = new FileInputStream(src);
            fileInputStream.read(fileBytes);//读取文件内容
            message.setFileByte(fileBytes);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            if(fileInputStream != null){
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        System.out.println("\n"+senderId+"给"+getterId+"发送文件"+src +"到对方的电脑目录"+dest);

        //3.发送message 对象给服务端
        try {
            ObjectOutputStream oos = new ObjectOutputStream(ManageClientConnectServerThread.getClientConnectServerThread(senderId).getSocket().getOutputStream());
            oos.writeObject(message);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


}
