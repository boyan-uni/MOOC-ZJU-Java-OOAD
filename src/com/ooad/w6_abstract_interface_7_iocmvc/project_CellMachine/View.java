package com.ooad.w6_abstract_interface_7_iocmvc.project_CellMachine;

import javax.swing.*;
import java.awt.*;

public class View extends JPanel {
    // JPanel 参数
    private static final long serialVersionUID = -5258995676212660595L;
    private static final int GRID_SIZE = 16; // 每小方格的边长

    private Field theField; // 描绘View需要Field的数据

    // 构造函数 View
    public View(Field field){
        this.theField = field;
    }

    // 设置JPanel尺寸：Dimension是Java中一个表示二维空间尺寸的类。它封装了一个对象的宽度和高度，通常用于在Java GUI中设置组件的大小（例如JFrame、JPanel等）。
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(theField.getWidth()*GRID_SIZE+1, theField.getHeight()*GRID_SIZE+1);
        // +1 显示的尺寸稍微大一点，把最外层边框漏出来
    }

    // 最主要：画出来
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        // 遍历Field中的逐个Cell，用Cell自带的paint画出来
        for (int row=0;row<theField.getHeight();row++){
            for (int col=0;col<theField.getWidth();col++){
                // 如果这个坐标内有Cell，就可以开始画了
                if(theField.getCell(row,col)!=null){
                    theField.getCell(row,col).paint(g,row*GRID_SIZE,col*GRID_SIZE,GRID_SIZE);
                }
            }
        }
    }


    // 单独测试View面板能否正常显示
    public static void main(String[] args) {
        // 初始化 Field
        Field field = new Field(10,10);
        for ( int row = 0; row<field.getHeight(); row++ ) {
            for ( int col = 0; col<field.getWidth(); col++ ) {
                field.putCell(row, col, new Cell()); // 现在全是死亡Cell 均只有空框，没有填充！
            }
        }
        // 初始化 View
        View view = new View(field);
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setTitle("Cells");
        frame.add(view);
        frame.pack();
        frame.setVisible(true);

    }
}

// JPanel和JFrame都是Swing中常用的组件，功能和使用方法也比较相似，但是作用范围不同。JPanel主要用于组织其他组件，而JFrame则用于显示应用程序的主窗口。
// JPanel是一个通用的轻量级容器，用来组织其他组件。可以使用setLayout()来设置需要使用的布局管理器，并可以在面板上添加其他组件。
// JFrame是一个顶层窗口容器，它可以显示在屏幕上，并包含其他的Swing组件。JFrame一般继承于Window类，实现了RootPaneContainer接口。
// 在JFrame中，可以添加多个JPanel，实现对图形界面的复杂布局。