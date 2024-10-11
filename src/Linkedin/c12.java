package Linkedin;

import java.util.Arrays;

public class c12 {
    public static void main(String[] args) {
        System.out.println(numberOfPaths(3,3));
    }
    static long numberOfPaths(int m, int n)
    {
        long [][] dp=new long[m][n];
        for(long [] v:dp)
        {
            Arrays.fill(v,-1);
        }
    return dfs(0,0,m,n,dp);
    }
    public static long dfs(int x,int y,int m,int n,long [][] dp)
    {
        if(x>=m || y>=n)
        {
            return 0;
        }
        if(x==m-1 && y==n-1)
        {
            return 1;
        }
        if(dp[x][y]!=-1) return dp[x][y];
        long right=dfs(x,y+1, m, n,dp);
        long down=dfs(x+1,y,m,n,dp);
        return dp[x][y]= right+down;
    }
}
