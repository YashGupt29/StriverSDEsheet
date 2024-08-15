package dp.D1;

import java.util.Arrays;

public class twoD5 {
    public static void main(String[] args) {
        int [][] arr={{2,1,3},{6,5,4},{7,8,9}};
        System.out.println(minFallingPathSum(arr));
    }
    public static int minFallingPathSums(int[][] matrix) {
        int row=matrix.length-1;
        int col=matrix[0].length-1;
        int min=Integer.MAX_VALUE;
        int [][] dp=new int [row+1][col+1];
        for (int i = 0; i < dp.length ; i++) {
            Arrays.fill(dp[i],Integer.MAX_VALUE);
        }

        for (int i = col; i >=0 ; i--) {
            int ans=helper(matrix,row,i,dp);
            min=Math.min(ans,min);
        }
        return min;
        
    }
    public static int helper(int [][] arr,int row,int col,int [][] dp)
    {
        if(col<0 || col>= arr[0].length)
        {
            return 10000;
        }
        if(row==0)
        {
            return arr[row][col];
        }

        if(dp[row][col]!=Integer.MAX_VALUE) {
            return dp[row][col];
        };

           int left=arr[row][col]+helper(arr,row-1,col-1,dp);
           int up=arr[row][col]+helper(arr,row-1,col,dp);
           int right=arr[row][col]+helper(arr,row-1,col+1,dp);
            dp[row][col]=Math.min(left,Math.min(up,right));
        return dp[row][col];
    }
    public static int minFallingPathSum(int[][] matrix) {
        int row= matrix.length;
        int col= matrix[0].length;
        int [][] dp=new int[row][col];
        for (int i = 0; i < col; i++) {
            dp[0][i]=matrix[0][i];
        }
        for (int i = 1; i < row; i++) {
            for (int j = 0; j < col; j++) {
               int up=dp[i-1][j];
               int left=j>0?dp[i-1][j-1]:Integer.MAX_VALUE;
               int right=(j<col-1)?dp[i-1][j+1]:Integer.MAX_VALUE;
               dp[i][j]=matrix[i][j]+Math.min(up,Math.min(left,right));
            }
        }
        int min=Integer.MAX_VALUE;
        for (int i = 0; i < col; i++) {
            min=Math.min(dp[row-1][i],min);

        }
        return min;

    }
}
