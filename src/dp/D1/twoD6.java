package dp.D1;

public class twoD6 {
    public static void main(String[] args) {
        int [][] arr={{3,1,1},{2,5,1},{1,5,5},{2,1,1}};
        System.out.println(solve(arr.length,arr[0].length,arr));

    }
    public static int solves(int n, int m, int [][] grid) {
        int [][][]dp=new int[n][m][m];
        for (int i = 0; i < n; i++) {
            for (int j1 = 0; j1 < m; j1++) {
                for (int j2 = 0; j2 < m; j2++) {
                    dp[i][j1][j2] = -1;
                }
            }
        }
        return helper(n,m,0,0,m-1,grid,dp);
    }
    public static  int helper(int row,int col,int i,int j1,int j2,int [][] grid,int [][][] dp)
    {
        if(j1<0 || j2<0 || j2>=col || j1>=col)
        {
            return -1000;
        }
        if(i==row-1)
        {
            if(j1==j2)
            {
                return grid[i][j1];
            }
            else {
                return grid[i][j1]+grid[i][j2];
            }
        }
        int max=Integer.MIN_VALUE;
        if(dp[i][j1][j2]!=-1) return dp[i][j1][j2];
        for (int j = -1; j <=1; j++) {
            for (int k = -1; k <=1; k++) {
                if(j1==j2)
                {
                    max=Math.max(grid[i][j1]+helper(row,col,i+1,j1+j,j2+k,grid,dp),max);
                }
                else {
                    max=Math.max(grid[i][j1]+grid[i][j2] +helper(row,col,i+1,j1+j,j2+k,grid,dp),max);
                }
            }
        }
        return dp[i][j1][j2]= max;

    }
    public static int solve(int n, int m, int grid[][]) {
        int [][][] dp=new int [n][m][m];
        for (int j1 = 0; j1 < m; j1++) {
            for (int j2 = 0; j2 <m ; j2++) {
                if(j1==j2)
                {
                    dp[n-1][j1][j2]=grid[n-1][j1];
                }
                else {
                    dp[n-1][j1][j2]=grid[n-1][j1]+grid[n-1][j2];
                }
            }

        }
        for (int i = n-2; i>=0 ; i--) {
            for (int j = 0; j <m ; j++) {
                for (int k = 0; k < m; k++) {
                    int maxi=Integer.MIN_VALUE;
                    for (int d1 = -1; d1 <=1 ; d1++) {
                        for (int d2 = -1; d2 <=1 ; d2++) {
                            int ans;
                            if(j==k)
                            {
                                ans=grid[i][j];
                            }
                            else {
                                ans=grid[i][j]+grid[i][k];
                            }
                            if(j +d1 < 0 || j+d1>=m || k+d2<0 || k +d2>=m)
                            {
                                ans+=-1000;
                            }
                            else {
                              ans+=dp[i+1][j+d1][k+d2];
                            }
                            maxi=Math.max(maxi,ans);
                       }
                    }
                    dp[i][j][k]=maxi;

                }

            }
            
        }
        return dp[0][0][m-1];
    }
}
