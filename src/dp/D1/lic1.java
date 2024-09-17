package dp.D1;

import java.util.Arrays;

public class lic1 {
    public static void main(String[] args) {
        int [] arr={4,2,6};
        System.out.println(lengthOfLIS(arr));
    }
    public static int lengthOfLISs(int[] nums) {
        int n=nums.length;
        int [][] dp=new int[n+1][n];
        for(int [] arr: dp)
        {
            Arrays.fill(arr,-1);
        }
        return helper(nums,0,-1,dp);
    }
    public static  int helper(int [] arr,int index,int prev,int [][] dp)
    {
        if(index==arr.length)
        {
            return 0;
        }
        if(prev!=-1 && dp[index][prev]!=-1) return dp[index][prev];
        int notTake=helper(arr,index+1,prev,dp);
        int take=0;
        if(prev==-1 || arr[index]>arr[prev])
        {
            take=1 + helper(arr,index+1,index,dp);
        }
        if(prev!=-1)
        {
            dp[index][prev]=Math.max(take,notTake);
        }
        return Math.max(take,notTake);

    }
    public static int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int [][] dp=new int[n+1][n+1];
        for (int i = n-1; i >=0 ; i--) {
            for (int prev = -1; prev < i ; prev++) {
                int notTake=dp[i+1][prev+1];
                int take=0;
                if (prev == -1 || nums[i] > nums[prev]) {
                    take = 1 + dp[i + 1][i+1];
                }
                dp[i][prev + 1] = Math.max(take, notTake);
            }

        }
    return dp[0][0];
    }
}
