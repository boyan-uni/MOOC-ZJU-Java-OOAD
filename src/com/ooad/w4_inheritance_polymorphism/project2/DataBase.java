package com.ooad.w4_inheritance_polymorphism.project2;

import com.ooad.w4_inheritance_polymorphism.project3.MP3;

import java.util.ArrayList;

/** 媒体资料数据库
 *  2.0: 把CD、DVD的相同内容提取为Item公共类为父类，Item是一个正常的类；*/

public class DataBase { // Step：修改DataBase的认知，现在db只认识Item
    // 类别-动态存储列表：CD DVD 都放入Item
    ArrayList<Item> list;

    // constructor
    public DataBase() {
        this.list = new ArrayList<Item>();
    }

    // add
    public void add(Item item){
        list.add(item);
    }

    // list db中的内容
    public void list(){
        for (Item item : list) {
            item.print();
        }
    }

    // Test
    public static void main(String[] args) {
        // 初始化db
        DataBase db = new DataBase();

        // Item的子类是CD和DVD 所以可以直接存储
        db.add(new CD("a",10,true,"null","xxx", 10)); // add(Item item);
        db.add(new CD("b",10,true,"null","xxx", 10));
        db.add(new CD("c",10,true,"null","xxx", 10));
        db.add(new DVD("d",15,true,"null","xxx"));
        db.add(new DVD("e",15,true,"null","xxx"));
        db.add(new DVD("f",15,true,"null","xxx"));

        // 输出db中存储的内容
        db.list();

        // Test 向上造型
        Item item = new Item("a",0,true,"...");
        CD cd = new CD("abc",0,true,"...","xxx",10);

        // Error
        // cd = item;      直接反向，会报错，是不安全的
        // cd = (CD)item;  运行报错，无法强制把Item类型转换为CD

        item = cd; // 现在让item的 声明类型=Item，动态类型改为=CD，item内实际存储管理一个cd
        // CD cc = item;   现在理论上是正确的，但编译器绕不过来，所以手动cast一下
        CD cc = (CD)item;  // 其实现在 item：声明类型=动态类型=CD，再传进CD cc，就没有问题了
        System.out.println(cc);
        System.out.println(cd.equals(cc)); // true 判断两个管理者是否管理的同一个对象，这里管理的是同一个地址

        // Test MP3
        db.add(new MP3("music",15,true,"..."));
        db.list();
    }
}

