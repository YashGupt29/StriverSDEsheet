package dp.D1;

import java.util.Arrays;

public class str5 {
    public static void main(String[] args) {
        System.out.println(minDistance("babgbag","bag"));
    }
    public static int minDistance(String word1, String word2) {
        int common=lowestcommonsub(word1,word2);
        int deleted=0;
        if(word1.length()>=word2.length())
        {
            deleted=word1.length()-common;
        }
        else {
            deleted=word2.length()-common;
        }
        return common+deleted;

    }
    public static int lowestcommonsub(String s,String t)
    {
        int n=s.length();
        int m=t.length();
        int [][] dp=new int [n+1][m+1];
        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=m;j++)
            {
                if(s.charAt(i-1)==t.charAt(j-1))
                {
                    dp[i][j]=1+ dp[i-1][j-1];
                }
                else {
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        for(int [] i : dp)
        {
            System.out.println(Arrays.toString(i));
        }
        return dp[n][m];
    }
}
