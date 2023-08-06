package javaoop.w6_abstract_interface_7_iocmvc.project_FoxAndRabbit;

public abstract class Animal {
    // 不让对象本身知道自己的定位
    protected int age;              // age 年龄
    protected int ageLimit;         // ageLimit 年龄上限
    protected int breedAgeLimit;    // breedAgeLimit 可生育年龄上限
    protected boolean alive = true; // alive 存活状态

    // 构造函数
    public Animal(int ageLimit, int breedAgeLimit){
        this.ageLimit = ageLimit;
        this.breedAgeLimit = breedAgeLimit;
    }

    // 死亡
    public void die(){
        this.alive = false;
        this.age = 0;
    }

    // 长大一岁
    public void grow(){
        this.age++;
        if (this.age>=this.ageLimit){
            die();
        }
    }

    // getter and setter

    // 查 年龄
    public int getAge(){
        return this.age;
    }

    // 查 是否活着
    public boolean isAlive(){
        return this.alive;
    }

    // 查 能否生育
    public boolean isBreedable(){
        if (this.age<=this.breedAgeLimit){
            return true;
        }
        else return false;
    }

    // 年龄进度条 用于显示颜色
    public double getAgePercent(){
        return (double) this.age/this.ageLimit;
    }

    // 无实际意义 建立访问通道
    public abstract Animal breed();
}
