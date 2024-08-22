package dp.D1;

import java.util.Arrays;

public class sub9 {
    public static void main(String[] args) {
        int [] arr={1,2,5};
        System.out.println(change(5,arr));
    }
    public static int changes(int amount, int[] coins) {
        int [][] dp=new int[coins.length][amount+1];
        for(int []a :dp)
        {
            Arrays.fill(a,-1);
        }
        return helper(coins,coins.length-1,amount,dp);

    }
    public static  int helper(int [] arr,int index,int target,int [][] dp)
    {

        if(index==0)
        {
            if(target % arr[0]==0)
            {
                return 1;
            }
            else {
                return 0;
            }
        }
        if(dp[index][target]!=-1) return dp[index][target];
        int notTake=helper(arr,index-1,target,dp);
        int take=0;
        if(target>=arr[index])
        {
            take=helper(arr,index,target-arr[index],dp);
        }
        return dp[index][target]= take + notTake;
    }
    public static int  change(int amount, int[] coins) {
        int n=coins.length;
        int [][] dp=new int[n][amount+1];
        for (int i = 0; i <=amount; i++) {
            if(i % coins[0]==0)
            {
                dp[0][i]=1;
            }
        }
        for (int index = 1; index < n; index++) {
            for (int target = 0; target <=amount ; target++) {
                int notTake=dp[index-1][target];
                int take=0;
                if(target>=coins[index])
                {
                    take=dp[index][target-coins[index]];
                }
                dp[index][target]=take+notTake;
            }
        }
        return dp[n-1][amount];
    }
}
