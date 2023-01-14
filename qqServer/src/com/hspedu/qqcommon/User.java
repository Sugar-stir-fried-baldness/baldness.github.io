package com.hspedu.qqcommon;

import java.io.Serializable;

/**
 * @author 唐子怡
 * @version 1.0\
 * qqcommon 共有的包的 意思
 *
 * 表示一个用户/客户信息
 *
 * 如果一个类/对象想通过 Object 的方式来读写的话，所对应的类需要序列化(IO流那里有讲)
 */
public class User implements Serializable{
    //表示 客户端和服务端，通讯时的一个消息对象
    private static final long serialVersionUID = 1L;
    private String userid;//用户名/ID
    private String passwd;//用户 密码

    public User(){}
    public User(String userid, String passwd) {
        this.userid = userid;
        this.passwd = passwd;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }
}
