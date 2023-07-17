package com.dsal.dsmodel.impl.linkedlist;

import com.dsal.dsmodel.node.Node;
import com.dsal.dsmodel.node.impl.SingleLinkedListNode;
import com.dsal.dsmodel.adt.LinkedList;

public class SingleLinkedList implements LinkedList {

    protected SingleLinkedListNode head;
    protected int length;

    public SingleLinkedList(){
        this.head = new SingleLinkedListNode("HEAD->",null);
        this.length = 0;
    }

    @Override
    public void insertFront(Node node) {
        SingleLinkedListNode theNode = (SingleLinkedListNode)node;
        theNode.setNext(this.head.getNext());
        this.head.setNext(theNode);
        length++;
    }

    @Override
    public void insertRear(Node node) {
        SingleLinkedListNode theNode = (SingleLinkedListNode) node;
        SingleLinkedListNode flag = (SingleLinkedListNode) moveFlagTo(length);
        flag.setNext(theNode);
        theNode.setNext(null);
        length++;
    }

    @Override
    public void insert(Node node, int location) {
        if (location == 1) {insertFront(node);}
        else if (location == length+1) {insertRear(node);}
        else if (location < 1 && location>=length){System.out.println("无效位序，请重新输入");}
        else {
            SingleLinkedListNode theNode = (SingleLinkedListNode) node;
            SingleLinkedListNode flag = (SingleLinkedListNode)moveFlagTo(location-1);
            theNode.setNext(flag.getNext());
            flag.setNext(theNode);
            length++;
        }
    }

    @Override
    public void delete(int location) {
        if (location<1 && location>length){
            System.out.println("无效位序，请重新输入");
        } else {
            SingleLinkedListNode flag = (SingleLinkedListNode)moveFlagTo(location-1);
            flag.setNext(flag.getNext().getNext());
            length--;
        }
    }

    @Override
    public String getDataByLocation(int location) {
        if (location<1 && location>length){
            System.out.println("无效位序，请重新输入");
            return null;
        } else {
            SingleLinkedListNode flag = (SingleLinkedListNode) moveFlagTo(location);
            return flag.getData();
        }
    }

    @Override
    public int getLocationByData(String data) {
        SingleLinkedListNode flag = head;
        int count = 0;
        boolean found = false;
        while(canFlagMove(flag)){
            flag = flag.getNext();
            count++;
            if (flag.getData().equals(data)){
                found = true;
                break;
            }
        }
        if (!found){
            System.out.println("链表中不存在该结点，返回值：0");
            return 0;
        }
        return count;
    }

    @Override
    public Node getPriorNode(Node current) {
        int cur_loc = getLocationByData(((SingleLinkedListNode) current).getData());
        if (cur_loc != 0) {
            return moveFlagTo(cur_loc - 1);
        }
        System.out.println("获取失败，请重新操作");
        return null;
    }

    @Override
    public Node getNextNode(Node current) {
        SingleLinkedListNode flag = (SingleLinkedListNode) current;
        return flag.getNext();
    }

    @Override
    public void traverse() {
        SingleLinkedListNode flag = head;
        int count = 0;
        System.out.println(flag.getData());
        while(canFlagMove(flag)){
            flag = flag.getNext();
            count++;
            System.out.println("遍历到第"+count+"个结点，值为："+flag.getData());
        }
    }

    @Override
    public boolean isEmpty() {
        return this.head.getNext() == null;
    }
    @Override
    public SingleLinkedListNode getHead() {
        return head;
    }
    @Override
    public int getLength(){
        return this.length;
    }
    @Override
    public Node moveFlagTo(int location) {
        if (location<1 && location>length){
            System.out.println("无效位序，请重新输入");
            return null;
        } else {
            int i = 0;
            SingleLinkedListNode flag = head;
            while (i<location){
                flag = flag.getNext();
                i++;
            }
            return flag;
        }
    }

    @Override
    public boolean canFlagMove(Node flag) {
        SingleLinkedListNode node = (SingleLinkedListNode) flag;
        return (node.getNext()!=null);
    }


    // -- Unit Test --
    public static void main(String[] args) {
        SingleLinkedList list = new SingleLinkedList();
        SingleLinkedListNode A1 = new SingleLinkedListNode("A1",null);
        list.insertFront(A1);
        list.insertRear(new SingleLinkedListNode("An"));
        list.insert(new SingleLinkedListNode("A2"),2);
        list.traverse();
        list.delete(2);
        list.traverse();
        System.out.println(list.getDataByLocation(1));
        System.out.println(list.getLocationByData("An"));
        System.out.println(list.getPriorNode(A1));
        System.out.println(list.getNextNode(A1));
    }
}
