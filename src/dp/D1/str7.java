package dp.D1;

public class str7 {
    public static void main(String[] args) {
        System.out.println(numDistinct("horse","ros"));
    }
    public static int numDistinct(String s, String t) {
        int n=s.length();
        int m=t.length();
        int [][] dp=new int[n+1][m+1];
        for (int i = 0; i < n; i++) {
            dp[i][0]=1;
        }
        for (int i = 1; i <=n ; i++) {
            for (int j = 1; j <=m ; j++) {
                if(s.charAt(i-1)==t.charAt(j-1))
                {
                    dp[i][j]=dp[i-1][j-1] +dp[i-1][j];
                }else {
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[n][m];
    }
    public static int numDistincts(String s, String t) {
        int [][] dp=new int[s.length()][t.length()];
        return helper(s.length()-1,t.length()-1,s,t,dp);
    }
    public static  int helper(int i,int j,String s,String t,int [][] dp)
    {
        if(j<0)
        {
            return 1;
        }
        if(i<0)
        {
            return 0;
        }
        if(s.charAt(i)==t.charAt(j))
        {
            int leaveBoth=helper(i-1,j-1,s,t,dp);
            int stay=helper(i-1,j,s,t,dp);
            return leaveBoth + stay;
        }
           return helper(i-1,j,s,t,dp);

    }
}
