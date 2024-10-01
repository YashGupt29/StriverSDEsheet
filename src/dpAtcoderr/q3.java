package dpAtcoderr;

import java.util.Arrays;
import java.util.Scanner;

public class q3 {
    public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
     int n=sc.nextInt();
     int [][] arr=new int[n][3];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {

                arr[i][j]=sc.nextInt();
            }
        }
        System.out.println(solve(n,arr));
    }
    public static  int solve(int n,int [][] arr)
    {
        int [][] dp=new int[n][3];
        dp[0][0]=arr[0][0];
        dp[0][1]=arr[0][1];
        dp[0][2]=arr[0][2];
        for (int day = 1; day < n; day++) {
//            dp[day][0]=arr[day][0] + Math.max(dp[day-1][1],dp[day-1][2]);
//            dp[day][1]=arr[day][1] + Math.max(dp[day-1][0],dp[day-1][2]);
//            dp[day][2]=arr[day][2] + Math.max(dp[day-1][0],dp[day-1][1]);
            for (int k = 0; k < 3; k++) {
                int max=Integer.MIN_VALUE;
                for (int prev = 0; prev < 3; prev++) {
                    if(k!=prev)
                    {
                        max=Math.max(max,dp[day-1][prev]);
                    }
                }
                dp[day][k]=arr[day][k] + max;
            }
        }
        return Math.max(dp[n-1][0],Math.max(dp[n-1][1],dp[n-1][2]));

    }
}
