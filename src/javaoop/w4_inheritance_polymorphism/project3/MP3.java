package javaoop.w4_inheritance_polymorphism.project3;

import javaoop.w4_inheritance_polymorphism.project2.Item;

public class MP3 extends Item {
    // 无新增属性

    // constructor
    public MP3(String title, int playingTime, boolean gotIt, String comment) {
        super(title, playingTime, gotIt, comment);
    }

    // print
    @Override
    public void print(){
        System.out.println("MP3:"+this.title);
    }
}
