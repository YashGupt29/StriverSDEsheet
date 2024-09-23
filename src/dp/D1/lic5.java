package dp.D1;

import java.util.Arrays;

public class lic5 {
    public static void main(String[] args) {
        String [] arr={"xbc","pcxbcf","xb","cxbc","pcxbc"};
        System.out.println(longestStrChain(arr));
    }
    public static int longestStrChain(String[] words) {
        int n= words.length;
        int [][] dp=new int[n+1][n+1];
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        return helper(words,0,-1,dp);
    }
    public static int helper(String [] words,int index,int prev,int [][] dp)
    {
        if(index== words.length)
        {
            return 0;
        }
        if(prev!=-1 && dp[index][prev]!=0) return dp[index][prev];
        int notTake=helper(words,index+1,prev,dp);
        int take=0;
        if(prev==-1 || isPredecessor(words[prev],words[index]))
        {
            take=1 + helper(words,index+1,index,dp);
        }
        if(prev!=-1)
        {
            dp[index][prev]=Math.max(take,notTake);
        }
        return Math.max(take,notTake);

    }
    public  static boolean  isPredecessor(String s,String t)
    {
        if(s.length() + 1!=t.length())
        {
            return false;
        }
        int i=0;
        int j=0;
        while(i<s.length() && j<t.length())
        {
            if(s.charAt(i)==t.charAt(j))
            {
                i++;
            }
            j++;
        }
        return i==s.length();
    }
}
