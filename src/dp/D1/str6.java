package dp.D1;

public class str6 {
    public static void main(String[] args) {
        System.out.println(shortestCommonSupersequence("aaaaaaaa","aaaaaaaa"));
    }
    public static String shortestCommonSupersequence(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        int[][] dp = new int[n + 1][m + 1];
        StringBuilder sb = new StringBuilder();
        lowercommonsubs(str1, str2, dp);
        int i = n;
        int j = m;
        while (i >0 && j >0) {
            if (str1.charAt(i-1) == str2.charAt(j-1)) {
                sb.append(str1.charAt(i-1));
                i--;
                j--;
            } else {
                if (dp[i - 1][j] >= dp[i][j - 1]) {
                    sb.append(str1.charAt(i-1));
                    i--;
                } else {
                    sb.append(str2.charAt(j-1));
                    j--;
                }
            }
        }
        if(i==0 && j>0)
        {
            sb.append(str2.charAt(j-1));
        }

        return sb.toString();
    }
    public static void lowercommonsubs(String s,String t,int [][] dp)
        {
            int n=s.length();
            int m=t.length();

            for(int i=1;i<=n;i++)
            {
                for(int j=1;j<=m;j++)
                {
                    if(s.charAt(i-1)==t.charAt(j-1))
                    {
                        dp[i][j]=1 + dp[i-1][j-1];
                    }
                    else {
                        dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                    }
                }
            }
        }
}
