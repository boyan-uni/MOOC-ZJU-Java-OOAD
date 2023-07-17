package com.ooad.w5_designprinciple.castle_amend.handlers;

import com.ooad.w5_designprinciple.castle_amend.Game;

public class HandlerHelp extends Handler {

    // constructor
    public HandlerHelp(Game game) {
        super(game);
    }

    @Override
    public void doCmd(String cmd) {
        System.out.println("迷路了吗？你可以做的命令有：go bye help");
        System.out.println("如：go east");
    }
}
