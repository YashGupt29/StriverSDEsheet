package dp.D1;

import java.util.Arrays;

public class twoD1 {
    public static void main(String[] args) {
        int [][] arr={{10,50,1},{5,100,11}};
        int row=arr.length;
        int col=arr[0].length;
        int [][] dp= new int [row][col+1];
        for (int i = 0; i < row; i++) {
            Arrays.fill(dp[i], -1);
        }
        System.out.println(findPoints(arr,arr.length-1, arr[0].length,dp));
        System.out.println(findPointsTab(arr));
    }
    public static  int findPoints(int [][] arr, int days, int last, int [][] dp)
    {
        if(days==0)
        {
            int maxi=0;
            for (int i = 0; i < arr[0].length; i++) {
                if(i!=last)
                {
                    maxi=Math.max(maxi,arr[days][i]);
                }
            }
            return maxi;
        }
        int maxi=0;
        if(dp[days][last]!=-1) return dp[days][last];
        for (int i = 0; i < arr[0].length; i++) {
            if(i!=last)
            {
             int points= arr[days][i]  +  findPoints(arr,days-1,i,dp);
                maxi=Math.max(maxi,points);
            }
        }
        dp[days][last]=maxi;
        return maxi;

    }
    public static int findPointsTab(int [][] arr)
    {
        int row= arr.length;
        int col=arr[0].length;
        int [][] dp=new int [row][col+1];
        int maxi=Integer.MIN_VALUE;
        dp[0][0] = Math.max(arr[0][1], arr[0][2]);
        dp[0][1] = Math.max(arr[0][0], arr[0][2]);
        dp[0][2] = Math.max(arr[0][0], arr[0][1]);
        dp[0][3] = Math.max(arr[0][0], Math.max(arr[0][1], arr[0][2]));

        for (int days = 1; days < row; days++) {
            for(int last=0;last<col;last++)
            {
                for (int i = 0; i < arr[0].length; i++) {
                    if(i!=last)
                    {
                        int points= arr[days][i]  + dp[days-1][i] ;
                        dp[days][last]=Math.max(dp[days][last],points);
                    }
                }
            }

        }
        return dp[row-1][col-1];
    }

}
