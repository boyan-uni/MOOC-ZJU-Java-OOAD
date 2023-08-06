package javaoop.w4_inheritance_polymorphism.project2;

public class Item { // Next Step：提取共有的内容，减少CD DVD …… 存在的代码冗余，提高新增类别时的可扩展性

    //
    protected String title;
    private int playingTime;
    private boolean gotIt = false;
    private String comment;

    // constructor
    public Item(String title, int playingTime, boolean gotIt, String comment) {
        this.title = title;
        this.playingTime = playingTime;
        this.gotIt = gotIt;
        this.comment = comment;
    }

    // 被使用时要print，格式上来说，有就行
    public void print() { }
}
