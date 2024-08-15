package dp.D1;

import java.util.Arrays;

public class e5 {
    public static void main(String[] args) {
    int [] arr={1};
        System.out.println(rob(arr));
    }
    public static int rob(int[] nums) {
        if(nums.length==1) return 0;

        return Math.max(robHelper(nums,nums.length-1,1),robHelper(nums,nums.length-2,0));
    }
    public static int robHelper(int [] nums,int start,int end)
    {
        int [] dp= new int[nums.length];
        Arrays.fill(dp,-1);
        return helper(nums,start,dp,end);

    }

    public static  int helper(int [] nums,int index,int [] dp,int start)
    {
        if(index==start) return nums[index];
        if(index<start) return 0;
        if(dp[index]!=-1) return dp[index];
        int take=nums[index]+helper(nums,index-2,dp,start);
        int notTake=helper(nums,index-1,dp,start);
        dp[index]=Math.max(take,notTake);
        return dp[index];
    }
}
