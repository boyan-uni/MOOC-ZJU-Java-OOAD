package javaoop.w6_abstract_interface_7_iocmvc.project_FoxAndRabbit;

import java.awt.*;

public class Rabbit extends Animal implements Cell {
    // 构造Rabbit
    public Rabbit() {
        super(10, 2);
    }

    // draw Rabbit
    @Override
    public void draw(Graphics g, int row, int col, int size) {
        // 只填充：根据当前Animal的年龄画颜色深浅（通过变量，动态实现）
        int alpha = (int) ((1 - getAgePercent()) * 255);
        g.setColor(new Color(255, 0, 0, alpha));
        g.fillRect(row,col,size,size);
    }

    // 生育一个 Rabbit
    public Animal breed(){
        if (Math.random()<0.2 && isBreedable()){ // 按照一定的几率
            return new Rabbit();
        }
        else return null;
    }
}
