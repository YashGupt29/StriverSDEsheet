package dp.D1;

public class twoD2 {
    public static void main(String[] args) {
        int[][] grid = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        System.out.println(uniquePathsWithObstacles(grid));

    }

    public static int uniquePathsWithObstacles(int[][] grid)
    {
        int row= grid.length;
        int col= grid[0].length;
        int [][] dp=new int[row][col];
        return helper(grid, row-1, col-1, dp);
    }
    public static  int helper(int[][] grid, int row,int col, int [][]dp)
    {
        if(row==0 && col==0)
        {
            return 1;
        }
        if(row<0 || col < 0 || grid[row][col]==1)
        {
            return 0;
        }
        if(dp[row][col]!=0) {
            return dp[row][col];
        }
        int up=helper(grid,row-1,col,dp);
        int left=helper(grid,row,col-1,dp);
        dp[row][col]=left+up;
        return dp[row][col];
    }
    public static int uniquePathsWithObstacle(int[][] obstacleGrid) {
        int row=obstacleGrid.length;
        int col=obstacleGrid[0].length;
        int[][] dp =new int[row][col];
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = 1;
                    continue;
                }
                if(obstacleGrid[i][j]==1)
                {
                    dp[i][j]=0;
                }
                else {
                    int up=0;
                    int left=0;
                    if(i>0 )
                    {
                         up=dp[i-1][j];
                    }
                    if(j>0)
                    {
                         left=dp[i][j-1];
                    }
                    dp[i][j]=up+left;
                }
            }

        }
        return dp[row-1][col-1];
    }
}
