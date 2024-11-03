
import java.util.Arrays;
import java.util.Scanner;

public class q1 {
    static int MOD=(int)(1e9) + 7;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int [] dp=new int[n+1];
        dp[0]=1;
        for (int i = 1; i <=n; i++) {
            for (int j = 1; j <=6 ; j++) {
                if(i-j>=0)
                {
                    dp[i]=dp[i]%MOD + dp[i-j] % MOD;
                }
            }
        }
        System.out.println(dp[n] % MOD);
    }

//    public static int helper(int n,int [] dp)
//    {
//
//        if(n==0)
//        {
//            return 1;
//        }
//        if(n<0)
//        {
//            return 0;
//        }
//        if(dp[n]!=-1) return dp[n];
//        int ways=0;
//        for (int i = 1; i <=6 ; i++) {
//            ways=ways %MOD + helper(n-i,dp) %MOD;
//        }
//        return dp[n]= ways % MOD;
//    }
}
