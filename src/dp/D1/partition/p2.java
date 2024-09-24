package dp.D1.partition;

import java.util.Arrays;

public class p2 {
    public static void main(String[] args) {
    int [] cuts={1,3,4,5};
        System.out.println(minCost(7,cuts));
    }
    public static int minCosts(int n, int[] cuts) {
        int m=cuts.length;
        int [] a=new int[m+2];
        a[0]=0;
        a[a.length-1]=n;
        int [][] dp=new int[a.length][a.length];
        for(int [] arr:dp)
        {
            Arrays.fill(arr,-1);
        }
        for (int i = 1; i <=m; i++) {
            a[i]=cuts[i-1];

        }
        System.out.println(Arrays.toString(a));
        return helper(a,1,m,dp);
    }
    public static int helper(int [] cuts,int i,int j,int[][] dp)
    {
        if(i>j)
        {
            return 0;
        }
        if(dp[i][j]!=-1) return dp[i][j];
        int min=Integer.MAX_VALUE;
        for (int index = i; index <=j; index++) {
            int cost= cuts[j+1]-cuts[i-1]+helper(cuts,i,index-1,dp)+helper(cuts,index+1,j,dp);
            min=Math.min(cost,min);
        }
        return dp[i][j]= min;
    }
    public static int minCost(int n, int[] cuts) {
        int ma=cuts.length;
        int [] a=new int[ma+2];
        a[a.length-1]=n;
        for (int i = 1; i <=ma; i++) {
            a[i]=cuts[i-1];
        }
        int m=a.length;
        Arrays.sort(a);
        int [][] dp=new int[m][m];
        for (int i = m-2; i>0 ; i--) {
            for (int j = 0; j <=m-2; j++) {
                if(i>j) continue;
                int min=Integer.MAX_VALUE;
                for (int k = i; k <=j ; k++) {
                    int cost=a[j+1]-a[i-1] + dp[i][k-1] + dp[k+1][j];
                    min=Math.min(cost,min);
                }
                dp[i][j]=min;
            }
        }
        System.out.println(Arrays.deepToString(dp));
        return dp[1][m-2];
    }
}
