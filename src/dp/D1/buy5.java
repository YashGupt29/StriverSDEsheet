package dp.D1;

public class buy5 {
    public static void main(String[] args) {
        int [] arr={1,2,3,0,2};
        System.out.println(maxProfit(arr));
    }
    public static int maxProfit(int[] prices)
    {
        int n=prices.length;
        int [][] dp=new int[n+2][2];
        for (int index = n-1; index >=0 ; index--) {
            for (int buy = 0; buy <2 ; buy++) {
                if(buy==0)
                {
                    dp[index][buy]=Math.max(dp[index+1][0],-prices[index] +dp[index+1][1]);
                }
                else  {

                    int notSold=dp[index+1][1];
                    int sold=prices[index]+dp[index+2][0];
                    dp[index][buy]=Math.max(notSold,sold);
                }
            }
        }
        return dp[0][0];
    }
}
