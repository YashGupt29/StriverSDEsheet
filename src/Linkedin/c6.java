package Linkedin;

import java.util.Arrays;

public class c6 {
    public static void main(String[] args) {
    String str="123";
        System.out.println(numDecodings(str));
    }
    public static int numDecodings(String s) {
        int n=s.length();
        if(n==0) return 0;
        int [] dp=new int [n+1];
        dp[0]=1;
        dp[1]=s.charAt(0)=='0'?0:1;
        for(int i=2;i<=s.length();i++)
        {
            if(s.charAt(i-1)!='0')
            {
                dp[i]=dp[i] + dp[i-1];
            }
            int twoDigit = Integer.parseInt(s.substring(i - 2, i));
            if(twoDigit >=10 && twoDigit<=26)
            {
                dp[i]=dp[i] + dp[i-2];
            }
        }
        return dp[n];
    }
    static final int MOD = 1000000007;
    public static int CountWays(String str)
    {
        int n=str.length();
       int [] memo=new int[n];
        Arrays.fill(memo,-1);
        return helper(0,str,memo);

    }
    public static int helper(int index,String s,int [] memo)
    {
        if(index==s.length())
        {
            return 1;
        }
        if(s.charAt(index)==0)
        {
            return 0;
        }
        if(memo[index]!=-1) return memo[index];
        if(s.charAt(index)=='1' || (s.charAt(index)=='2' && s.charAt(index+1)>=48 && s.charAt(index+1)<=54))
        {
            return memo[index]=(helper(index+1,s,memo) + helper(index+2,s,memo)) % MOD;
        }
        return memo[index]=(helper(index+1,s,memo)) % MOD;

    }
}
