package dp.D1;

import java.util.Arrays;

public class lic7 {
    public static void main(String[] args) {
        int [] arr={1,2,4,3,5,4,7,2};
        System.out.println(findNumberOfLIS(arr));
    }
    public static int findNumberOfLIS(int[] nums)
    {
        int max=-1;
        int n=nums.length;
        int [] dp=new int [n];
        int [] count=new int[n];
        Arrays.fill(dp,1);
        Arrays.fill(count,1);
        for (int index = 0; index < n; index++) {
            for(int prev=0;prev<index;prev++)
            {
                if(nums[index]>nums[prev] && 1 + dp[prev] >dp[index])
                {
                    dp[index]=1 + dp[prev];
                    count[index]=count[prev];
                }
                else if(nums[index]>nums[prev]  && 1 + dp[prev]==dp[index])
                {
                    count[index]=count[index] + count[prev];
                }
            }
            max=Math.max(max,dp[index]);
        }
        System.out.println(Arrays.toString(dp));
        System.out.println(Arrays.toString(count));
        int ans=0;
        for (int i = 0; i < n; i++) {
            if(dp[i]==max)
            {
                ans+=count[i];
            }
        }
        return ans;
    }
}
