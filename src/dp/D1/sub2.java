package dp.D1;

import java.util.Arrays;

public class sub2 {
    public static void main(String[] args) {
        int [] arr={1,2,3,5};
        System.out.println(canPartition(arr));
    }
    public static boolean canPartitions(int[] nums) {
        int target=0;
        for (int num : nums) {
            target += num;
        }
        int [][] dp=new int[nums.length][target];
        for(int [] a:dp)
        {
            Arrays.fill(a,-1);
        }
        if((target & 1) !=0) {
            return false;
        }
        return helper(nums, nums.length-1,target/2,dp);
    }
    public static  boolean helper(int [] nums,int index,int target,int [][] dp)
    {
        if(target==0)
        {
            return true;
        }
        if(index==0)
        {
            return nums[0]==target;
        }
        if(dp[index][target]!=-1) return dp[index][target]==0;
        boolean take=false;
        if(target>=nums[index])
        {
            take=helper(nums,index-1,target-nums[index],dp);
        }
        boolean notTake=helper(nums,index-1,target,dp);
        boolean ans=take || notTake;
        dp[index][target]=ans?0:10000;
        return ans;
    }
    public static boolean canPartition(int[] nums) {
        int target=0;
        for (int num : nums) {
            target += num;
        }
        if((target & 1) !=0) {
            return false;
        }
        int n=nums.length;
        target=target/2;
        boolean [][] dp=new boolean[n][target+1];
        for (int i = 0; i < n; i++) {
            dp[i][0]=true;
        }
        if(target>=nums[0])
        {
            dp[0][nums[0]]=true;
        }
        for (int i = 1; i < n ; i++) {
            for (int j = 1; j <=target; j++) {

                boolean take=false;
                if(j>=nums[i])
                {
                    take=dp[i-1][j-nums[i]];
                }
                boolean notTake=dp[i-1][j];
                boolean ans=take || notTake;
                dp[i][j]=ans;
            }
        }
        return dp[n-1][target];
    }
}
