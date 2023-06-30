package ooad.w4_inheritance_polymorphism.project1;

public class CD {
    // 属性
    private String title;
    private String artist;
    private int numofTracks;
    private int playingTime;
    private boolean gotIt = false;
    private String comment;

    // constructor
    public CD(String title, String artist, int numofTracks, int playingTime, boolean gotIt, String comment) {
        // super(); 如果有父类的话
        this.title = title;
        this.artist = artist;
        this.numofTracks = numofTracks;
        this.playingTime = playingTime;
        this.gotIt = gotIt;
        this.comment = comment;
    }

    // print
    public void print(){
        System.out.println("CD:"+this.title);
    }
}
