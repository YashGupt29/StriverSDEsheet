package dp.D1.partition;

import java.util.Arrays;

public class p3 {
    public static void main(String[] args) {
        int [] arr={3,1,5,8};
        System.out.println(maxCoins(arr));

    }
    public static int maxCoins(int[] nums) {
        int n=nums.length;
        int [] arr= new int[n + 2];
        arr[0]=1;
        arr[n+1]=1;
        for (int i = 1; i <=n ; i++) {
            arr[i]=nums[i-1];
        }
        int [][] dp=new int[n+2][n+2];
        for (int i = n; i >=1; i--) {
            for (int j = 0; j <=n; j++) {
                if(i>j) continue;
                int max=Integer.MIN_VALUE;
                for (int k = i; k <=j ; k++) {
                    int cost=arr[i-1] *arr[k] * arr[j+1] + dp[i][k-1] + dp[k+1][j];
                    max=Math.max(max,cost);
                }
                dp[i][j]=max;
            }
        }
    return dp[1][n];
    }
    public static int maxCoinss(int[] nums) {
        int n=nums.length;
        int [] arr= new int[n + 2];
        arr[0]=1;
        arr[n+1]=1;
        for (int i = 1; i <=n ; i++) {
            arr[i]=nums[i-1];
        }
        return helper(arr,1,n);
    }
    public static int helper(int [] nums,int i,int j)
    {
        if(i>j)
        {
            return 0;
        }
        int max=Integer.MIN_VALUE;
        for (int k = i; k <=j; k++) {
            int cost=nums[i-1] * nums[k] * nums[j+1] + helper(nums,i,k-1)+helper(nums,k+1,j);
            max=Math.max(cost,max);
        }
        return max;
    }
}
