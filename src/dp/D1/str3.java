package dp.D1;

import java.util.Arrays;

public class str3 {
    public static void main(String[] args) {
        System.out.println(longestCommonSubstr("ABCDGH","ACDGHR"));
    }
    public  static int longestCommonSubstr(String str1, String str2) {
        int n=str1.length();
        int m=str2.length();
        int ans=Integer.MIN_VALUE;
        int [][] dp=new int [n+1][m+1];
        for (int i = 1; i <=n ; i++) {
            for (int j = 1; j <=m ; j++) {
                if(str1.charAt(i-1)==str2.charAt(j-1))
                {
                    dp[i][j]=1 + dp[i-1][j-1];
                    ans=Math.max(ans,dp[i][j]);
                }else
                {
                    dp[i][j]=0;
                }
            }
        }
        return ans;
    }

}
