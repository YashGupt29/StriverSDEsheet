package dpAtcoderr;

import java.util.Arrays;
import java.util.Scanner;

public class q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(solve(n, arr));
    }

    public static int solve(int n,int [] arr)
    {
        int [] dp=new int[n];
        for (int index = 1; index < n; index++) {
            int right=Integer.MAX_VALUE;
            int left=Math.abs(arr[index-1]-arr[index]) + dp[index-1];
            if(index>1)
            {
                right=Math.abs(arr[index-2]-arr[index]) + dp[index-2];
            }
            dp[index]=Math.min(left,right);
        }
        System.out.println(Arrays.toString(dp));
        return dp[n-1];

    }
    public static int helper(int [] arr,int index,int n,int [] dp)
    {
        if(index==n-1)
        {
            return 0;
        }
        if(dp[index]!=-1)
        {
            return dp[index];
        }
       int left=Integer.MAX_VALUE;
        if(index< n-1)
        {
            left=Math.abs(arr[index+1]-arr[index])  + helper(arr,index+1,n,dp);
        }
        int right=Integer.MAX_VALUE;
        if(index<n-2)
        {
             right=Math.abs(arr[index+2]-arr[index]) + helper(arr,index+2,n,dp);
        }

       return dp[index]= Math.min(left,right);
    }

}
