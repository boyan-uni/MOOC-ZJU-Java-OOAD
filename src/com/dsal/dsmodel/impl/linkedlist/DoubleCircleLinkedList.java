package com.dsal.dsmodel.impl.linkedlist;

import com.dsal.dsmodel.adt.LinkedList;
import com.dsal.dsmodel.node.Node;
import com.dsal.dsmodel.node.impl.DoubleLinkedListNode;

public class DoubleCircleLinkedList implements LinkedList {

    protected DoubleLinkedListNode head;
    protected int length;

    public DoubleCircleLinkedList() {
        this.head = new DoubleLinkedListNode("HEAD->");
        this.head.setPrior(this.head);
        this.head.setNext(this.head);
        this.length = 0;
    }

    @Override
    public void insertFront(Node node) {
        DoubleLinkedListNode theNode = (DoubleLinkedListNode) node;
        head.getNext().setPrior(theNode);
        theNode.setNext(head.getNext());
        head.setNext(theNode);
        theNode.setPrior(head);
        length++;
    }

    @Override
    public void insertRear(Node node) {
        DoubleLinkedListNode theNode = (DoubleLinkedListNode) node;
        DoubleLinkedListNode flag = (DoubleLinkedListNode)moveFlagTo(length);
        flag.setNext(theNode);
        theNode.setPrior(flag);
        head.setPrior(theNode);
        theNode.setNext(head);
        length++;
    }

    @Override
    public void insert(Node node, int location) {
        if (location == 1) {insertFront(node);}
        else if (location == length+1) {insertRear(node);}
        else if (location < 1 && location>=length){System.out.println("无效位序，请重新输入");}
        else {
            DoubleLinkedListNode theNode = (DoubleLinkedListNode) node;
            DoubleLinkedListNode flag = (DoubleLinkedListNode)moveFlagTo(location-1);
            flag.getNext().setPrior(theNode);
            theNode.setNext(flag.getNext());
            flag.setNext(theNode);
            theNode.setPrior(flag);
            length++;
        }
    }

    @Override
    // todo
    public void delete(int location) {
        DoubleLinkedListNode flag = (DoubleLinkedListNode) moveFlagTo(location);
        flag.delete();
    }

    @Override
    public String getDataByLocation(int location) {
        if (location<1 && location>length){
            System.out.println("无效位序，请重新输入");
            return null;
        } else {
            DoubleLinkedListNode flag = (DoubleLinkedListNode) moveFlagTo(location);
            return flag.getData();
        }
    }

    @Override
    public int getLocationByData(String data) {
        DoubleLinkedListNode flag = head;
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
        DoubleLinkedListNode flag = (DoubleLinkedListNode) current;
        return flag.getPrior();
    }

    @Override
    public Node getNextNode(Node current) {
        DoubleLinkedListNode flag = (DoubleLinkedListNode) current;
        return flag.getNext();
    }

    @Override
    public void traverse() {
        DoubleLinkedListNode flag = head;
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
        return head.getNext() == head || head.getPrior() == head;
    }

    @Override
    public DoubleLinkedListNode getHead() {
        return this.head;
    }

    @Override
    public int getLength() {
        return length;
    }

    @Override
    public Node moveFlagTo(int location) {
        if (location<1 && location>length){
            System.out.println("无效位序，请重新输入");
            return null;
        } else {
            int i = 0;
            DoubleLinkedListNode flag = head;
            while (i<location){
                flag = flag.getNext();
                i++;
            }
            return flag;
        }
    }

    @Override
    public boolean canFlagMove(Node flag) {
        DoubleLinkedListNode node = (DoubleLinkedListNode) flag;
        return node.getNext()!=head;
    }

    // -- Unit Test --
    public static void main(String[] args) {
        DoubleCircleLinkedList list = new DoubleCircleLinkedList();
        DoubleLinkedListNode A1 = new DoubleLinkedListNode("A1");
        list.insertFront(A1);
        list.insertRear(new DoubleLinkedListNode("An"));
        list.insert(new DoubleLinkedListNode("A2"),2);
        System.out.println("当前表长：" + list.length);
        list.traverse();
        list.delete(2);
        list.traverse();
        System.out.println(list.getDataByLocation(1));
        System.out.println(list.getLocationByData("An"));
        System.out.println(list.getPriorNode(A1));
        System.out.println(list.getNextNode(A1));
    }
}
