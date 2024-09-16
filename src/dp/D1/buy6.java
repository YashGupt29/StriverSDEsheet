package dp.D1;

public class buy6 {
    public static void main(String[] args) {
    int [] arr={1,3,2,8,4,9};
        System.out.println(maxProfit(arr,2));
    }
    public static int maxProfit(int[] prices, int fee) {
        int n=prices.length;
        int [][] dp=new int[n+1][2];
        for (int index= n-1; index >=0 ; index--) {
            for (int buy = 0; buy <=1; buy++) {
                if(buy==0)
                {
                    dp[index][buy]=Math.max(dp[index+1][0],-prices[index]+dp[index+1][1]);
                }else {
                    dp[index][buy]=Math.max(dp[index+1][1],prices[index]+dp[index+1][0] - fee );
                }
            }
        }
        return dp[0][0];
    }
}
