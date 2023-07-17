package com.dsal.dsmodel.impl.linkedlist;

import com.dsal.dsmodel.adt.LinkedList;
import com.dsal.dsmodel.node.Node;
import com.dsal.dsmodel.node.impl.SingleLinkedListNode;

public class CircleSingleLinkedList extends SingleLinkedList implements LinkedList {

    public CircleSingleLinkedList() {
        this.head = new SingleLinkedListNode("HEAD->");
        this.head.setNext(this.head);
        this.length = 0;
    }

    @Override
    public void insertRear(Node node) {
        SingleLinkedListNode theNode = (SingleLinkedListNode) node;
        SingleLinkedListNode flag = (SingleLinkedListNode) moveFlagTo(length);
        flag.setNext(theNode);
        theNode.setNext(head);
        length++;
    }

    @Override
    public boolean isEmpty() {
        return this.head.getNext() == head;
    }

    @Override
    public boolean canFlagMove(Node flag) {
        SingleLinkedListNode node = (SingleLinkedListNode) flag;
        return (node.getNext()!=head);
    }

    // -- Unit Test --
    public static void main(String[] args) {
        CircleSingleLinkedList list = new CircleSingleLinkedList();
        SingleLinkedListNode A1 = new SingleLinkedListNode("A1");
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
