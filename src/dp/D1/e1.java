package dp.D1;

public class e1 {
    public static void main(String[] args) {
        System.out.println(climbStairs(3));
    }
    public static int climbStairs(int n) {
        int [] arr=new int[n+1];
       return helper(n,arr);
    }
    public static int helper(int n,int [] dp)
    {
        dp[0]=1;
        dp[1]=1;
        for(int i=2;i<=n;i++)
        {
            int left=dp[i-1];
            int right=dp[i-2];
            dp[i]=left+right;
        }
        return dp[n];

    }
    public static  int helperMemo(int n, int [] arr)
    {
        if(n==0 || n==1) return 1;
        if(arr[n]!=0) return arr[n];
        int left=helper(n-1,arr);
        int right=helper(n-2,arr);
        arr[n]=left+right;
        return arr[n];
    }
}
