package com.zzz.client;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * @program: 网络编程
 * @Author：ZZZ
 * @Description ：TODO
 * @Date：2020/6/19$ 15:26$
 * @Version: 1.0
 **/
public class LoginClient {
    public static void main(String[] args) throws IOException {
        Socket client = new Socket("localhost",8888);
        OutputStream os = client.getOutputStream();
        //完成登录功能，需要传输一个user对象
        User user = getUser();
        //传输对象需要ObjectOutputStream
        ObjectOutputStream oos = new ObjectOutputStream(os);
        oos.writeObject(user);
        //调用shutdown方法告诉对方传输完成
        client.shutdownOutput();
        //接收响应
        DataInputStream dis = new DataInputStream(client.getInputStream());
        String str = dis.readUTF();
        System.out.println(str);
        //关闭流操作
        dis.close();
        oos.close();
        os.close();
        client.close();
    }

    public static User getUser(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入用户名:");
        String username = scanner.nextLine();
        System.out.println("请输入密码:");
        String password = scanner.nextLine();
        return new User(username,password);
    }
}
