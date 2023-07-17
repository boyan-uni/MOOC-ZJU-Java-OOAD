package com.ooad.w3_object_container.c4_hashmap;

import java.util.HashMap;

public class Coin {
    private HashMap<Integer,String> coinnames = new HashMap<>(); // 必须大写的数据类型 基本数据类型不可以

    // constructor
    public Coin(){
        coinnames.put(1,"penny");
        coinnames.put(10,"dime");
        coinnames.put(25,"quarter");
        coinnames.put(50,"half-dollar");
        coinnames.put(50,"5毛"); // 会更新掉key=50 的value数值，因为 keySet 无序 不重复

        // 所有container都可以通过sout(name)直接打印所有内容！
        System.out.println(coinnames);

        // 遍历HashMap的每一对<,>Elem：通过 for each 循环
        for (Integer k : coinnames.keySet()) { // 可以遍历到每个key值
            System.out.println("Key: "+k+", Value: "+coinnames.get(k));
        }

    }

    // 通过金额返回名称
    public String getName(int amount){
        //如果有 return Name
        if (coinnames.containsKey(amount)){
            return coinnames.get(amount);
        }
        //如果没有 return "Not Found"
        else {
            return "Not Found";
        }
    }

    // Test
    public static void main(String[] args) {
        Coin coin = new Coin();
        System.out.println(coin.getName(10)); // dime
        System.out.println(coin.getName(15)); // Not Found
    }
}