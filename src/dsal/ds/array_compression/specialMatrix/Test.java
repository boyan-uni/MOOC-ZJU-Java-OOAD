package dsal.ds.array_compression.specialMatrix;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        Compression compression = new Compression();
        // ✅
        int[][] symmetricMatrix = {{0,8,7},{8,1,1},{7,1,0}};
        System.out.println("对称数组："+ Arrays.deepToString(symmetricMatrix));
        System.out.println("压缩：" + Arrays.toString(compression.transSymmetricMatrixToArray(symmetricMatrix)));
        //


    }
}

class Compression {
    int getArraySerialNumber(int i, int j, String keyword){
        // 1 <= i,j <= n
        int serialNumber =-1;
        switch (keyword){
            case "symmetric":
                if (i>=j){
                    serialNumber = (i*(i-1)/2)+j-1;
                }else{
                    serialNumber = (j*(j-1)/2)+i-1;
                }
                break;
            case "upperTriangular":
                // todo

                break;
            case "lowerTriangular":
                break;
            case "diagonal":
                break;
            default:
                System.out.println("ERROR-输入无效命令，本功能尚未开发");
        }
        return serialNumber;
    }

    public int[] transSymmetricMatrixToArray(int[][] symmetricMatrix){
        int n = symmetricMatrix.length;
        int arraySpace = ((1+n)*n)/2;
        int[] array = new int[arraySpace];
        for (int i=1;i<=n;i++){
            for (int j=1;j<=i;j++){
                int serialNumber = getArraySerialNumber(i,j,"symmetric");
                array[serialNumber] = symmetricMatrix[i-1][j-1]; // 访问切换回数组下标
            }
        }
        return array;
    }

    public int[] transUpperTriangularMatrixToArray(int[][] upperTriangularMatrix){
        int n = upperTriangularMatrix.length;
        int arraySpace = ((1+n)*n)/2;
        int[] array = new int[arraySpace];
        for (int i=1;i<=n;i++){
            for (int j=1;j<=i;j++){
                int serialNumber = getArraySerialNumber(i,j,"upperTriangular");

            }
        }
        return array;
    }

    public int[] transLowerTriangularMatrixToArray(int[][] lowerTriangularMatrix){
        return new int[1];
    }

    public int[] transDiagonalMatrixToArray(int[][] diagonalMatrix){
        return new int[1];
    }
}
