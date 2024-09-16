package dp.D1;

import java.util.Arrays;

public class buy2 {
    public static void main(String[] args) {
        int [] arr={3,3,5,0,0,3,1,4};
        System.out.println(maxProfit(arr));
    }
    public static int maxProfits(int[] prices) {
        int [][] dp=new int[prices.length][3];
        for(int [] i: dp)
        {
            Arrays.fill(i,-1);
        }
        return helper(0,0,prices,dp);
    }
    public static int helper(int index,int buy,int [] prices,int [][] dp)
    {
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
        if(dp[index][buy]!=-1) return dp[index][buy];
        if(buy==0)
        {
            int bought=-prices[index] + helper(index+1,1,prices,dp);
            int notBought=helper(index+1,0,prices,dp);
            return dp[index][buy]= Math.max(bought,notBought);
        }
        else {
            int sold=prices[index] + helper(index+1,0,prices,dp);
            int notSold=helper(index+1,1,prices,dp);
            return dp[index][buy]=Math.max(sold,notSold);
        }
    }
    public static int maxProfit(int[] prices) {
        int n= prices.length;
        int [][] dp=new int[n+1][2];
        for(int [] i: dp)
        {
            Arrays.fill(i,-1);
        }
        dp[n][0]=0;
        dp[n][1]=0;
        for (int index = n-1; index >=0 ; index--) {
            for (int buy = 0; buy <=1 ; buy++) {
                if(buy==0)
                {
                    int bought=-prices[index] + dp[index+1][1];
                    int notBought=dp[index+1][0];
                    dp[index][buy]=Math.max(bought,notBought);
                }
                else {
                    int sold=prices[index] + dp[index+1][0];
                    int notSold=dp[index+1][1];
                    dp[index][buy]=Math.max(sold,notSold);
                }
            }
        }
        return dp[0][0];
    }
}
