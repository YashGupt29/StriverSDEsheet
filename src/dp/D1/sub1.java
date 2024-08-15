package dp.D1;

import java.util.Arrays;

public class sub1 {
    public static void main(String[] args) {
        int [] arr={11 ,4, 4, 12, 5, 2};
        System.out.println(isSubsetSum(arr.length,arr,9));
    }
    public static Boolean isSubsetSums(int n, int arr[], int sum){
        int [][] dp=new int [n][sum+1];
        for (int row[] : dp)
        {
            Arrays.fill(row, -1);
        }


        return helper(arr.length-1,sum,arr,dp);

    }
    public static boolean helper(int index, int target, int[] arr, int [][] dp)
    {
        if(target==0)
        {
            return true;
        }
        if(index==0)
        {
            return arr[index]==target;
        }
        if(dp[index][target]!=-1) return dp[index][target] == 0;
        boolean take=false;
        if(target>=arr[index])
        {
             take=helper(index-1,target-arr[index],arr,dp);
        }
        boolean notTake=helper(index-1,target,arr,dp);
        boolean ans=take || notTake;
        dp[index][target]=ans?0:100;

        return ans;
    }
     public  static Boolean isSubsetSum(int n, int arr[], int target){
        boolean [][] dp=new boolean[n][target+1];
         for (int i = 0; i < n; i++) {
             dp[i][0]=true;
         }
         if(arr[0]<=target)
         {
             dp[0][arr[0]]=true;
         }
         for (int i = 1; i < n; i++) {
             for (int j = 1; j <=target; j++) {
                 boolean notTake=dp[i-1][j];
                 boolean take=false;
                 if(j>=arr[i])
                 {
                     take=dp[i-1][j-arr[i]];
                 }
                 dp[i][j]=take || notTake;

             }

         }
            return dp[n-1][target];
    }
}
