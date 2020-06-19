package com.zzz.client;

import java.io.Serializable;

/**
 * @program: 网络编程
 * @Author：ZZZ
 * @Description ：TODO
 * @Date：2020/6/19$ 15:21$
 * @Version: 1.0
 **/
public class User implements Serializable {

    private static final long serialVersionUID = 683396943197513414L;
    private String username;
    private String password;

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
