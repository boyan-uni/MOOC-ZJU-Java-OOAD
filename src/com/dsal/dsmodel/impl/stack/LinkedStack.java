package com.dsal.dsmodel.impl.stack;

import com.dsal.dsmodel.adt.Stack;
import com.dsal.dsmodel.node.Node;

public class LinkedStack implements Stack {

    private int length;

    public LinkedStack(){
        this.length = 0;
    }

    @Override
    public void push(Node node) {

    }

    @Override
    public Node pop() {
        return null;
    }

    @Override
    public void traverse() {

    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int getLength() {
        return 0;
    }

    @Override
    public Node getTop() {
        return null;
    }
}
