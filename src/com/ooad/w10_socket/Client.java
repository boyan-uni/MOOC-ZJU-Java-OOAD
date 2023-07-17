package com.ooad.w10_socket;

import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        String serverIP = "127.0.0.1";
        int serverPort = 6666;
        Socket socket = new Socket(serverIP, serverPort);
        System.out.println("已成功连接服务器：" + socket.getInetAddress());

        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);

        BufferedReader line = new BufferedReader(new InputStreamReader(System.in));
        String msg = "";
        while (!msg.equals("bye")) {
            System.out.print("请输入要发送的消息：");
            msg = line.readLine();
            out.println(msg);

            String response = in.readLine();
            System.out.println("收到服务器响应：" + response);
        }

        line.close();
        in.close();
        out.close();
        socket.close();
    }
}
