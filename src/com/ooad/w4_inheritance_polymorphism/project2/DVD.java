package com.ooad.w4_inheritance_polymorphism.project2;

public class DVD extends Item {

    // 属性 - 在Item基础上新增
    private String director;

    // constructor
    public DVD(String title, int playingTime, boolean gotIt, String comment, String director) {
        super(title, playingTime, gotIt, comment); // 在第一句话，把父类需要的参数传过去，通过调用父类构造器；
        this.director = director;
    }

    // print - 在Item基础上修改
    @Override
    public void print(){
        System.out.println("DVD:"+this.title+","+this.director);
    }
}
