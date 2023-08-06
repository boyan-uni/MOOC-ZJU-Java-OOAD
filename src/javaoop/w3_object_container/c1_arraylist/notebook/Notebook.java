package javaoop.w3_object_container.c1_arraylist.notebook;

import java.util.ArrayList;
import java.util.Arrays;

public class Notebook {
    // 成员变量
    private ArrayList<String> note;

    // Constructor
    public Notebook(){
        note = new ArrayList<>();
    }

    // add 往notebook中加note
    public void add(String s){
        note.add(s);
    }
    public void add(int index,String s){
        note.add(index,s);
    }

    // getSize
    public int getSize(){
        return note.size();
    }

    // getNote
    public String getNote(int index){
        return note.get(index); // index 下标也是从0开始算的，和数组一样
    }

    // removeNote
    public void removeNote(int index){
        note.remove(index); // return 被 remove 的 object
    }

    // list
    public String[] list(){ // use String[] 数组来返回
        // new 一个 String[] 来存储返回值
        String[] s = new String[note.size()]; // String类型的数组的大小是note的个数
        note.toArray(s); // 把 note 中的内容 输入到 s 这个 string数组中
        return s;
    }

    // Test
    public static void main(String[] args) {
        Notebook nb = new Notebook();
        nb.add("first");
        System.out.println(nb.getSize());
        System.out.println(nb.getNote(0)); // Emphrasis Again：下标也是从0开始算的

        nb.add(0,"zero");
        System.out.println(nb.getSize());
        System.out.println(nb.getNote(0)); // add 0 zero

        System.out.println(Arrays.toString(nb.list())); // 不加Arrays.toString(Object) 输出地址

        nb.removeNote(0);
        System.out.println(nb.getSize());
        System.out.println(nb.getNote(0)); // remove 0 zero

        System.out.println(Arrays.toString(nb.list())); // 不加Arrays.toString(Object) 输出地址
    }
}
