package ooad.w10_socket;

/** 在这个例子中，
 *  服务器端启动后等待客户端连接，客户端连接到服务器并发送消息，服务器接收到消息后返回响应，直到客户端发送“bye”表示结束。
 *  客户端通过标准输入获取用户输入，并将输入发送给服务器，同时等待服务器的响应并打印出来。当用户输入“bye”时，客户端退出循环，关闭相关资源。
 * */

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(6666);
        System.out.println("服务器已启动，等待客户端连接...");

        Socket socket = serverSocket.accept();
        System.out.println("客户端已连接，IP地址为：" + socket.getInetAddress());

        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);

        String msg = "";
        while (!msg.equals("bye")) {
            msg = in.readLine();
            System.out.println("收到客户端消息：" + msg);
            out.println("服务器已收到你的消息：" + msg);
        }

        in.close();
        out.close();
        socket.close();
        serverSocket.close(); // 这些对象都继承自 Closeable类 用完要清爽的close掉
    }
}
