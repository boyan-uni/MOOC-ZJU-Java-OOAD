package javaoop.w5_designprinciple.castle_amend;

import java.util.HashMap;

public class Room {
    // 成员变量
    private String name; // 房间名称
    private HashMap<String,Room> exits; // this的" "方向上，是"Room"为出口

    // constructor
    public Room(String name)
    {
        this.name = name;
        this.exits = new HashMap<>();
    }

    // 接口

    // 提示房间的所有出口方向
    public StringBuffer showExists(){
        StringBuffer s = new StringBuffer();
        for (String i: this.exits.keySet()) {
            s.append(i+" ");
        }
        return s;
    }

    // 设置房间的出口（方位，房间名）
    public void setExits(String direction, Room room) {
        this.exits.put(direction, room);
    }

    // 根据方位查询房间是否有这个方位
    public Room hasExist(String direction){
        return this.exits.get(direction);
    }


    @Override
    public String toString()
    {
        return name;
    }
}
