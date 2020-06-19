package com.zzz.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @program: 网络编程
 * @Author：ZZZ
 * @Description ：TODO
 * @Date：2020/6/19$ 16:16$
 * @Version: 1.0
 **/
public class LoginServer {
    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(8888);
        while (true){
            Socket socket = serverSocket.accept();
            LoginThread lt = new LoginThread(socket);
            new Thread(lt).start();
        }
    }
}
