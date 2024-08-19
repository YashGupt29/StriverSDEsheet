package dp.D1;

import java.util.Arrays;

public class sub5 {
    public static void main(String[] args) {
        int [] arr={5 ,2 ,6, 4};
        System.out.println(countPartitions(arr.length,3,arr));
    }
    static int MOD= (int) (Math.pow(10,9)+7);
    public static int countPartitions(int n, int d, int[] arr) {
      int totalSum=0;
        for (int j : arr) {
            totalSum += j;

        }
      if((totalSum - d )<0 || ((totalSum-d) & 1)!=0)
      {
          return 0;
      }
      return perfectSum(arr,arr.length,(totalSum-d)/2);

    }
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
        if(index==0)
        {
            if(target==0 && arr[0]==0)
            {
                return 2;
            }
            if(target==0 || arr[0]==target)
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
            take=helper(arr,target-arr[index],index-1,dp);
        }
        int notTake=helper(arr,target,index-1,dp);

        return dp[index][target]= (take % MOD + notTake % MOD) % MOD;
    }

}
