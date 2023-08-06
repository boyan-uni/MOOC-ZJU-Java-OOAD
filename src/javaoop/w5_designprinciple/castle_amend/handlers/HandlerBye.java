package javaoop.w5_designprinciple.castle_amend.handlers;

import javaoop.w5_designprinciple.castle_amend.Game;

public class HandlerBye extends Handler{

    // constructor
    public HandlerBye(Game game) {
        super(game);
    }

    @Override
    public boolean isBye() {
        return true; // 到这就确定肯定是bye了
    }

    @Override
    public void doCmd(String cmd) {
        System.out.println("感谢您的光临。再见！");
    }
}
