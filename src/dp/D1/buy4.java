package dp.D1;

import java.util.Arrays;

public class buy4 {
    public static void main(String[] args) {
        int[] arr={3,2,6,5,0,3};
        System.out.println(maxProfit(2,arr));
    }
    public static int maxProfits(int[] prices,int k) {
        int [][][] dp=new int[prices.length][3][3];
        for(int [][] i: dp)
        {
            for(int [] j:i)
            {
                Arrays.fill(j,-1);
            }

        }
        return helper(0,0,0,prices,dp,k);
    }
    public static int helper(int index,int buy,int count,int [] prices,int [][][] dp,int k)
    {
        if(count>k)
        {
            return 0;
        }
        if(index==prices.length-1)
        {
            if(buy==0)
            {
                return 0;
            }
            if(buy==1)
            {
                return prices[index];
            }
        }
        if(dp[index][buy][count]!=-1) return dp[index][buy][count];
        if(buy==0)
        {
            int bought=-prices[index] + helper(index+1,1,count,prices,dp,k);
            int notBought=helper(index+1,0,count,prices,dp,k);
            return dp[index][buy][count]= Math.max(bought,notBought);
        }
        else {
            int sold=prices[index] + helper(index+1,0,count +1 ,prices,dp,k);
            int notSold=helper(index+1,1,count ,prices,dp,k);
            return dp[index][buy][count]=Math.max(sold,notSold);
        }
    }
    public static int maxProfit(int k, int[] prices) {
        int n=prices.length;
        int [][][] dp=new int[n+1][2][k+1];
        for (int index = n-1; index >=0 ; index--) {
            for (int buy = 0; buy <2 ; buy++) {
                for (int count = 1; count <=k ; count++) {
                    if (buy == 0) {
                        int bought = -prices[index] + dp[index + 1][1][count];
                        int notBought = dp[index + 1][0][count];
                        dp[index][buy][count] = Math.max(bought, notBought);
                    } else {
                        int sold = prices[index] + dp[index + 1][0][count-1];
                        int notSold = dp[index + 1][1][count];
                        dp[index][buy][count] = Math.max(sold, notSold);
                    }
                }
            }
        }
        return dp[0][0][k];

    }
}
