package com.dsal.dsmodel.adt;

import com.dsal.dsmodel.node.Node;

public interface Queue {
    // 构造函数 一个空的⬆数据结构
    void clear();

    // 插入
    void enQueue(int value);

    // 删除
    Node deQueue();

    // 遍历
    void traverse();

    // 属性 getter setter
    boolean isEmpty();
    boolean isFull();
    int getLength();

    Node getHead();
}
