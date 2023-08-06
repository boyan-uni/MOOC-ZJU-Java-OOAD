package javaoop.w3_object_container.c2_objectarray;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // int[]
        IntArray intArray = new IntArray();
        intArray.intForeach();

        // String[]
        ObjectArrays objectArrays = new ObjectArrays();
        objectArrays.objectFor();
        objectArrays.objectForeach();

        // Random Num Parameter 's implementation
        RandomNumParameter rnparameter = new RandomNumParameter();
        rnparameter.receive("Hello ","World ","!");

    }
}


// 对照组
class IntArray{
    //
    int[] o;
    // constructor
    public IntArray(){
        o = new int[]{1,2,3,4,5}; // 每格：存储数据
        System.out.println("原int[]：" + Arrays.toString(o));
    }
    // for each
    public void intForeach(){
        for (int i:o){
            i++;
            System.out.println("foreach循环内修改过的 int[] dataElem：" + i); // 复制
        }
        // 未改变原数组元素
        System.out.println("for each循环修改过的 原int[]：" + Arrays.toString(o));
    }
}


// Object[] 对象类型数据的数组
class ObjectArrays{
    //
    String[] s;
    // constructor
    public ObjectArrays(){
        s = new String[5]; // 每个格存储地址（Object类型数据的管理者）
    }
    // for
    public void objectFor(){
        for (int i=0;i<s.length;i++){
            s[i]=""+i;
        }
        System.out.println("for循环赋值的 原String[]：" + Arrays.toString(s));
    }
    // for each（直接修改原数组元素）
    public void objectForeach(){
        for (String i:s) {
            i="Hi："+i; // 修改
            System.out.println("foreach循环内修改过的 String[] dataElem：" + i);
        }
        System.out.println("for each循环修改过的 原String[]：" + Arrays.toString(s));
    }
}

// TODO：the Discussion Query - Java
class RandomNumParameter{
    public void receive(String...s){ // ...
        System.out.println(Arrays.toString(s));
        System.out.println(s[0]); // 以String[]形式接收动态数量的参数！
        System.out.println(s[1]);
        System.out.println(s[2]);
    }
}
