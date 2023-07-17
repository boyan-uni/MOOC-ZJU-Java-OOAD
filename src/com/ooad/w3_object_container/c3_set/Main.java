package com.ooad.w3_object_container.c3_set;

import java.util.HashSet;

public class Main {
    /**
     * java.util.Set 是一个抽象类，所以这里使用 java.util.HashSet 用来实现
     * */
    public static void main(String[] args) {
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("hello");
        hashSet.add("world");
        hashSet.add("hello"); // head insert 头插法， 新的数据元素插入在hashset的最前面

        System.out.println(hashSet); // set 中的 elem： 无序 唯一
    }
}
