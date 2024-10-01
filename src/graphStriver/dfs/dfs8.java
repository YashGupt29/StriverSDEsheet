package graphStriver.dfs;

import java.util.Arrays;

public class dfs8 {
    public static void main(String[] args) {
        char[][] board = {
                {'X', 'O', 'X', 'O', 'X', 'O'},
                {'O', 'X', 'O', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'O', 'X', 'O'},
                {'O', 'X', 'O', 'X', 'O', 'X'}
        };

        solve(board);
    }
    static int [] dx={-1,1,0,0};
    static int [] dy={0,0,-1,1};
    public static void solve(char[][] board) {
        int n=board.length;
        int m=board[0].length;
        int [][] vis= new int[n][m];
        for (int i = 0; i < m; i++) {
          if(board[0][i]=='O')
              {
                  dfs(board,0,i,vis);
              }
            if(board[n-1][i]=='O')
            {
                dfs(board,n-1,i,vis);
            }

        }
        for (int i = 0; i < n; i++) {
            if(board[i][0]=='O')
            {
                dfs(board,i,0,vis);
            }
            if(board[i][m-1]=='O')
            {
                dfs(board,i,m-1,vis);
            }
        }
        for (int i = 1; i < n-1; i++) {
            for (int j = 1; j < m-1; j++) {
                if(board[i][j]=='O' && vis[i][j]==0)
                {
                    board[i][j]='X';
                }
            }
        }
        System.out.println(Arrays.deepToString(board));
    }
    static boolean check(int x, int y,int n,int m) {
        return x >= 0 && x < n && y >= 0 && y < m ;
    }
    public static void dfs(char [][] board,int x,int y ,int [][] vis)
    {
        vis[x][y]=1;
        for (int i = 0; i < 4; i++) {
            int nx=x +dx[i];
            int ny=y + dy[i];
            if(check(nx,ny, board.length, board[0].length) && board[nx][ny]=='O'&& vis[nx][ny]==0)
            {
                vis[nx][ny]=1;
                dfs(board,nx,ny,vis);
            }
        }
    }
}
