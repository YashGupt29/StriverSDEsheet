package dp.D1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class twoD4 {
    public static void main(String[] args) {
        List<List<Integer>> arr = new ArrayList<>();
        arr.add(Arrays.asList(2));
        arr.add(Arrays.asList(3, 4));
        arr.add(Arrays.asList(6, 5, 7));
        arr.add(Arrays.asList(4, 1, 8, 3));

        System.out.println(maxiterative(arr));
    }
    public static int minimumTotal(List<List<Integer>> triangle) {
        int m=triangle.size();
        int n=triangle.getLast().size();
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }

        return helper(triangle,0,0,dp,m-1,n-1);
    }
    public static  int helper(List<List<Integer>> triangle,int row,int col,int [][] dp,int m,int n)
    {
        if(row==m )
        {
            return triangle.get(row).get(col);
        }
        if(row>m || col>n)
        {
            return 0;
        }
        if(dp[row][col]!=Integer.MAX_VALUE) return dp[row][col];
        int down=triangle.get(row).get(col)+ helper(triangle,row+1,col,dp,m,n);
        int up=triangle.get(row).get(col)+helper(triangle,row+1,col+1,dp,m,n);
        return dp[row][col]=Math.min(down,up);
    }
    public static  int maxiterative(List<List<Integer>> arr)
    {
        int m=arr.size();
        int n=arr.getLast().size();
        int [][] dp=new int [m][n];
        for (int i = 0; i < n ; i++) {
            dp[m-1][i]=arr.get(m-1).get(i);
            
        }
        for (int i = m-2; i >=0 ; i--) {
            for (int j = 0; j <=i ; j++) {
                dp[i][j]=arr.get(i).get(j) + Math.min(dp[i+1][j],dp[i+1][j+1]);
            }
        }
        return dp[0][0];
    }

}
