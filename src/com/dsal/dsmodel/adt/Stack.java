package com.dsal.dsmodel.adt;

import com.dsal.dsmodel.node.Node;

public interface Stack {
    // 构造函数 一个空的⬆数据结构

    // 入栈
    void push(Node node);
    // 出栈
    Node pop();

    // 遍历
    void traverse();

    // 属性 getter setter
    boolean isEmpty();
    int getLength();

    Node getTop();
}
