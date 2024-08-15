package dp.D1;

import java.util.Scanner;

public class twoD3 {
    public static void main(String[] args) {
        int [][] grid={{1,3,1},{1,5,1},{4,2,1}};
        System.out.println(minPathSum(grid));
    }
    public static int minPathSum(int[][] grid) {
        int row= grid.length;
        int col=grid[0].length;
        int [][] dp=new int[row][col];
        return helper(grid,row-1,col-1,dp);


    }
    public static  int helper(int [][] grid, int row,int col,int [][] dp)
    {
        if(row==0 && col==0)
        {
            return grid[row][col];
        }
        if (row < 0 || col < 0) {
            return 10000000;
        }
        if(dp[row][col]!=0) return dp[row][col];
        int up=grid[row][col]+helper(grid,row-1,col,dp);
        int left=grid[row][col]+helper(grid,row,col-1,dp);
        return dp[row][col]= Math.min(up,left);
    }

}
