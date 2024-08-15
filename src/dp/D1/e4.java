package dp.D1;

import java.util.Arrays;

public class e4 {
    public static void main(String[] args) {
        int [] arr={1,2,3,1};
        System.out.println(rob(arr));

    }
    public static int rob(int[] nums) {
        int [] max=new int[1];
        max[0]=Integer.MIN_VALUE;
        int [] dp=new int[nums.length];
        Arrays.fill(dp, -1);
        return tabulationDp(nums,dp);
    }
    public static  int helper(int [] nums ,int index,int [] dp)
    {
        if(index==0)
        {
            return nums[index];
        }
        if(index<0) return 0;
        if(dp[index]!=-1) return dp[index];
        int currentHouse=nums[index]+helper(nums,index-2,dp);
        int skipHouse=helper(nums,index-1,dp);
        dp[index]=Math.max(currentHouse,skipHouse);
        return dp[index];
    }
    public static  int tabulationDp(int [] nums,int []dp)
    {
        dp[0]=nums[0];
        for (int i = 1; i < nums.length; i++) {
            int pick=nums[i];
            if(i>1)
            {
                pick+=dp[i-2];
            }
            int notpick=dp[i-1];
            dp[i]=Math.max(pick,notpick);
        }
        return dp[nums.length-1];
    }
    public  static  int tabOptimization(int [] nums)
    {

        int prev=nums[0];
        int prev2=0;
        for (int i = 1; i < nums.length; i++) {
            int pick=nums[i];
            if(i>1)
            {
                pick+=prev2;
            }
            int notpick=prev;
           int curr=Math.max(pick,notpick);
           prev2=prev;
           prev=curr;
        }
        return prev;

    }
}
