package binary_tree;

public class p68 {
    public static void main(String[] args) {
        System.out.println(uniquePaths(3,3));
        System.out.println(iterative(3,3));

    }
    public static int uniquePaths(int m, int n) {
        int [][] dp = new int [m+2][n+2];
        return helper(m,n,1,1,dp);

    }
    public static  int helper(int m, int n, int row, int col, int [][] dp) {
        if(row>m || col >n)
        {
            return 0;
        }
        if (row == m && col == n)
        {
            return 1;
        }
        if(dp[row][col]!=0) return dp[row][col];

        int right=helper(m,n,row,col+1,dp);
        int down=helper(m,n,row+1,col,dp);

        dp[row][col]=down+right;

        return dp[row][col];
    }
    public static int iterative(int row,int col)
    {
        int [][] dp=new int [row][col];
       for (int i = 0; i < row ; i++) {
            for (int j = 0; j < col; j++) {
                if(i==0 && j==0)
                {
                    dp[0][0]=1;
                }
                else {
                    int left=0;
                    int up=0;
                   if(i>0)
                   {
                        left=dp[i-1][j];
                   }
                   if(j>0)
                   {
                       up=dp[i][j-1];
                   }
                   dp[i][j]=left+up;
                }
            }
        }
       return dp[row-1][col-1];
    }
}
