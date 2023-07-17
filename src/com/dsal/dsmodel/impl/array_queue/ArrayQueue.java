package com.dsal.dsmodel.impl.array_queue;

import com.dsal.dsmodel.adt.Queue;
import com.dsal.dsmodel.node.impl.ArrayNode;
import com.dsal.dsmodel.node.Node;

public class ArrayQueue implements Queue {

    protected int Max_Size;
    protected ArrayNode[] arrayQueue;
    protected int front;
    protected int rear;

    public ArrayQueue(int Max_Size){
        this.Max_Size = Max_Size;
        arrayQueue = new ArrayNode[Max_Size];
        front = 0;
        rear = 0;
    }

    @Override
    public void clear(){
        arrayQueue = new ArrayNode[Max_Size];
        front = 0;
        rear = 0;
    }

    @Override
    public void enQueue(int value){
        if (!isFull()){
            arrayQueue[rear] = new ArrayNode(value);
            rear++;
            System.out.println("在队尾插入成功");
        } else {
            System.out.println("当前ArrayQueue已满，无法插入");
        }
    }

    @Override
    public Node deQueue(){
        ArrayNode deNode = null;
        if (!isEmpty()){
            deNode = arrayQueue[front];
            front++;
        } else {
            System.out.println("当前ArrayQueue为空，无法删除");
        }
        return deNode;
    }

    @Override
    public void traverse() {
        if (getLength()>0){
            int count = 0;
            int flag = front;
            while (flag!=rear){
                ArrayNode node = arrayQueue[flag];
                count++;
                System.out.println("当前遍历到第" + count + "个结点：" + node);
                flag++;
            }
            System.out.println("--当前队列共 "+getLength()+" 个Node，遍历结束--");
        }else if (getLength()==0){
            System.out.println("当前队列为空，无法遍历，请先插入数据");
        }
    }

    @Override
    public boolean isEmpty(){
        if (front == rear){
            return true;
        }
        return false;
    }

    @Override
    public boolean isFull(){
        if (rear == Max_Size){
            return true;
        }
        return false;
    }

    @Override
    public int getLength(){
        return rear - front;
    }

    @Override
    public Node getHead(){
        return arrayQueue[front];
    }

}
