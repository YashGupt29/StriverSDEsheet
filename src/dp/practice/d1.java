package dp.practice;

import java.util.Arrays;

public class d1 {
    public static void main(String[] args) {
        int [] arr={10 ,20, 30 ,10};
        System.out.println(minimumEnergy(arr,4));
    }
    public static int minimumEnergy(int arr[],int n){
        int [] dp=new int[n+1];
        dp[0]=0;
        for (int i = 1; i <n; i++) {
            int first=dp[i-1] + Math.abs(arr[i]-arr[i-1]);
            int second=Integer.MAX_VALUE;
            if(i>1)
            {
                second=dp[i-2] + Math.abs(arr[i]-arr[i-2]);
            }
            dp[i]=Math.min(first,second);
        }
        System.out.println(Arrays.toString(dp));
        return dp[n-1];
    }
}
