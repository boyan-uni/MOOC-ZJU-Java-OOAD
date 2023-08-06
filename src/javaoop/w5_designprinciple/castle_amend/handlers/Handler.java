package javaoop.w5_designprinciple.castle_amend.handlers;

// 控制中转站

import javaoop.w5_designprinciple.castle_amend.Game;

public class Handler {
    // Game - protected 方便继承
    protected Game game;
    // constructor
    public Handler(Game game) {
        this.game = game;
    }

    // 判断bye 是因为要break 其他两个就不用判断
    public boolean isBye(){
        return false;
    } // 默认值 override里修改

    // execute
    public void doCmd(String cmd){}
}
