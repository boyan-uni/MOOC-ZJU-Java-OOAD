package com.ooad.w4_inheritance_polymorphism.project2;

public class CD extends Item {

    // 属性 - 在Item基础上新增
    private String artist;
    private int numofTracks;

    // constructor
    public CD(String title, int playingTime, boolean gotIt, String comment, String artist, int numofTracks) {
        super(title, playingTime, gotIt, comment); // 在第一句话，把父类需要的参数传过去，通过调用父类构造器；
        this.artist = artist;
        this.numofTracks = numofTracks;
    }

    // print - 在Item基础上修改
    @Override
    public void print(){
        System.out.println("CD:"+this.title+","+this.artist);
    }

    // toString - 通过generate可以勾选生成基础格式 这里Override的是Object类中的toString()
    @Override
    public String toString() {
        return "CD{" +
                "artist='" + artist + '\'' +
                ", numofTracks=" + numofTracks +
                ", title='" + title + '\'' +
                '}';
    }

    // equals - 通过generate可以勾选生成基础格式
    @Override
    public boolean equals(Object o) { // 用Object类型接收的实际CD对象
        if (this == o) return true;
        if (!(o instanceof CD)) return false;
        CD cd = (CD) o; // 所以这里需要"造型" 恢复原始类型
        return numofTracks == cd.numofTracks && artist.equals(cd.artist); // 对比非空字段
    }


}
