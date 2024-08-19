package dp.D1;

import java.util.Arrays;

public class sub7 {
    public static void main(String[] args) {
    int [] arr={1,2,5};
        System.out.println(coinChange(arr,11));
    }
    public static int coinChanges(int[] coins, int amount) {
        int [][] dp=new int[coins.length][amount+1];
        int ans=helper(coins,amount,coins.length-1,dp);
        return ans==1000000007?-1:ans;
    }
    public  static  int helper(int [] arr ,int target, int index,int [][]dp)
    {
        if(index==0)
        {
            if(target % arr[0]==0)
            {
                return target/arr[0];
            }
            else {
                return (int) (Math.pow(10,9)+7);
            }
        }
        if(dp[index][target]!=0) return dp[index][target];
        int notTake= helper(arr,target,index-1,dp);
        int take=Integer.MAX_VALUE;
        if(target>=arr[index])
        {
            take=1 + helper(arr,target-arr[index],index,dp);
        }

        return  dp[index][target]=Math.min(take,notTake);
    }
    public static int coinChange(int[] arr, int amount) {
        int n=arr.length;
        int [][] dp=new int[n][amount+1];
        for (int i = 0; i <=amount; i++) {
            dp[0][i]=i % arr[0]==0? (i /arr[0]):1000000007;
        }
        for (int index = 1; index < n; index++) {
            for (int target = 0; target <=amount; target++) {
                int notTake=dp[index-1][target];
                int take=Integer.MAX_VALUE;
                if(target>=arr[index])
                {
                    take=1 + dp[index][target-arr[index]];
                }
                dp[index][target]=Math.min(notTake,take);
            }
        }
        return dp[n-1][amount]==1000000007?-1:dp[n-1][amount];
    }
}
