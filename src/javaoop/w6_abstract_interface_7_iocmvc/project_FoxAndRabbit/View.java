package javaoop.w6_abstract_interface_7_iocmvc.project_FoxAndRabbit;

// 视图层 1.放JPanel JFrame相关组件 2.paint()把Field中的内容逐个画出来（完整一遍）

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

    // 设置整个JPanel尺寸：Dimension是Java中一个表示二维空间尺寸的类。它封装了一个对象的宽度和高度，通常用于在Java GUI中设置组件的大小（例如JFrame、JPanel等）。
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(theField.getWidth()*GRID_SIZE+1, theField.getHeight()*GRID_SIZE+1);
    }

    // 最主要：画  图层1.画底框  图层2.后续画object
    // 无需手动调用，像toString一样自动覆盖的
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        // 画灰色底框
        g.setColor(Color.gray);
        for (int row = 0; row < theField.getHeight(); row++){
            for (int col = 0; col < theField.getWidth(); col++){
                g.drawLine(0, col*GRID_SIZE,theField.getHeight()*GRID_SIZE,col*GRID_SIZE);
                g.drawLine(row*GRID_SIZE,0,row*GRID_SIZE,theField.getWidth()*GRID_SIZE);
            }
        }
        // 画每个位置的object（直接调用Cell.draw 后续会根据传进来不同的object 调用相应的具体的draw函数）
        for (int row = 0; row < theField.getHeight(); row++) {
            for (int col = 0; col < theField.getWidth(); col++) {
                Cell cell = theField.get(row,col);
                if (cell!=null){
                    cell.draw(g,row*GRID_SIZE,col*GRID_SIZE,GRID_SIZE);
                }
            }
        }
    }

    // 单独测试View面板能否正常显示
    public static void main(String[] args) {
        // 初始化 Field
        Field field = new Field(30,30);

        // 初始化 View
        View view = new View(field);
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setTitle("FoxnRabbit");
        frame.add(view);
        frame.pack();
        frame.setVisible(true);
    }
}
