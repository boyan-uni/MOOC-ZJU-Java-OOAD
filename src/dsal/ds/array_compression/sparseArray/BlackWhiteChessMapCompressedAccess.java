package dsal.ds.array_compression.sparseArray;

import java.io.*;

public class BlackWhiteChessMapCompressedAccess{
    public static void main(String[] args) {
        Transformation mapSave = new Transformation();
        int[][] twoDArray = {{0,1},{1,0}};
        // 2d->Sparse
        int[][] sparseArray = mapSave.transTwoDToSparseArray(twoDArray);
        // Sparse->2d
        mapSave.transSparseToTwoDArray(sparseArray);
        // file IO
        mapSave.fileWriter(sparseArray);
        sparseArray = mapSave.fileReader();
        mapSave.transSparseToTwoDArray(sparseArray);
    }
}

class Transformation {
    public int[][] transTwoDToSparseArray(int[][] twoDArray) {
        // 遍历TwoD 得到全局数据
        int twoDRow = twoDArray.length;
        int twoDCol = twoDArray[0].length;
        int vaildData = 0;
        for (int i = 0; i < twoDRow; i++) {
            for (int j = 0; j < twoDCol; j++) {
                int value = twoDArray[i][j];
                if (value != 0) {
                    vaildData++;
                }
            }
        }
        // 构造稀疏数组
        int[][] sparseArray = new int[vaildData + 1][3];
        sparseArray[0][0] = twoDRow;
        sparseArray[0][1] = twoDCol;
        sparseArray[0][2] = vaildData;
        // 遍历TwoD 把具体数据放入稀疏数组
        int sparseRow = 1;
        for (int i = 0; i < twoDRow; i++) {
            for (int j = 0; j < twoDCol; j++) {
                int value = twoDArray[i][j];
                if (value != 0) {
                    sparseArray[sparseRow][0] = i;
                    sparseArray[sparseRow][1] = j;
                    sparseArray[sparseRow][2] = value;
                    sparseRow++;
                }
            }
        }
        printTwoDArray(sparseArray);
        return sparseArray;
    }

    public int[][] transSparseToTwoDArray(int[][] sparseArray) {
        // 通过sparse数组第一行建立二维数组，把所有数据填充为0（new自动填充0）
        int twoDRow = sparseArray[0][0];
        int twoDCol = sparseArray[0][1];
        int[][] twoDArray = new int[twoDRow][twoDCol];
        // 遍历sparse数组每一行，根据有效数据信息填充进2D的相应位置
        int sparseRowAmount = sparseArray.length;
        for (int sparseRow = 1; sparseRow < sparseRowAmount; sparseRow++) {
            int row = sparseArray[sparseRow][0];
            int col = sparseArray[sparseRow][1];
            int val = sparseArray[sparseRow][2];
            twoDArray[row][col] = val;
        }
        printTwoDArray(twoDArray);
        return twoDArray;
    }

    /* 读写到磁盘上的文件 map.data */
    public void fileWriter(int[][] sparseArray) {
        String fileName = "map.data";
        try (BufferedWriter fileWriter = new BufferedWriter(new FileWriter(fileName))) {
            for (int sparseRow = 0; sparseRow < sparseArray.length; sparseRow++) {
                fileWriter.write(sparseArray[sparseRow][0] + " " + sparseArray[sparseRow][1] + " " + sparseArray[sparseRow][2]);
                fileWriter.newLine();
            }
            System.out.println("稀疏数组已成功保存到本地文件:" + fileName);
        } catch (IOException e) {
            System.out.println("保存文件时出错: " + e.getMessage());
        }
    }
    public int[][] fileReader() {
        String fileName = "map.data";
        int[][] sparseArray = null;
        try {
            // reader1
            BufferedReader fileReader1 = new BufferedReader(new FileReader(fileName));
            int fileLineAmount=0;
            String filelineContent;
            while ((filelineContent= fileReader1.readLine())!=null){
                System.out.println(filelineContent);
                fileLineAmount++;
            }
            System.out.println("文件内总行数："+ fileLineAmount);
            sparseArray = new int[fileLineAmount][3];
            int lineNumber = 0;
            // reader2
            BufferedReader fileReader2 = new BufferedReader(new FileReader(fileName));
            while ((filelineContent=fileReader2.readLine())!=null){
                String[] lineContent = filelineContent.split(" ");
                sparseArray[lineNumber][0]=Integer.parseInt(lineContent[0]);
                sparseArray[lineNumber][1]=Integer.parseInt(lineContent[1]);
                sparseArray[lineNumber][2]=Integer.parseInt(lineContent[2]);
                lineNumber++;
            }
            System.out.println("从文件 " + fileName + " 成功读取稀疏数组");
            printTwoDArray(sparseArray);
        } catch (IOException e) {
            System.out.println("读取文件时出错: " + e.getMessage());
        }
        return sparseArray;
    }

    public void printTwoDArray(int[][] array){
        for (int[] row:array){
            for (int value :row){
                System.out.print(value+" ");
            }
            System.out.println();
        }
    }
}
