package com.dsal.dsmodel.node.impl;

import com.dsal.dsmodel.node.Node;

public class DoubleLinkedListNode implements Node {
    String data;
    DoubleLinkedListNode next;
    DoubleLinkedListNode prior;

    public DoubleLinkedListNode(String data, DoubleLinkedListNode next, DoubleLinkedListNode prior) {
        this.data = data;
        this.next = next;
        this.prior = prior;
    }

    public DoubleLinkedListNode(String data) {
        this.data = data;
        this.next = null;
        this.prior = null;
    }

    // * DLNode的特性：自我删除
    public void delete(){
        this.getNext().setPrior(this.getPrior());
        this.getPrior().setNext(this.getNext());
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public DoubleLinkedListNode getNext() {
        return next;
    }

    public void setNext(DoubleLinkedListNode next) {
        this.next = next;
    }

    public DoubleLinkedListNode getPrior() {
        return prior;
    }

    public void setPrior(DoubleLinkedListNode prior) {
        this.prior = prior;
    }

    @Override
    public String toString() {
        return "DLNode{" +
                "data='" + data + '\'' +
                '}';
    }
}
