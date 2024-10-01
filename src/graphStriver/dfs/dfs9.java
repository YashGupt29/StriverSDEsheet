package graphStriver.dfs;

public class dfs9 {
    public static void main(String[] args) {
        int [][] arr={{0,1,1,0},{0,0,1,0},{0,0,1,0},{0,0,0,0}};
        System.out.println(numEnclaves(arr) );
    }
    static boolean check(int x, int y,int n,int m) {
        return x >= 0 && x < n && y >= 0 && y < m ;
    }
    static int [] dx={-1,1,0,0};
    static int [] dy={0,0,-1,1};
    public static int numEnclaves(int[][] grid) {
        int n= grid.length;
        int m=grid[0].length;
        int [][] vis=new int[n][m];
        for (int i = 0; i < m; i++) {
            if(grid[0][i]==1)
            {
                dfs(grid,0,i,vis);
            }
            if(grid[n-1][i]==1)
            {
                dfs(grid,n-1,i,vis);
            }
        }
        for (int i = 0; i < n; i++) {
            if(grid[i][0]==1)
            {
                dfs(grid,i,0,vis);
            }
            if(grid[i][m-1]==1)
            {
                dfs(grid,i,m-1,vis);
            }
        }
        int ans=0;
        for (int i = 1; i < n-1; i++) {
            for (int j = 1; j < m-1; j++) {
                if(grid[i][j]==1 && vis[i][j]==0)
                {
                   ans+=1;
                }
            }
        }
        return ans;
    }
    public static  void dfs(int [][] grid,int x,int y,int [][] vis)
    {
        vis[x][y]=1;
        for (int i = 0; i < 4; i++) {
            int nx= x + dx[i];
            int ny= y + dy[i];
            if(check(nx,ny, grid.length, grid[0].length) && vis[nx][ny]==0 && grid[nx][ny]==1)
            {
                vis[nx][ny]=1;
                dfs(grid,nx,ny,vis);
            }

        }

    }
}
