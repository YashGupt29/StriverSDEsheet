package graphStriver.dsu;

import java.util.Arrays;

public class c7 {
    public static void main(String[] args) {
        int [][] arr={{0,2},{1,3}};
        System.out.println(swimInWater(arr));
    }
    public static int swimInWater(int[][] grid) {
         int n=grid.length;
         int [][] pos=new int[n*n][3];
         UnionFind dsu=new UnionFind(n*n + 1);
         int index=0;
          for(int i=0;i<n;i++)
          {
                for (int j = 0; j < n; j++) {
                    pos[index++] = new int[]{i, j, grid[i][j]};
                }
          }
        Arrays.sort(pos,(a,b)->Integer.compare(a[2],b[2]));
          int [] dx={1,-1,0,0};
          int [] dy={0,0,1,-1};
          for(int [] v:pos)
          {
              int x=v[0];
              int y=v[1];
              int t=v[2];
              int nodeNo=x * n + y;
              for (int i = 0; i < 4; i++) {
                int nx=x + dx[i];
                int ny=y + dy[i];
                if(check(nx,ny,n,n) && grid[nx][ny]<=t)
                {
                    int adjnode=nx * n + ny;
                    dsu.merge(nodeNo,adjnode);
                }
              }
              if(dsu.find(0)==dsu.find(n * n -1))
              {
                  return t;
              }
          }
          return -1;
    }
    public static boolean check(int x, int y, int n, int m) {
        return x >= 0 && y >= 0 && x < n && y < m;
    }
}
