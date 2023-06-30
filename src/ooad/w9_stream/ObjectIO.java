package ooad.w9_stream;

import java.io.*;

// 实现通过ObjectOutputStream ObjectInputStream的 对整个Object通过Stream进行IO
public class ObjectIO {
    // IO Test
    public static void main(String[] args) {
        // Output
        Student s1 = new Student(1, "LiMing");
        System.out.println("Standard Output: "+s1);

        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("a.dat"));
            out.writeObject(s1);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Input
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("a.dat"));
            Student s2 = (Student) in.readObject(); // Student-Object 因为现在直到读入的一定是Student对象
            System.out.println("ReadObject from FileInputStream："+s2);
            in.close();
            // 内容一样 但不是同一个对象
            System.out.println(s1==s2);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

// Student 一个可串行化的类
class Student implements Serializable{
    private int id;
    private String name;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student：{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

