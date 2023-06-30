package ooad.w3_object_container.project;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    /** Test 数据：
     * Hagzou Hugzou Jigxng ###            :citylist
     * 0 1108 708 1108 0 994 708 994 0     :instances[][]
     * Hagzou Jigxng                       :search
     * @return 708
     * */
    public static void main(String[] args) {
        //初始化各参数
        Miles miles = new Miles();
        //Search
        Scanner scanner = new Scanner(System.in);
        int result=miles.search(scanner.next(),scanner.next());
        System.out.println(result);

        scanner.close(); // 实在确定用不到了再关，实在不行不关也行！
    }
}

class Miles{

    ArrayList<String> citylist; // 城市列表
    int[][] instances; // n*n的二维矩阵（根据n的个数动态变化）

    // constructor
    public Miles(){
        initcitylist(); // 构建城市列表
        initInstances(citylist.size()); // 构建instance矩阵[][]
    }

    //构建citylist
    public void initcitylist(){
        // 实例化
        citylist = new ArrayList<>();
        // 构建
        Scanner scan = new Scanner(System.in);
        // 手动EOF解决
        int index=0;
        while(true){
            String c= scan.next();
            if (c.matches("###")) break;
            else{
                citylist.add(index,c);
                index++;
            }
        }
        //scan.close(); 后面还要用scanner就不要close()！
    }

    // 构建instances[][]
    public void initInstances(int n){
        //in
        Scanner scan = new Scanner(System.in);
        // 根据传入参数动态实例化instances[][]二维矩阵
        instances = new int[n][n];
        for (int i=0;i<n;i++){ // 行
            for (int j=0;j<n;j++){ // 列
                instances[i][j]=scan.nextInt();
            }
        }
        //二维矩阵sout
        for (int[] f :instances) {
            System.out.println(Arrays.toString(f));
        }
    }

    // 输入两个城市名字，返回两者之间的距离
    public int search(String c1, String c2){
        return instances[citylist.indexOf(c1)][citylist.indexOf(c2)];
    }

}