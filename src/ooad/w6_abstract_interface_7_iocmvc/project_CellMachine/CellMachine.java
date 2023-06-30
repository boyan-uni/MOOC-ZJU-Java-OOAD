package ooad.w6_abstract_interface_7_iocmvc.project_CellMachine;

import javax.swing.*;

public class CellMachine {
    // 细胞自动机 入口
    public static void main(String[] args) {
        // 初始化 Field
        Field field = new Field(30, 30);

        // 初始化每个Cell（往每个坐标放Cell对象,放入的新cell都是死亡状态）
        for (int row=0;row< field.getHeight();row++){
            for (int col=0;col< field.getWidth();col++){
                field.putCell(row,col,new Cell());
            }
        }
        // 随机把Cell reborn：遍历所有Cell，每个按一定的几率reborn（几率随机，但不大于0.2）
        for (int row=0;row< field.getHeight();row++){
            for (int col=0;col< field.getWidth();col++){
                Cell cell = field.getCell(row,col);
                // 按随机几率决定是否复活当前Cell
                if (Math.random() < 0.2) {
                    cell.reborn();
                }
            }
        }

        // 初始化 View
        View view = new View(field);
        // 初始化 View 中的 Frame
        JFrame frame = new JFrame(); // 通过repaint()刷新内容
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setTitle("CellMachine细胞自动机");
        frame.add(view);
        frame.pack();
        frame.setVisible(true);

        // 执行运行操作
        // 1000次整体遍历循环
        for (int i=0;i<1000;i++){
            // 逐个遍历每个Cell，根据运动条件改变Cell状态（进行逻辑判断，让整体动起来）
            for (int row=0;row<field.getHeight();row++){
                for (int col=0;col<field.getWidth();col++){
                    // 接收get到的cell的控制权
                    Cell cell = field.getCell(row,col);

                    System.out.println("this cell is alive ="+ cell.isAlive());

                    // 获取当前cell的neighborList进行逻辑判断
                    Cell[] neighbors = field.getNeighbors(row,col);
                    // 遍历判断出所有邻居中的alive的个数
                    int numOfLive=0;
                    for (Cell c: neighbors) {
                        if(c.isAlive()){
                            numOfLive++;
                        }
                    }
                    System.out.println(numOfLive);
                    //cell的状态改变逻辑
                    if ( cell.isAlive() ) {
                        if ( numOfLive <2 || numOfLive >3 ) {
                            cell.die();
                            System.out.print("die");
                            System.out.println();
                        }
                    } else if ( numOfLive == 3 ) {
                        cell.reborn();
                        System.out.print("reborn");
                        System.out.println();
                    }
                }
            }
            System.out.println("Update");
            // 每次整体遍历结束一次后，frame刷新，呈现最新的数据
            frame.repaint();
            // 每次整体遍历中间隔200ms，让user有时间阅读
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
