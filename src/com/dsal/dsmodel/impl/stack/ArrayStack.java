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
        this.top = -1;
    }

    @Override
    public void push(Node node) {
        if (isFull()){
            System.out.println("当前ArrayStack已满，无法插入");
        } else {
            ArrayNode theNode = (ArrayNode) node;
            top++;
            stack[top] = theNode;
        }
    }

    @Override
    public Node pop() {
        if (isEmpty()){
            System.out.println("当前ArrayStack已空，无法出栈");
            return null;
        } else {
            ArrayNode node = (ArrayNode) getTop();
            stack[top] = null;
            top--;
            System.out.println("弹出栈顶元素："+node);
            return node;
        }
    }

    @Override
    public void traverse() {
        if (getLength()==0){
            System.out.println("当前栈为空");
        } else {
            System.out.println("打印栈内数据（从base->top）：");
            int count = 0;
            for(int flag = base; flag <= top; flag++){
                count++;
                System.out.println("当前遍历到第"+ count +"个结点（数组位序："+(count-1)+")，结点内存储的数据："+ stack[flag]);
            }
            System.out.println("-- 遍历结束 --");
        }
    }

    @Override
    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == (MaxSize-1);
    }


    @Override
    public int getLength() {
        return (top - base + 1);
    }

    @Override
    public Node getTop() {
        return this.stack[top];
    }

    // -- Unit Test --
    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(3);
        stack.push(new ArrayNode(22));
        stack.push(new ArrayNode(23));
        stack.push(new ArrayNode(24));
        stack.traverse();
        System.out.println("栈顶元素为："+ stack.getTop());
        stack.pop();
        stack.traverse();
        System.out.println("栈内元素个数："+ stack.getLength());
    }
}
