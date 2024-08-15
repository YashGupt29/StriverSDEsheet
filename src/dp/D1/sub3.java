package dp.D1;

public class sub3 {
    public static void main(String[] args) {
        int [] arr={76,8,45,20,74,84,28,1};
        System.out.println(minimumDifference(arr));
    }
    public static int minimumDifference(int[] nums) {
        int totalSum=0;
        int n=nums.length;
        for (int num : nums) {
            totalSum += num;
        }
        boolean [][] dp=new boolean [n][totalSum+1];
        for (int i = 0; i <n ; i++) {
            dp[i][0]=true;
        }
        dp[0][nums[0]]=true;
        for (int index = 1; index < n; index++) {
            for (int target = 1; target <=totalSum ; target++) {
                boolean take=false;
                if(target>=nums[index])
                {
                    take=dp[index-1][target-nums[index]];
                }
                boolean notTake=dp[index-1][target];
                dp[index][target]=take || notTake;
            }

        }
        int min=Integer.MAX_VALUE;
        for (int i = 0; i <=totalSum; i++) {
            if(dp[n - 1][i])
            {
                int num=Math.abs(totalSum- 2 * i);
                min=Math.min(min,num);
            }
        }
        return min;

    }
}
