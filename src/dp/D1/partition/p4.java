package dp.D1.partition;

import java.util.Arrays;

public class p4 {
    public static void main(String[] args) {
        System.out.println(minCuts("bb"));
    }
    public static int minCut(String s)
    {
        int n=s.length();
        int [] dp=new int[n+1];
        dp[n]=-1;
        for (int i = n-1; i >=0; i--) {
            int min=Integer.MAX_VALUE;
            for (int j = i; j <n; j++) {
                if(isPalindrome(s,i,j))
                {
                    int cost=1 + dp[j+1];
                    min=Math.min(min,cost);
                }
            }
            dp[i]=min;
        }
        return dp[0];
    }

    public static int minCuts(String s) {
        int [] dp=new int[s.length()+1];
        Arrays.fill(dp,-1);
        if(isPalindrome(s,0,s.length()-1)) return 0;
        return helper(s,0,s.length()-1,dp);
    }
    public static boolean isPalindrome(String s,int i,int j)
    {
        while(i<j)
        {
            if(s.charAt(i)!=s.charAt(j))
            {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    public static  int helper(String s,int i,int n,int [] dp)
    {
        if(i==n)
        {
            return 0;
        }
        if(dp[i]!=-1)
        {
            return dp[i];
        }
        int min=Integer.MAX_VALUE;
        for (int j = i; j < n ; j++) {
            if(isPalindrome(s,i,j)){
                min=Math.min(min,1 + helper(s,j+1,n,dp)) ;
            }
        }
        return dp[i]=min;
    }
}
