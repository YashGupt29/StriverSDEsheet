package dp.D1;

import java.util.Arrays;

public class str8 {
    public static void main(String[] args) {
        System.out.println(minDistance("a","a"));
    }
    public static int minDistance(String word1, String word2) {
        int n=word1.length();
        int m=word2.length();
        int [][] dp=new int[n+1][m+1];
        for (int i = 0; i <=n; i++) {
            dp[i][0]=i;
        }
        for (int i = 0; i <=m ; i++) {
            dp[0][i]=i;
        }
        for (int i = 1; i <=n ; i++) {
            for (int j = 1; j <=m ; j++) {
                if(word1.charAt(i-1)==word2.charAt(j-1))
                {
                    dp[i][j]=dp[i-1][j-1];
                }else {
                    int insert=dp[i][j-1];
                    int delete=dp[i-1][j];
                    int replace=dp[i-1][j-1];
                    dp[i][j]=1 + Math.min(insert,Math.min(delete,replace));
                }
            }
        }
    return dp[n][m];
    }
    public static int minDistances(String s, String t) {
        if(t.length()>s.length())
        {
            return minDistance(t,s);
        }
        if(s.isEmpty() && t.isEmpty())
        {
            return 0;
        }
            int [][] dp=new int[s.length()][t.length()];
        for(int [] a:dp)
        {
            Arrays.fill(a,-1);
        }
        return helper(s.length()-1,t.length()-1,s,t,dp);
    }
    public static  int helper(int i,int j,String s,String t,int [][] dp)
    {
        if(i<0)
        {
            return 0;
        }
        if(j<0)
        {
            return 1;
        }

        if(dp[i][j]!=-1) return dp[i][j];
        if(s.charAt(i)==t.charAt(j))
        {
            return dp[i][j]=helper(i-1,j-1,s,t,dp);
        }
        return dp[i][j]=1 + helper(i-1,j,s,t,dp);
    }
}
