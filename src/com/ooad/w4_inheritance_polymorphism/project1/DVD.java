package com.ooad.w4_inheritance_polymorphism.project1;

public class DVD {
    // 属性
    private String title;
    private String director;
    private int playingTime;
    private boolean gotIt = false;
    private String comment;

    // constructor
    public DVD(String title, String director, int playingTime, boolean gotIt, String comment) {
        // super(); 如果有父类的话
        this.title = title;
        this.director = director;
        this.playingTime = playingTime;
        this.gotIt = gotIt;
        this.comment = comment;
    }

    // print
    public void print(){
        System.out.println("DVD:"+this.title);
    }
}
