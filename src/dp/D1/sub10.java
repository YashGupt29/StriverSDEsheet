package dp.D1;

import java.util.Arrays;

public class sub10 {
    public static void main(String[] args) {
       int N = 1, W = 5;
       int [] val = {10};
       int [] wt = {2};
        System.out.println(knapSack(N,W,val,wt));
    }
    public  static int knapSack(int N, int W, int val[], int wt[])
    {
        int [][]dp=new int [N][W+1];
        for(int [] a:dp)
        {
            Arrays.fill(a,-1);
        }
        int ans= helper(N,N-1,W,val,wt,dp);
        return ans==-10000009?0:ans;
    }
    public  static int helper(int n,int index,int target,int [] val,int [] wt,int [][] dp)
    {
        if(index==0)
        {
                int number=target /wt[0];
                return val[0] * number;

        }
        if(dp[index][target]!=-1) return dp[index][target];
        int notTake=helper(n,index-1,target,val,wt,dp);
        int take=-10000009;
        if(target>=wt[index])
        {
            take=val[index] + helper(n,index,target-wt[index],val,wt,dp);
        }
        return dp[index][target]=Math.max(take,notTake);
    }
}
