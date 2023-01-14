package com.hspedu.qqclient.view;


import com.hspedu.qqclient.service.FileClientService;
import com.hspedu.qqclient.service.MessageClientService;
import com.hspedu.qqclient.service.UserClientService;
import com.hspedu.qqclient.utils.Utility;

/**
 * @author 唐子怡
 * @version 1.0
 * <p>
 * 显示 qq界面
 */
public class QQView {

    private boolean loop = true;//控制是否显示菜单
    private String key = "";//选择
    private UserClientService userClientService = new UserClientService();//对象是用于登录服务器和注册用户
    private MessageClientService messageClientService = new MessageClientService();
    private FileClientService fileClientService = new FileClientService();
    public static void main(String[] args) {
        new QQView().mainMenu();

    }

    public void mainMenu() {


        while (loop) {
            System.out.println("===============用户通信系统===============");
            System.out.println("\t\t1.登录系统");
            System.out.println("\t\t9.退出系统");
            System.out.println("请输入你的选择：");
            key = Utility.readString(1);//限制输入的字符的大小

            //根据用户输入 ，来处理不同的逻辑
            switch (key) {
                case "1":
                    System.out.print("请输入用户名：");
                    String userId = Utility.readString(50);
                    System.out.print("请输入密 码：");
                    String pwd = Utility.readString(50);
                    // 这里比较麻烦，需要到服务端 去验证用户名 和 密码 是否合法
                    //因此 这里假设 为 true
                    if (userClientService. checkUser(userId,pwd)) {
                        System.out.println("===============欢迎用户"+userId+"登录===============");
                         while (loop) {
                             System.out.println("===============网络通信系统二级菜单(用户"+userId+")===============");
                             System.out.println("1 显示在线用户列表");
                             System.out.println("2 群发消息");
                             System.out.println("3 私聊消息");
                             System.out.println("4 发送文件");
                             System.out.println("9 退出系统");
                             System.out.println("请输入你的选择：");
                             key = Utility.readString(1);

                             switch (key) {
                                case "1":
                                    //写一个方法，显示在线用户列表
                                    // System.out.println(userId+"在线");
                                    userClientService.onlineFriendList();
                                    break;
                                case "2":
                                    System.out.println("群发消息");
                                    break;
                                case "3":
                                    System.out.print("请输入接受用户id：");
                                    String getter = Utility.readString(50);
                                    System.out.print("请输入发送内容：");
                                    String content = Utility.readString(100);
                                    messageClientService.sentMessageToOne(content,getter,userId);
                                    System.out.println("私聊消息");
                                    break;
                                case "4":
                                    System.out.print("请输入你想把文件发送的用户id:");
                                    String getterId = Utility.readString(50);
                                    System.out.print("请输入发送文件的源路径(形式：D:\\yy-jpg):");
                                    String src = Utility.readString(100);
                                    System.out.print("请输入发送文件的目的路径(形式：D:\\yy-jpg):");
                                    String dest = Utility.readString(100);
                                    fileClientService.sendFileToOne(userId,getterId,src,dest);
                                    //System.out.println("发送文件");
                                    break;
                                case "9":
                                    userClientService.logout();
                                    loop = false;
                                    break;
                            }
                        }
                    }else{
                        System.out.println("=============登录失败==============");
                    }
                    break;
                case "9":
                    loop = false;

                    break;
            }
        }
    }

}
