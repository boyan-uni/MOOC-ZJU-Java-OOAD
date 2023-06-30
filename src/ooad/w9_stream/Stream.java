package ooad.w9_stream;

import java.io.*;

// Test

public class Stream {
    public static void main(String[] args) {
        IO io = new IO();
        io.unicodeReader3();
    }
}


class IO{

    /* Byte层面的I/O
        测试用例：
        123abc: 读到了7字节，6个字节+一个空格站位
        123汉字abc: 读到了13字节，这里一个汉字占3个byte */

    void byteIO(){
        System.out.println("hello byteIO");
        byte[] buffer = new byte[1024];
        // All I/O Need Exception Handling
        try{
            int len = System.in.read(buffer);
            String s = new String(buffer,0,len);
            System.out.println("读到了"+len+"字节");
            System.out.println(s);
            System.out.println("s的长度是："+s.length());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /* Byte层面的文件I/O*/

    void fileByteIO(){
        System.out.println("hello fileIO");
        byte[] buffer = new byte[10];
        // 给数组赋初值 准备输出到文件的数据
        for (int i=0; i<buffer.length; i++) {
            buffer[i]=(byte) i;
        }

        try {
            FileOutputStream out = new FileOutputStream("a.dat"); // 创建了一个a.dat在java_learn目录下
            out.write(buffer); // byte类型的数组名
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("已完成在a.dat的output");
    }

    /* 嵌套流过滤器实现不止Byte层面的I/O */

    void filterIO(){
        System.out.println("hello filterIO 流过滤器");

        try {
            // 可以使用多层过滤器
            DataOutputStream out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("a.dat")));
            int i = 1024;
            out.writeInt(i); // 可以写int类型 以二进制形式写入到文件中
            out.close();
            System.out.println("已完成在a.dat的output");

            DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream("a.dat")));
            int j = in.readInt();
            System.out.println(j);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* 文本层面的I/O - Reader/Writer - 处理Unicode类型文本，在流上建立文本处理 */

    // Writer

    void unicodeWriter(){
        System.out.println("hello unicodeWriter");
        try {
            PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(new FileOutputStream("a.txt"))));
            int i = 1024; // int
            out.println(i);
            out.println("Hi Txt"); // 文本
            out.close();
            System.out.println("已完成在a.txt的output");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Reader

    // 1. BufferedReader

    void unicodeReader1(){
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream("/Users/lby/IdeaProjects/java_learn/src/ooad_ZheJiangUniversity/w9_stream/Main.java")));
            String line;
            while((line=in.readLine())!=null){ // 当读到文件末尾 in.readLine() return null 跳出循环
                System.out.println(line);      // 逐行输出文件内容
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 2. LineNumberReader：多了跟踪行号的功能，但不能帮助跳到想去的行数，setLineReader() 没有这个功能

    void unicodeReader2(){
        try {
            LineNumberReader in = new LineNumberReader(new InputStreamReader(new FileInputStream("/Users/lby/IdeaProjects/java_learn/src/ooad_ZheJiangUniversity/w9_stream/Main.java")));
            String line;
            // in.setLineNumber(3); 初始行号默认值为0
            while((line=in.readLine())!=null){
                System.out.println(in.getLineNumber()+":"+line); // in.getlineNumber() 从1开始跟踪行号
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    // 3. FileReader：InputStreamReader的子类，所有方法都自其继承来的

    void unicodeReader3(){
        try {
            BufferedReader in = new BufferedReader(new FileReader("/Users/lby/IdeaProjects/java_learn/a.txt"));
            String line;
            while((line=in.readLine())!=null){ // 当读到文件末尾 in.readLine() return null 跳出循环
                System.out.println(line);      // 逐行输出文件内容
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}




















