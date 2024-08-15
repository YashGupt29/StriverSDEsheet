package dp.D1;

import java.util.Arrays;

public class e2 {
    public static void main(String[] args) {

        int [] arr={10,20,30,10};
        System.out.println(minimumEnergy(arr,4));
    }
    public static int minimumEnergy(int []arr ,int n){
      int [] memo=new int[n+1];
        Arrays.fill(memo,-1);
      return tabulation(arr,n-1);

    }
    public  static int tabulation(int [] arr,int n)
    {
        int [] dp=new int[n+1];
        dp[0]=0;
        for (int i = 1; i <=n; i++) {
          int fs=dp[i-1]+Math.abs(arr[i]-arr[i-1]);
          int ss=Integer.MAX_VALUE;
          if(i>1)
          {
              int lb=dp[i-2];
              int diff=Math.abs(arr[i]-arr[i-2]);
              ss=lb+diff;
          }
          dp[i]=Math.min(fs,ss);
        }
        return dp[n];
    }

    public static  int helper(int [] arr, int n,int [] memo)
    {
        if(n==0) return 0;
        if(memo[n]!=-1) return memo[n];
        int left=helper(arr,n-1,memo)+ Math.abs(arr[n]-arr[n-1]);
        int right=Integer.MAX_VALUE;
        if(n>1)
        {
             right=helper(arr,n-2,memo) + Math.abs(arr[n]-arr[n-2]);
        }

        memo[n]=Math.min(left,right);
        return memo[n];
    }
}
