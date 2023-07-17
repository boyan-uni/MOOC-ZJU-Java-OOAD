package com.dsal.dsmodel.adt;

import com.dsal.dsmodel.node.Node;

public interface LinkedList {
    // 构造函数 一个空的⬆数据结构

    // insert 单个结点
    // 1.始终在A1插入
    // 2.始终在An插入
    // 3.指定在第Ai个位置前面插入
    void insertFront(Node node);
    void insertRear(Node node);
    void insert(Node node, int location);

    // delete - 删除Ai结点
    void delete(int location);

    // 查找
    // 1.（按位序查找）return：第i个结点的data值
    // 2.（按值查找）  return：data是否在表中，若有返回位序i
    // 3. 前驱结点
    // 4. 后继结点
    String getDataByLocation(int location);
    int getLocationByData(String data);
    Node getPriorNode(Node current);
    Node getNextNode(Node current);

    // traverse - 遍历当前链表的每一个结点
    void traverse();

    // 属性 getter setter
    boolean isEmpty();
    Node getHead();
    int getLength();

    // 封装
    Node moveFlagTo(int location);
    boolean canFlagMove(Node flag);
}
