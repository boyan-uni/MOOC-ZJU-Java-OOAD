package dsal.ds.queue.node;

public class ArrayNode implements Node{
    private int value;

    public ArrayNode(int value) {
        this.value = value;
    }
    @Override
    public int getValue() {
        return value;
    }
}
