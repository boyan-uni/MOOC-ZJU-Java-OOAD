package com.ooad.w6_abstract_interface_7_iocmvc.project_FoxAndRabbit;

// location(row,col) 用于object在field中的定位

public class Location {
    private int row;
    private int col;

    // 构造Location
    public Location(int row, int col) {
        this.row = row;
        this.col = col;
    }

    // getter 获取目标位置
    public int getRow() {
        return row;
    }
    public int getCol() {
        return col;
    }
}
