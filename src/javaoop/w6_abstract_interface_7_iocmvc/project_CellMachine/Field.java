package javaoop.w6_abstract_interface_7_iocmvc.project_CellMachine;

// 纯数据层，搭建细胞自动机的Cell[][]框架，进行需要的逻辑判断，操纵Cell完成动作

import java.util.ArrayList;

public class Field {
    private int width;
    private int height;
    private Cell[][] field;

    // 应该具备准备数据的通道/功能
    // 创建一个给定大小的Field网格
    public Field(int width, int height){
        this.width=width;
        this.height=height;
        this.field=new Cell[height][width];
    }

    // 把Cell放进给定的坐标(row,col)
    public void putCell(int row,int col,Cell cell){
        this.field[row][col]=cell;
    }

    // 从坐标(row,col)取出Cell
    public Cell getCell(int row,int col){
        return this.field[row][col];
    }

    //  清空网格内所有Cell
    public void clear(){
        for (int row=0;row<height;row++){
            for (int col=0;col<width;col++){
                field[row][col]=null;
            }
        }
    }

    // 通过坐标数值，获得一个Cell周围的"所有邻居"的列表
    public Cell[] getNeighbors(int row,int col){
        ArrayList<Cell> list = new ArrayList<>();
        //遍历以(x,y)为中心的9*9
        for (int i=-1;i<=1;i++){
            for (int j=-1;j<=1;j++){
                //
                int r = row+i;
                int c = col+j;
                if (r>-1 && r<height && c>-1 && c<width && !(r==row && c==col)){
                    list.add(this.getCell(r,c));
                }
            }
        }
        return list.toArray(new Cell[list.size()]);
    }

   // getter width height

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
