package dsal.ds.queue;

import dsal.ds.queue.node.Node;

public interface QueueADT { // ADT Operation
    void clear();
    boolean isEmpty();
    int getLength();
    Node getHeadNode();
    void enQueue(int value);
    Node deQueue();
    void traverse();
}