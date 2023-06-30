package ooad.w8_exception;

import javax.management.openmbean.OpenDataException;
import java.util.Scanner;

public class ExceptionExample {

    // try catch block
    public static void tryCatch(){
        int[] a = new int[10];

        int idx;
        Scanner scan = new Scanner(System.in);
        idx = scan.nextInt();

        try {
            // 可能出现异常的语句 这里：数组访问越界
            a[idx] = 10;
            System.out.println("a[ "+idx+" ] = "+a[idx]);
        } catch (ArrayIndexOutOfBoundsException e) {
            // 如果捕捉到异常的处理语句，具体的异常处理逻辑取决于业务需要
            System.out.println("Exception Caught:"); // 捕捉到的异常：
            System.out.println(e.getMessage());      // 12
            System.out.println(e);                   // java.lang.ArrayIndexOutOfBoundsException: 12
            e.printStackTrace();                     // java.lang.ArrayIndexOutOfBoundsException: 12 at ooad_ZheJiangUniversity.w8_exception.CatchException.main(CatchException.java:17)
            // ...
            // 如果在这个层面上需要处理，但不能做最终的决定： 再度抛出，就需要再有一个try catch来捕捉这个异常了！
            System.err.println("An exception was thrown"); // 红色文字
            throw e;

        } // catch ( Exception2 e ) { }
        // 可以通过多个catch种类，捕捉try中语句的多种可能异常
    }

    // Test
    public static void main(String[] args) {
        // tryCatch();
        try {
            read();
        } catch (OpenDataException e) {
            e.printStackTrace();
        }
    }

    // 以下 throws 声明异常
    public static int open(){
        return -1;
    }

    public static void read() throws OpenDataException,NullPointerException { // 声明我的函数会抛出这个异常，可以声明不会抛出的异常（没关系的），让接收异常的地方提前做好准备
        if (open()==-1){
            throw new OpenDataException();
            // 处理1：添加throws到方法签名；
            //       调用此方法的地方要做好处理异常的准备
            // 处理2：try catch 环绕
            //            try {
            //                throw new OpenDataException();
            //            } catch (OpenDataException e) {
            //                e.printStackTrace();
            //            }
        }
    }

}

