package dp.D1;

import java.util.Arrays;

public class e3 {
    public static void main(String[] args) {
        int [] arr={10, 30, 40, 50, 20};
        System.out.println(minimizeCost(arr,5,3));

    }
    public static int minimizeCost(int [] arr, int n, int k) {
        int [] dp=new int[n];
        Arrays.fill(dp,-1);
      return helper(arr,n-1,k,Integer.MAX_VALUE,dp);
    }
    public static int helper(int arr[], int n, int k,int min,int [] dp)
    {
        if(n==0) return 0;
        for (int i = 1; i <=k ; i++) {
            if(n-i<0) break;
            if(dp[n]!=-1) return dp[n];
            int val=helper(arr,n-i,k,min,dp)+Math.abs(arr[n]-arr[n-i]);
            min=Math.min(val,min);
        }

        return  dp[n]=min;
    }
}
