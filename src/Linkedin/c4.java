package Linkedin;

public class c4 {
    public static void main(String[] args) {
    char [][] arr={{'1', '0', '1', '1', '1'}};
        System.out.println(numIslands(arr));
    }
    static int [][] vis;
    static int [] dx={1,-1,0,0,1,-1,1,-1};
    static int [] dy={0,0,-1,1,1,-1,-1,1};
    static int n;
   static int m;
    public static int numIslands(char [][] grid) {
        int numberOfIslands=0;
         n= grid.length;
         m=grid[0].length;
         vis=new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(grid[i][j]-'0'==1)
                {
                   if(vis[i][j]==0)
                   {
                       numberOfIslands++;
                       dfs(i,j,grid);
                   }
                }
            }
        }
        return numberOfIslands;
    }
    public static boolean check(int x,int y)
    {
        return x>=0 && y>=0 && x<n &&y<m;
    }
    public static void dfs(int x,int y,char [][] grid)
    {
        vis[x][y]=1;
        for (int i = 0; i < 8; i++) {
            int nx=x + dx[i];
            int ny=y + dy[i];
            if(check(nx,ny) && vis[nx][ny]==0 && grid[nx][ny]=='1')
            {
                dfs(nx,ny,grid);
            }
        }
    }
}
