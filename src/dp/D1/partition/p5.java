package dp.D1.partition;

import java.lang.reflect.Array;
import java.util.Arrays;

public class p5 {
    public static void main(String[] args) {
    int [] arr={1,15,7,9};
        System.out.println(maxSumAfterPartitioning(arr,3));
    }
    public static int maxSumAfterPartitioning(int[] arr, int k) {
        int n=arr.length;
        int [] dp=new int[n+1];
        for (int i = n-1; i >=0; i--) {
            int max=Integer.MIN_VALUE;
            int maxi = Integer.MIN_VALUE;
            int len=0;
            for (int j = i; j < Math.min(i+k,n); j++) {
                len++;
                maxi=Math.max(maxi,arr[j]);
                int cost=dp[j+1];
                max=Math.max(max,len * maxi+cost);
            }
            dp[i]=max;
        }
        return dp[0];
    }
    public static int maxSumAfterPartitionings(int[] arr, int k) {
        int n=arr.length;
        int [] dp=new int[n];
        Arrays.fill(dp,-1);
        return helper(arr,0,k,dp);
    }
    public static int helper(int [] arr, int i,int j,int [] dp)
    {
        if(i>=arr.length)
        {
            return 0;
        }
        if(dp[i]!=-1) return dp[i];
        int max=Integer.MIN_VALUE;
        int maxi = Integer.MIN_VALUE;
        int len=0;
        for (int k = i; k < Math.min(i+j,arr.length); k++) {
            len++;
            maxi=Math.max(maxi,arr[k]);
            int cost=helper(arr,k+1,j,dp);
            max=Math.max(max,len * maxi+cost);
        }
        return dp[i]=max;
    }

}
