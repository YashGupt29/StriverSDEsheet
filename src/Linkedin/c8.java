package Linkedin;

import java.util.Arrays;

public class c8 {
    public static void main(String[] args) {
        String s="T|T&F^T";
        int n=s.length();
        System.out.println(countWays(n,s));
    }
    static int MOD=1003;
    public static int countWays(int n, String s){
    int [][][] dp=new int[n][n][2];
    for(int [][] v:dp)
    {
        for(int []vv:v)
        {
            Arrays.fill(vv,-1);
        }
    }
    int ans= helper(0,n-1,s,1,dp);
        return ans;
    }
    public static int helper(int i,int j,String s,int isTrue,int [][][] dp)
    {
        if(i>j)
        {
           return 0;
        }
        if(i==j)
        {
            if(isTrue==1)
            {
                return s.charAt(i)=='T'?1:0;
            }
            else {
                return s.charAt(i)=='F'?1:0;
            }
        }
        if(dp[i][j][isTrue]!=-1)
        {
            return dp[i][j][isTrue];
        }
        int ways=0;
        for (int k = i+1; k <=j-1 ; k+=2) {
            int lT=helper(i,k-1,s,1,dp);
            int lF=helper(i,k-1,s,0,dp);
            int rT=helper(k+1,j,s,1,dp);
            int rF=helper(k+1,j,s,0,dp);
            char operator=s.charAt(k);
            if(operator=='&')
            {
                if(isTrue==1)
                {
                    ways=(ways+(lT * rT) % MOD)%MOD;
                }
                else {
                    ways=(ways + (lT * rF)%MOD + (lF * rT)%MOD + (lF * rF)%MOD )%MOD;
                }
            }
            if(operator=='|')
            {
                if(isTrue==1)
                {
                    ways = (ways + (lT * rT) % MOD + (lT * rF) % MOD + (lF * rT) % MOD) % MOD;
                }
                else {
                    ways=(ways +(lF * rF)) % MOD;
                }
            }
            if(operator=='^')
            {
                if(isTrue==1)
                {
                    ways=(ways + (lF * rT)%MOD + (rF * lT) % MOD )% MOD;
                }
                else {
                    ways=(ways+(lF * rF)%MOD + (rT * lT)%MOD) %MOD;
                }
            }
        }
        return dp[i][j][isTrue]= ways;
    }
}
