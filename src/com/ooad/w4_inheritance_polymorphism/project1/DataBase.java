package com.ooad.w4_inheritance_polymorphism.project1;

import java.util.ArrayList;

/** 媒体资料数据库
 *  1.0: 当前版本能完整实现功能要求，但在写的过程中也能感受到，CD DVD 的代码重复（冗余），维护/修改的工作量很大；
 *  Warning：写的过程中有很多复制的工作，这样的代码质量是不高的，而且基本没有可扩展性，新增要在各个地方修改很多内容；
 *  Solution？ 能否把CD、DVD的相同内容抽象为Item，Item的属性又要如何设置呢 */

public class DataBase {
    // 类别-动态存储列表
    ArrayList<CD> cdlist;
    ArrayList<DVD> dvdlist; // 一模一样的两个

    // constructor
    public DataBase() {
        this.cdlist = new ArrayList<CD>();
        this.dvdlist = new ArrayList<DVD>(); // 一模一样的两个
    }

    // 往对应list中添加内容 Overload
    public void add(CD cd){
        cdlist.add(cd);
    }
    public void add(DVD dvd){
        dvdlist.add(dvd);
    } // 一模一样的两个

    // list db内的内容 foreach sout对应list中的内容
    public void list(){
        for (CD cd : cdlist) {
            cd.print();
        }
        for (DVD dvd : dvdlist) {
            dvd.print();
        } // 一模一样的两个
    }

    // Test
    public static void main(String[] args) {
        // 初始化db
        DataBase db = new DataBase();
        db.add(new CD("a","xxx",10,10,true, "null"));
        db.add(new CD("b","xxx",10,10,true, "null"));
        db.add(new CD("c","xxx",10,10,true, "null"));
        db.add(new DVD("d","xxx",15,true,"null"));
        db.add(new DVD("e","xxx",15,true,"null"));
        db.add(new DVD("f","xxx",15,true,"null"));

        // 输出db中存储的内容
        db.list();
    }
}
