package dp.sqaurs;

import java.util.Arrays;

public class q1 {
    public static void main(String[] args) {
        int [][] arr={
                {1,0,1},{1,1,0},{1,1,0}
    };
        System.out.println(countSquares(arr));

    }
    public static int countSquares(int[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        int sum=0;
        int [][] dp=new int [n][m];
        for(int i=0;i<m;i++) {
            dp[0][i] = matrix[0][i];
            sum += dp[0][i];
        }
        for (int i = 1; i < n; i++) {
            dp[i][0] = matrix[i][0];
            sum += dp[i][0];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if(matrix[i][j]==0)
                {
                    dp[i][j]=0;
                }
                else {
                    dp[i][j]=Math.min(dp[i-1][j],Math.min(dp[i][j-1],dp[i-1][j-1]))+1;
                    sum+=dp[i][j];
                }
            }
        }

        return sum;
    }

}
