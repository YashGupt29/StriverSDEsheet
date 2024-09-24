package dp.D1.partition;

import java.util.Arrays;

public class mcm1 {
    public static void main(String[] args) {
        int [] arr={40, 20, 30, 10, 30};
        System.out.println(matrixMultiplication(arr.length,arr));
    }
    public static int matrixMultiplications(int n, int [] arr)
    {
        int [][] dp=new int[n][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
       return helper(arr,1,n-1,dp);
    }
    public static int helper(int [] arr, int i, int j,int [][] dp)
    {
        if(i==j)
        {
            return 0;
        }
        if(dp[i][j]!=-1) return dp[i][j];
        int mini=Integer.MAX_VALUE;

        for (int k = i; k <=j-1 ; k++) {
            int ans=helper(arr,i,k,dp)+helper(arr,k+1,j,dp)+arr[i-1]*arr[k]*arr[j];
            mini=Math.min(mini,ans);
        }
        return dp[i][j]=mini;
    }
   public static int matrixMultiplication(int n, int arr[])
    {
        int [][] dp=new int[n][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        for (int i = 1; i < n; i++) {
            dp[i][i]=0;
        }
        for (int i = n-1; i > 0; i--) {
            for (int j = i+1; j < n; j++) {
                int min = Integer.MAX_VALUE;
                for (int k = i; k <=j-1 ; k++) {
                    int ans=arr[i-1]*arr[k]*arr[j] + dp[i][k]+dp[k+1][j];
                    min=Math.min(min,ans);
                }
                dp[i][j]=min;
            }
        }
        return dp[1][n-1];
    }
}
