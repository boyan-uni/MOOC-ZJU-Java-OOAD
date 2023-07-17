package com.dsal.dsmodel.impl.array_queue;
import com.dsal.dsmodel.adt.Queue;
import com.dsal.dsmodel.node.Node;

import java.util.Scanner;

public class Test {
    int select(){
        System.out.println("选择进入不同队列实现的测试（请输入序号：eg.1）：");
        System.out.println("(1) array queue");
        System.out.println("(2) circle array queue");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
    Queue place(){
        int select = select();
        if (select == 1){
            return new ArrayQueue(3);
        }else if (select == 2){
            return new CircleArrayQueue(4); // 需要一个额外的辅助空间
        }
        return null;
    }
    void showPrompt(){
        System.out.println("测试功能：");
        System.out.println("(s) show：显示队列全部内容");
        System.out.println("(a) add：添加新数据到队列");
        System.out.println("(g) get：出队队头数据");
        System.out.println("(h) head：访问得到队头数据");
        System.out.println("(e) exit：退出程序");
        System.out.println("请根据提示信息输入你的操作字符：");
    }

    public static void main(String[] args) {
        Test test = new Test();
        Queue queue = test.place();
        char in;
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while(loop){
            test.showPrompt();
            in = scanner.next().charAt(0); // 从输入台获取一个字符
            switch (in){
                case 's':
                    queue.traverse();
                    break;
                case 'a':
                    System.out.println("请输入插入队列新结点的数值(int类型)：");
                    Scanner scanner2 = new Scanner(System.in);
                    queue.enQueue(scanner2.nextInt());
                    break;
                case 'g': // 因为需要获取Node到本层进一步筛选显示信息，所以try-catch设置在这里，下同
                    try{
                        Node node = queue.deQueue();
                        System.out.println("出队操作完成，出队结点数据为："+node);
                    }catch (NullPointerException e){
                        System.out.println("返回的出队结点是空指针，有可能的情况是：当前队列内无元素，出队失败");
                    }
                case 'h':
                    try{
                        Node node = queue.getHead();
                        System.out.println("当前队列队头数据为："+node);
                    }catch (NullPointerException e){
                        System.out.println("返回的头结点是空指针，有可能的情况是：当前队列内无元素");
                    }
                    break;
                case 'e':
                    System.out.println("退出程序");
                    scanner.close();
                    loop = false;
                    break;
                default:
                    System.out.println("该功能尚在开发，请重新操作");
                    break;
            }
        }
    }
}
