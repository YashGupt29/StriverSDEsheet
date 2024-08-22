package dp.D1;

public class str4 {
    public static void main(String[] args) {
        System.out.println(longestPalindromeSubseq("leetcode"));
    }
    public static int longestPalindromeSubseq(String s) {
        StringBuilder sb=new StringBuilder(s);
       
        return  lowestcommonsub(s,sb.reverse().toString());
    }
    public static int lowestcommonsub(String s,String t)
    {
        int n=s.length();
        int [][] dp=new int [n+1][n+1];
        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=n;j++)
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
        return dp[n][n];
    }
}
