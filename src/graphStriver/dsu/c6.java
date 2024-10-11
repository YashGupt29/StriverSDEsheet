package graphStriver.dsu;

import java.util.Arrays;
import java.util.PriorityQueue;

public class c6 {
    public static void main(String[] args) {
    int [][] arr={{3,2},{0,1}};
        System.out.println(swimInWater(arr));
    }
    public static boolean check(int x, int y, int n, int m) {
        return x >= 0 && y >= 0 && x < n && y < m;
    }
    public static int swimInWater(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        PriorityQueue<Tuple> queue=new PriorityQueue<>((a,b)->Integer.compare(a.t,b.t));
        queue.add(new Tuple(0,0,grid[0][0]));
        int [][] dist=new int[n][m];
        for(int [] v:dist)
        {
            Arrays.fill(v,-1);
        }
        dist[0][0]=grid[0][0];
        int [] dx={1,-1,0,0};
        int [] dy={0,0,-1,1};

        while(!queue.isEmpty())
        {
            Tuple curr=queue.poll();
            int x= curr.x;
            int y= curr.y;
            int t= curr.t;
            if(x==n-1 && y==m-1)
            {
                return t;
            }
            for (int i = 0; i < 4; i++) {
                int nx=x+ dx[i];
                int ny=y+ dy[i];
                if(check(nx,ny,n,m) && dist[nx][ny]==-1)
                {
                    dist[nx][ny]=Math.max(grid[nx][ny],t);
                    queue.add(new Tuple(nx,ny,dist[nx][ny]));
                }

            }
        }
        return 0;
    }
    static class Tuple{
        int x;
        int y;
        int t;
        Tuple(int x,int y,int t)
        {
         this.x=x;
         this.y=y;
         this.t=t;
        }
    }
}
