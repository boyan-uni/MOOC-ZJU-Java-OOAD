package com.ooad.w6_abstract_interface_7_iocmvc.project_FoxAndRabbit;

import java.awt.*;

public class Fox extends Animal implements Cell{
    // 构造Fox
    public Fox() {
        super(20, 4);
    }

    // draw Fox
    @Override
    public void draw(Graphics g, int row, int col, int size) {
        // 只填充：根据当前Animal的年龄颜色深浅（通过变量，动态实现）
        int alpha = (int) ((1 - getAgePercent()) * 255);
        g.setColor(new Color(0, 0, 0, alpha));
        g.fillRect(row,col,size,size);
    }

    // 生育一个 Fox
    public Animal breed(){
        if (Math.random()<0.2 && isBreedable()){ // 按照一定的几率
            return new Fox();
        }
        else return null;
    }
}
