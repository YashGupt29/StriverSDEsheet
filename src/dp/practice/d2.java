package dp.practice;

import java.util.Arrays;

public class d2 {
    public static void main(String[] args) {
        int [] arr={10, 20, 10};
        System.out.println(minimizeCost(1,arr));
    }
    public static int minimizeCost(int k, int arr[]) {
        int n=arr.length;
        int [] dp=new int[n];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0]=0;
        for (int i = 1; i <n; i++) {
            for (int j = 1; j <=k; j++) {
                int ans=Integer.MAX_VALUE;
                if(i>=j)
                {
                    dp[i]=Math.min(dp[i-j] + Math.abs(arr[i]-arr[i-j]),dp[i]);
                }
            }

        }
        return dp[n-1];
    }

}
