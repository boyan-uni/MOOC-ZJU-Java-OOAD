package ooad.w6_abstract_interface_7_iocmvc.project_FoxAndRabbit;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// 狐狸与兔子 入口
// 框架准备 数据准备 逐个Cell逻辑判断 循环操作 刷新
public class FoxAndRabbit {
    private Field theField;
    private View theView;
    private JFrame frame = new JFrame();

    // ActionListener 内部类
    private class StepAction implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Click!");
            step();            // 如果这个类不是内部类，就无法直接使用step和repaint！
            frame.repaint();
        }
    }

    public FoxAndRabbit(int size){
        // 准备Field
        theField = new Field(30,30);
        // 按几率随机准备Fox Rabbit 放入Cell[][] field
        for (int row = 0; row < theField.getHeight(); row++) {
            for (int col = 0; col < theField.getWidth(); col++) {
                double probability = Math.random();
                if (probability<0.05){
                    theField.place(row,col,new Fox());    // Fox
                } else if (probability<0.15){
                    theField.place(row,col,new Rabbit()); // Rabbit
                }
            }
        }
        // 准备View
        theView = new View(theField);
        // 设置JFrame参数
        // JFrame frame = new JFrame(); 转移成为成员变量
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setTitle("FoxAndRabbit");
        frame.add(theView);

        // + 添加 JButton（通过add 把一个部件/容器放到另一个容器中）
        JButton btnStep = new JButton("next step");
        frame.add(btnStep, BorderLayout.NORTH);

        // ⬇以下是一个匿名类，可以改写为内部类
        /*btnStep.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Click!");
                step();
                theView.repaint();
            }
        });*/
        btnStep.addActionListener(new StepAction());

        frame.pack();
        frame.setVisible(true);
    }

    void start(int step){
        for (int i = 0; i < step; i++) {
            step();
            theView.repaint();
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    void step(){
        for (int row = 0; row < theField.getHeight(); row++) {
            for (int col = 0; col < theField.getWidth(); col++) {
                Cell cell = theField.get(row,col); // 先接收，如果这个接口里有东西的话，就一定是F/R
                if (cell!=null) {
                    Animal animal = (Animal) cell;
                    // *grow
                    animal.grow(); // 先涨一岁，然后再判断，自然死亡就直接清掉
                    if (animal.isAlive()) {
                        // *move
                        theField.move(row,col,(Cell) animal);
                        // *breed
                        Animal baby = animal.breed();
                        if (baby!=null){
                            theField.placeARandomAdj(row,col,(Cell) baby);
                        }
                        // *eat
                        if (animal instanceof Fox){
                            theField.eatAction(row,col);
                        }
                    }else {
                        theField.clear(row,col); // 如果当前的格子里有动物，但处于死亡状态，就把它清理掉
                    }
                }
            }
        }
    }


    public static void main(String[] args) {
        FoxAndRabbit fnr = new FoxAndRabbit(50);
        //fnr.start(100);
    }
}
