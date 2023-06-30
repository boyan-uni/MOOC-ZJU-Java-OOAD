package ooad.w6_abstract_interface_7_iocmvc.project_FoxAndRabbit;

import java.awt.*;

// Field只认Cell 做成接口 只定义draw方法外观（抽象） 具体实现由implements的类自己实现

public interface Cell {
    void draw(Graphics g, int row, int col, int size);
}
