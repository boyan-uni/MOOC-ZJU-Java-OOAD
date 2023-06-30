package dsal.ds.queue.impl;

import dsal.ds.queue.QueueADT;
import dsal.ds.queue.node.ArrayNode;

public class ArrayQueue implements QueueADT {
    private int Max_Size;
    private ArrayNode[] arrayQueue;
    private int front;
    private int rear;

    public ArrayQueue(int Max_Size){
        this.Max_Size = Max_Size;
        arrayQueue = new ArrayNode[Max_Size];
        front = -1;
        rear = -1;
    }
    @Override
    public void clear(){
        arrayQueue = new ArrayNode[Max_Size];
        front = -1;
        rear = -1;
    }
    @Override
    public boolean isEmpty(){
        if (front == rear){
            return true;
        } else {
            return false;
        }
    }
    @Override
    public int getLength(){
        return (rear-front);
    }
    @Override
    public ArrayNode getHeadNode(){
        return arrayQueue[front+1];
    }
    @Override
    public void enQueue(int value){
        if (isEnable()){
            rear++;
            arrayQueue[rear] = new ArrayNode(value);
            System.out.println("在队尾插入成功");
        } else {
            System.out.println("当前ArrayQueue已满，无法插入");
        }
    }
    boolean isEnable(){
        if (rear == (Max_Size-1)){
            return false;
        } else {
            return true;
        }
    }
    @Override
    public ArrayNode deQueue() throws NullPointerException{
        ArrayNode deNode = null;
        if (!isEmpty()){
            front++;
            deNode = arrayQueue[front];
        } else {
            System.out.println("当前ArrayQueue为空，无法删除");
        }
        return deNode;
    }
    @Override
    public void traverse(){
        int count = 1;
        for (ArrayNode node : arrayQueue){
            System.out.println("当前遍历到第" + count + "个结点，值为：" + node.getValue());
            count++;
        }
        System.out.println("--遍历结束--");
    }
}
