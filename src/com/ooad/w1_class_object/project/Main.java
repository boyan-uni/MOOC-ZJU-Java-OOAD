package com.ooad.w1_class_object.project;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Fraction a = new Fraction(in.nextInt(), in.nextInt());
        Fraction b = new Fraction(in.nextInt(),in.nextInt());
        a.print();
        b.print();
        a.plus(b).print();
        a.multiply(b).plus(new Fraction(5,6)).print();
        a.print();
        b.print();
        in.close();
    }

}

//设计这个类：构造分数
class Fraction{
    private int a; // 分子
    private int b; // 分母

    Fraction(int a,int b){
        this.a=a;
        this.b=b;
    }

    public double toDouble(){ // 将分数转换为double类型数
        return (double)this.a/this.b;
    }

    public Fraction plus(Fraction r){ // 分数相加运算
        int i=this.a*r.b+this.b*r.a;
        int j=this.b*r.b;
        return new Fraction(i/gcd(i,j),j/gcd(i,j));
    }

    public Fraction multiply(Fraction r){
        int i=this.a*r.a;
        int j=this.b*r.b;
        return new Fraction(i/gcd(i,j),j/gcd(i,j));
    }

    // 计算两数的最大公约数 todo:最大公约数算法
    int gcd(int x, int y)
    {	if (y!=0)
        return gcd(y, x%y);
    else
        return x;
    }

    public void print(){
        if (this.a==this.b){
            System.out.println("1");
        }else {
            //化简
            System.out.println(this.a/gcd(this.a,this.b)+"/"+this.b/gcd(this.a,this.b));
        }
    }
}
