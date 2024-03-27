import java.util.Arrays;

public class medium12 {
    public static void main(String[] args) {
        int [][]matrix={{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};

        rotate(matrix);

    }
    public static  void rotate(int[][] matrix) {
        int n=matrix.length;;
        int m=matrix[0].length;
        int [][] transposed=new int[m][n];
        for (int i = 0; i <n; i++) {
            for (int j = 0; j <m ; j++) {
               transposed[i][j]=matrix[j][i];
            }
        }
        for (int i = 0; i <n ; i++) {
            reverse(transposed[i]);


        }


    }
    public static  int [] reverse(int [] arr)
    {
        for (int i = 0; i <arr.length/2 ; i++) {
            int temp=arr[i];
            arr[i]=arr[arr.length-i-1];
            arr[arr.length-i-1]=temp;
        }
        return arr;
    }
}
