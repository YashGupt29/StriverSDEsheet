package dp.D1;

import java.util.Arrays;

public class sub4 {
    public static void main(String[] args) {
        int [] arr={9 ,7 ,0, 3, 9, 8, 6, 5, 7, 6};
        int n=arr.length;
        int sum=31;
        System.out.println(perfectSum(arr,n,sum));
    }
     static int MOD= (int) (Math.pow(10,9)+7);
    public static int perfectSum(int[] arr, int p, int sum)
    {
        int n=arr.length;
        int [][] dp=new int[n][sum+1];
        for(int [] a: dp)
        {
            Arrays.fill(a,-1);
        }
        return helper(arr,sum,n-1,dp);

    }
    public static  int helper(int [] arr,int target,int index,int [][] dp)
    {
        if(target==0)
        {
           return 1;
        }
        if(index==0)
        {
            return arr[0] == target ? 1 : 0;
        }
        if(dp[index][target]!=-1) return dp[index][target];

        int take=0;
        if(target>=arr[index])
        {
            take=helper(arr,target-arr[index],index-1,dp);
        }
        int notTake=helper(arr,target,index-1,dp);

        return dp[index][target]= (take % MOD + notTake % MOD) % MOD;
    }
}
