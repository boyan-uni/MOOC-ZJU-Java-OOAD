package ooad.w6_abstract_interface_7_iocmvc.project_CellMachine;


import java.awt.*;

public class Cell {
    private boolean alive = false;

    public void die(){
        this.alive = false;
    }

    public void reborn(){
        this.alive = true;
    }

    public boolean isAlive() {
        return alive;
    }

    // 每一个Cell需要在View中把自己的格填充画出来（每个格里是一个Cell 只不过alive=true/false而已
    public void paint(Graphics g, int row,int col, int size){
        g.setColor(Color.black);
        g.drawRect(row,col,size,size);     // 画框
        if (this.alive){ // 如果活着 填充
            g.setColor(Color.red);         // 可以设定后续的动作的颜色！
            g.fillRect(row,col,size,size); // 参数：（中心横坐标，中心纵坐标， Rect长，Rect宽）
        }
    }
}

// Cell进行最基础的操作，任何涉及逻辑判断的都由Field纯数据层去处理