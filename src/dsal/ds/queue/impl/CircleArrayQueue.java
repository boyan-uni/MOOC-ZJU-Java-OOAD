package dsal.ds.queue.impl;

import dsal.ds.queue.QueueADT;
import dsal.ds.queue.node.ArrayNode;
import dsal.ds.queue.node.Node;

public class CircleArrayQueue extends ArrayQueue implements QueueADT {

    public CircleArrayQueue(int Max_Size){
        super(Max_Size); // 逻辑环形，将队列容量空出一个作为约定；
    }
    @Override
    public boolean isFull(){
        if ((rear+1) % Max_Size == front){
            return true;
        }
        return false;
    }
    @Override
    public int getLength() {
        return (rear-front+Max_Size) % Max_Size;
    }
    @Override
    public void enQueue(int value) {
        if (!isFull()){
            arrayQueue[rear] = new ArrayNode(value);
            rear = (rear+1) % Max_Size;
            System.out.println("在队尾插入成功");
        } else {
            System.out.println("当前ArrayQueue已满，无法插入");
        }
    }
    @Override
    public Node deQueue() {
        ArrayNode deNode = null;
        if (!isEmpty()){
            deNode = arrayQueue[front];
            front = (front+1) % Max_Size;
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
                System.out.println("当前遍历到第" + count + "个结点，值为：" + node.getValue());
                flag = (flag+1)%Max_Size;
            }
            System.out.println("--当前队列共 "+getLength()+" 个Node，遍历结束--");
        }else if (getLength()==0){
            System.out.println("当前队列为空，无法遍历，请先插入数据");
        }
    }
}
