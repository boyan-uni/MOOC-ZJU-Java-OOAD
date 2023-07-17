package com.dsal.dsmodel.impl.stack;

import com.dsal.dsmodel.adt.Stack;
import com.dsal.dsmodel.node.Node;
import com.dsal.dsmodel.node.impl.ArrayNode;

public class ArrayStack implements Stack {

    private int MaxSize;
    ArrayNode[] stack;
    private int top;
    private static final int base = 0;

    public ArrayStack(int maxsize){
        this.MaxSize = maxsize;
        this.stack = new ArrayNode[MaxSize];
        this.top = 0;
    }

    @Override
    public void push(Node node) {
        ArrayNode theNode = (ArrayNode) node;

    }

    @Override
    public Node pop() {
        return null;
    }

    @Override
    public void traverse() {
        int count = 0;
        System.out.println("打印栈内数据（从base->top）：");
        for (ArrayNode node: this.stack) {
            System.out.println("当前遍历到第"+ count +"个结点，结点内存储的数据："+ node);
        }
        System.out.println("-- 遍历结束 --");
    }

    @Override
    public boolean isEmpty() {
        return top == base;
    }

    public boolean isFull() {
        return top == (MaxSize-1);
    }


    @Override
    public int getLength() {
        return (top - base);
    }

    @Override
    public Node getTop() {
        return this.stack[top];
    }

    // -- Unit Test --
    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(3);
        System.out.println(stack.isEmpty());

    }
}
