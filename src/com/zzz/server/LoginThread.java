package com.zzz.server;

import com.zzz.client.User;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @program: 网络编程
 * @Author：ZZZ
 * @Description ：TODO
 * @Date：2020/6/19$ 15:34$
 * @Version: 1.0
 **/
public class LoginThread implements Runnable{

    private Socket socket;

    public LoginThread(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        //需要使用ObjectInputStream
        ObjectInputStream ois = null;
        DataOutputStream dos = null;
        try {
            ois = new ObjectInputStream(socket.getInputStream());
            User user = (User) ois.readObject();
            String str = "";
            if("admin".equals(user.getUsername()) && "admin".equals(user.getPassword())){
                System.out.println("欢迎你:" + user.getUsername());
                str = "登录成功!";
            }else {
                str = "用户名或密码错误!";
            }
            //截断输入流
            socket.shutdownInput();
            //给客户端响应
            dos = new DataOutputStream(socket.getOutputStream());
            dos.writeUTF(str);
            socket.shutdownOutput();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                dos.close();
                ois.close();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
