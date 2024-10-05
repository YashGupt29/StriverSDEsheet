package graphStriver.Lec4;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class s5 {
    public static void main(String[] args) {
        int [][] arr={{0,1,1,0,0,0},{0,1,0,1,1,0},{0,1,1,0,1,0},{0,0,0,1,1,0},{1,1,1,1,1,0},{1,1,1,1,1,0}};
        System.out.println(shortestPathBinaryMatrix(arr));
    }
    public static boolean check(int n,int x,int y)
    {
        return x<n && y<n && x>=0 && y>=0;
    }
    public static int shortestPathBinaryMatrix(int[][] grid) {
        int [] dx={1 ,1 ,0, 1,-1, 0,-1,-1};
        int [] dy={1 ,0 ,1,-1, 0,-1, 1,-1};
        if(grid[0][0]!=0) return -1;
        int n=grid.length;
        int [][] dist=new int[n][n];
        for(int [] v:dist)
        {
            Arrays.fill(v,Integer.MAX_VALUE);
        }
        Queue<Pair> queue=new LinkedList<>();
        queue.add(new Pair(0,0));
        dist[0][0]=0;
        while (!queue.isEmpty())
        {
            Pair curr=queue.poll();
            int x=curr.x;
            int y=curr.y;
            for (int i = 0; i < 8; i++) {
                int nx=x+dx[i];
                int ny=y +dy[i];
                if(check(n,nx,ny) && dist[nx][ny]>dist[x][y] +1 && grid[nx][ny]==0)
                {
                    dist[nx][ny]=dist[x][y]+1;
                    queue.add(new Pair(nx,ny));
                }
            }
        }
        return dist[n-1][n-1]==Integer.MAX_VALUE?-1: dist[n-1][n-1] + 1;
    }
    static class Pair{
        int x;
        int y;
        Pair(int x,int y)
        {
            this.x=x;
            this.y=y;
        }
    }
}
