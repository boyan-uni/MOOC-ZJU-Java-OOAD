package com.dsal.dsmodel.node.impl;

import com.dsal.dsmodel.node.Node;

public class SingleLinkedListNode implements Node {
    String data;
    SingleLinkedListNode next;

    public SingleLinkedListNode(String data, SingleLinkedListNode next){
        this.data = data;
        this.next = next;
    }
    public SingleLinkedListNode(String data){
        this.data = data;
        this.next = null;
    }

    public String getData() {
        return data;
    }

    public SingleLinkedListNode getNext() {
        return next;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setNext(SingleLinkedListNode next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "SLNode{" +
                "data='" + data + '\'' +
                '}';
    }
}
