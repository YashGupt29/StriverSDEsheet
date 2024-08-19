package dp.D1;

import java.util.Arrays;

public class sub8 {
    public static void main(String[] args) {

    }
    public static int findTargetSumWays(int[] nums, int target) {
        int sum=0;
        for (int i = 0; i < nums.length; i++) {
            sum+=nums[i];
        }
        if(sum-target<0 || ((sum-target) & 1)!=0)
        {
            return 0;
        }
        return perfectSum(nums,(sum-target)/2);

    }
    public static  int perfectSum(int [] arr, int target)
    {
        int n=arr.length;
        int [][] dp=new int[n][target+1];
        for(int [] i:dp )
        {
            Arrays.fill(i,-1);
        }
        return helper(arr,target,dp,n-1);

    }
    public static int helper(int [] arr,int target, int [][] dp,int index)
    {
        if(index==0)
        {
            if(arr[0]==0 && target==0)
            {
                return 2;
            }
            if(arr[0]==target || target==0)
            {
                return 1;
            }
            else {
                return 0;
            }
        }
        if(dp[index][target]!=-1) return dp[index][target];
        int take=0;
        if(target>=arr[index])
        {
            take=helper(arr,target-arr[index],dp,index-1);
        }
        int notTake=helper(arr,target,dp,index-1);
        return  dp[index][target]=take +notTake;
    }

}
