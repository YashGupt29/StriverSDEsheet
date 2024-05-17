package bsOn2DArray;

public class bs2 {
    public static void main(String[] args) {
        int[][] matrix = {
                {1,1}
        };
        int target = 1;
        System.out.println(searchMatrix(matrix,target));

    }
    public static boolean searchMatrix(int[][] matrix, int target)
    {
        int n= matrix[0].length;
        int row=0;
        int col=n-1;
        while(row< matrix.length && col>=0)
        {
            if(matrix[row][col]==target)
            {
                return true;
            }
            if(matrix[row][col]<target)
            {
                row++;
            }
            else
            {
                col--;
            }

        }
        return false;
    }

}
