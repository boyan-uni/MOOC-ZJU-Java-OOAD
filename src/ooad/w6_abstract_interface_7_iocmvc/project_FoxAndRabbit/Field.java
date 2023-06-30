package ooad.w6_abstract_interface_7_iocmvc.project_FoxAndRabbit;

// 数据层 1.应有的内容 2.允许外界使用的功能

import java.util.ArrayList;
import java.util.Random;

public class Field {
    private int width;
    private int height;
    private Cell[][] field; // 各种实现这个接口的类的对象 都可以放进来

    // 构造函数
    public Field(int width, int height){
        this.width = width;
        this.height = height;
        this.field = new Cell[height][width];
    }

    // Get 宽和高
    public int getWidth() {
        return width;
    }
    public int getHeight() {
        return height;
    }

    // 获得某坐标的对象
    public Cell get(int row, int col){
        return this.field[row][col];
    }
    public Cell get(Location loc){
        return this.field[loc.getRow()][loc.getCol()];
    }

    // 把给定位置格子清空
    public void clear(int row, int col){
        this.field[row][col]=null;
    }

    // 往坐标内放对象
    public void place(int row,int col, Cell cell){
        this.field[row][col] = cell;
    }


    // *move

    // get all neighbor locations
    ArrayList<Location> getAdjLocs(int row, int col){
        ArrayList<Location> list = new ArrayList<>();
        for (int i=-1;i<2;i++){
            for (int j=-1;j<2;j++){
                int r = row+i;
                int c = col+j;
                if (r>-1 && r<height && c>-1 && c<width){
                    list.add(new Location(r,c));
                }
            }
        }
        return list;
    }

    // select all free adj locations
    Location[] getFreeAdjLocs(int row, int col) {
        ArrayList<Location> adjLocs = getAdjLocs(row,col);
        ArrayList<Location> list = new ArrayList<>();
        for (Location loc:adjLocs) {
            if (get(loc)==null){
                list.add(loc);
            }
        }
        return list.toArray(new Location[list.size()]);
    }

    // get a random int between 0-(n-1)
    int getRandom(int n){
        return new Random().nextInt(n);
    }

    // select a random location in the given location[]
    Location getARandomFreeAdj(int row, int col){
        Location[] freeAdjLocs = getFreeAdjLocs(row,col);
        if (freeAdjLocs.length>0){
            int random = getRandom(freeAdjLocs.length);
            return freeAdjLocs[random];
        }
        return null;
    }

    // move (row,col)'cell in a random free location
    public void move(int row, int col, Cell cell){
        Location newLoc = getARandomFreeAdj(row, col);
        if (newLoc!=null){
            place(newLoc.getRow(),newLoc.getCol(),cell);
            clear(row, col);
        }
    }

    // *breed
    public void placeARandomAdj(int row, int col, Cell cell){
        Location loc = getARandomFreeAdj(row, col);
        if (loc!=null){
            place(loc.getRow(),loc.getCol(),cell);
        }
    }

    // *eat

    // select all rabbit adj locations
    Location[] getRabbitAdjLocs(int row, int col) {
        ArrayList<Location> adjLocs = getAdjLocs(row,col);
        ArrayList<Location> list = new ArrayList<>();
        for (Location loc:adjLocs) {
            if (get(loc) instanceof Rabbit){
                list.add(loc);
            }
        }
        return list.toArray(new Location[list.size()]);
    }

    // select a random rabbit's location in the given location[]
    Location getARandomRabbitAdj(int row, int col){
        Location[] rabbitAdjLocs = getRabbitAdjLocs(row,col);
        if (rabbitAdjLocs.length>0){
            int random = getRandom(rabbitAdjLocs.length);
            return rabbitAdjLocs[random];
        }
        return null;
    }

    // eater:(row,col)
    public void eatAction(int row, int col){
        Location rloc = getARandomRabbitAdj(row, col);
        if (rloc!=null){
            int rr = rloc.getRow(); // rabbit row
            int rc = rloc.getCol(); // rabbit col
            clear(rr,rc);
            place(rr,rc,get(row, col));
            clear(row,col);
        }
    }
}
