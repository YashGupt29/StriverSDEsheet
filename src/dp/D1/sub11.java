package dp.D1;

import java.util.Arrays;

public class sub11 {
    public static void main(String[] args) {
        int [] arr={1, 5, 8, 9, 10, 17, 17, 20};
        System.out.println(cutRod(arr,arr.length));
    }
    public static int cutRod(int[] price, int n) {
        int [][] dp=new int[n][n+1];
        for(int [] a:dp)
        {
            Arrays.fill(a,-1);
        }
        return helper(n-1,n,price,dp);

    }
    public  static int helper(int index,int target,int [] price,int [][] dp)
    {
        if(index==0)
        {
            return price[0] * target;
        }
        if(dp[index][target]!=-1) return dp[index][target];
        int notTake=helper(index-1,target,price,dp);
        int take = Integer.MIN_VALUE;
        int rodLength = index + 1;
        if(target>=rodLength)
        {
            take=price[index] + helper(index,target-rodLength,price,dp);
        }
        return dp[index][target]=Math.max(take,notTake);
    }
}
