package com.dsal.dsmodel.impl.stack;

import com.dsal.dsmodel.adt.Stack;
import com.dsal.dsmodel.node.Node;
import com.dsal.dsmodel.node.impl.SingleLinkedListNode;

public class LinkedStack implements Stack {

    private int length;
    private SingleLinkedListNode top;
    private SingleLinkedListNode base;

    public LinkedStack(){
        this.length = 0;
        this.top = null;
        this.base = null;
    }

    @Override
    public void push(Node node) {
        SingleLinkedListNode theNode = (SingleLinkedListNode) node;
        if (length == 0){
            top = theNode;
            base = theNode;
            base.setNext(null);
        } else {
            theNode.setNext(top);
            top = theNode;
        }
        length++;
    }

    @Override
    public Node pop() {
        if (isEmpty()){
            System.out.println("当前LinkedStack已空，无法出栈");
            return null;
        } if (getLength()==1){
            SingleLinkedListNode node = top;
            top = null;
            base = null;
            length--;
            return node;
        } else {
            SingleLinkedListNode node = top;
            top = top.getNext();
            node.setNext(null);
            length--;
            return null;
        }
    }

    @Override
    public void traverse() {
        if (getLength()==0){
            System.out.println("当前栈为空");
        } else {
            System.out.println("打印栈内数据（从base->top）：");
            SingleLinkedListNode flag = top;
            while (flag.getNext()!=null){
                System.out.println("遍历到："+ flag);
                flag = flag.getNext();
            }
            if (flag == base){
                System.out.println("遍历到："+ flag);
            }
            System.out.println("-- 遍历结束 --");
        }
    }

    @Override
    public boolean isEmpty() {
        return this.top == null;
    }

    @Override
    public int getLength() {
        return this.length;
    }

    @Override
    public Node getTop() {
        return this.top;
    }


    // -- Unit Test --
    public static void main(String[] args) {
        LinkedStack stack = new LinkedStack();
        stack.push(new SingleLinkedListNode("Hi Stack"));
        stack.pop();
        stack.push(new SingleLinkedListNode("Hi 1"));
        stack.push(new SingleLinkedListNode("Hi 2"));
        stack.push(new SingleLinkedListNode("Hi 3"));
        stack.traverse();
    }
}
