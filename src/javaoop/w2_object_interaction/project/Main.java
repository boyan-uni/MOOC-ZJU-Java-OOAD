package javaoop.w2_object_interaction.project;

// 有秒计时的数字时钟
public class Main {
    public static void main(String[] args) {
        java.util.Scanner in = new java.util.Scanner(System.in);
        Clock clock = new Clock(in.nextInt(), in.nextInt(), in.nextInt());
        clock.tick();
        System.out.println(clock);
        in.close();
    }
}

// clock用来操控display对象之间的关系
class Clock {
    Display hour;
    Display minute;
    Display second;

    // constructor
    public Clock(int hour,int minute, int second){ // 初始化时间
        this.hour = new Display(hour,24);
        this.minute = new Display(minute,60);
        this.second = new Display(second,60);
    }

    public void tick() { // 走秒数 手动停走
        while(true){
            second.increase();
            if (second.getValue()==0){ // 初始到这里必然是1，再新循环一定满60一次
                minute.increase();
                if (minute.getValue()==0){ // 嵌套 if Check 23：59：59 临界点
                    hour.increase();
                }
            }
            System.out.println(this);
        }
    }

    @Override
    public String toString() {
        return String.format("%02d:%02d:%02d",hour.getValue(),minute.getValue(),second.getValue());
    }
}

// 每个小格
class Display {
    private int value;
    private int limit;

    // constructor
    public Display(int value, int limit){ // 时分秒limit不同
        this.value=value;
        this.limit=limit;
    }

    public void increase() {
        this.value++;
        if (this.value==this.limit){
            this.value=0;
        }
    }

    // getter
    public int getValue() {
        return this.value;
    }
}