package com.dsal.dsmodel.node.impl;

import com.dsal.dsmodel.node.Node;

public class ArrayNode implements Node {
    private int value;

    public ArrayNode(int value) {
        this.value = value;
    }

    @Override
    public String toString(){
        return "Node{" +
                "data='" + value + '\'' +
                '}';
    }
}
