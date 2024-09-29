package graphStriver.dfs;

import java.util.LinkedList;
import java.util.Queue;

public class d3 {
    public static void main(String[] args) {
    int [][]  arr={{2,1,1},{1,1,0},{0,1,1}};
        System.out.println(orangesRotting(arr));
    }
    public  static boolean check(int x,int y,int n,int m,int [][] grid)
    {
        return x >= 0 && x < n && y >= 0 && y < m ;
    }
    public static int orangesRotting(int[][] grid)
    {
        int [] dx={-1,1,0,0};
        int [] dy={0,0,-1,1};
        int v= grid.length;
        int m=grid[0].length;
        int [][] vis=new int[v][m];
        Queue<Pair<Integer,Integer>> queue=new LinkedList<>();
        int oranges=0;
        int count=0;
        for (int i = 0; i < v; i++) {
            for (int j = 0; j < m; j++) {
                if(grid[i][j]==2)
                {
                    queue.add(new Pair<>(i,j));
                }else if (grid[i][j]==1)
                {
                    oranges++;
                }
            }
        }
        if(oranges==0) return 0;
        while(!queue.isEmpty())
        {
            int size= queue.size();
            for (int j = 0; j < size; j++) {
                Pair<Integer,Integer> curr=queue.poll();
                int x= curr.first;
                int y=curr.second;
                for(int i=0;i<4;i++)
                {
                    int nx=x+dx[i];
                    int ny=y+dy[i];
                    if(check(nx,ny,v,m,grid) && vis[nx][ny]==0 && grid[nx][ny]==1)
                    {
                        grid[nx][ny]=2;
                        vis[nx][ny]=1;
                        oranges--;
                        queue.add(new Pair<>(nx,ny));

                    }
                }
            }
            count++;
        }
        return oranges > 0 ? -1 : count > 0 ? count - 1 : count;
    }
   static class Pair<F,S>
   {
       F first;
       S second;
       public  Pair( F first, S second )
       {
           this.first=first;
           this.second=second;
       }
   }
}
