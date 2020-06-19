package com.zzz.server;

import com.zzz.client.User;

import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @program: 网络编程
 * @Author：ZZZ
 * @Description ：TODO
 * @Date：2020/6/19$ 16:58$
 * @Version: 1.0
 **/
public class LoginServer2 {
        public static void main(String[] args) throws Exception {

            ServerSocket serverSocket = new ServerSocket(10000);
            Socket server = serverSocket.accept();
            //获取输入流对象
            InputStream inputStream = server.getInputStream();
            //需要使用ObjectInputStream对象
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
            User user = (User) objectInputStream.readObject();
            String str = "";
            if("msb".equals(user.getUsername()) && "msb".equals(user.getPassword())){
                System.out.println("欢迎你："+user.getUsername());
                str = "登录成功";
            }else{
                str="登录失败";
            }
            //截断输入流
            server.shutdownInput();
            //给客户端响应
            DataOutputStream outputStream = new DataOutputStream(server.getOutputStream());
            outputStream.writeUTF(str);
            server.shutdownOutput();
            //关闭流操作
            outputStream.close();
            inputStream.close();
            server.close();
            serverSocket.close();


        /* ServerSocket serverSocket = new ServerSocket(10000);
        while(true){
            Socket server = serverSocket.accept();
            //获取输入流对象
            InputStream inputStream = server.getInputStream();
            //需要使用ObjectInputStream对象
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
            User user = (User) objectInputStream.readObject();
            String str = "";
            if("msb".equals(user.getUsername()) && "msb".equals(user.getPassword())){
                System.out.println("欢迎你："+user.getUsername());
                str = "登录成功";
            }else{
                str="登录失败";
            }
            //截断输入流
            server.shutdownInput();
            //给客户端响应
            DataOutputStream outputStream = new DataOutputStream(server.getOutputStream());
            outputStream.writeUTF(str);
            server.shutdownOutput();
            //关闭流操作
            outputStream.close();
            inputStream.close();
            server.close();
        }
//        serverSocket.close();*/
        }
}

