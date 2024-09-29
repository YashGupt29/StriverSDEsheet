package graphStriver.dfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class d4 {
    public static void main(String[] args) {
        int [][] arr={{0,0,0},{0,1,0}};
        System.out.println(Arrays.deepToString(floodFill(arr, 1, 1, 2)));
    }
    public  static boolean check(int x,int y,int n,int m,int [][] grid)
    {
        return x >= 0 && x < n && y >= 0 && y < m ;
    }

    public static int[][] floodFill(int[][] image, int sr, int sc, int color)
    {
        bfs(image,sr,sc,color);
        return image;
    }
    public static void bfs(int [][] arr,int sr,int sc,int color)
    {
        int oldColor=arr[sr][sc];
        int [][] vis= new int[arr.length][arr[0].length];
        Queue<Pair<Integer,Integer>> queue=new LinkedList<>();
        int [] dx={-1,1,0,0};
        int [] dy={0,0,-1,1};
        int n=arr.length;
        int m=arr[0].length;
        queue.add(new Pair<>(sr,sc));
        while(!queue.isEmpty())
        {
            int size=queue.size();
            for (int i = 0; i < size; i++) {
                Pair<Integer,Integer> curr=queue.poll();
                int x=curr.first;
                int y= curr.second;;
                arr[x][y]=color;
                for (int k = 0; k < 4; k++) {
                    int nx=x+dx[k];
                    int ny=y+dy[k];
                    if(check(nx,ny,n,m,arr) && arr[nx][ny]==oldColor && vis[nx][ny]==0)
                    {
                        vis[nx][ny]=1;
                        arr[nx][ny]=color;
                        queue.add(new Pair<>(nx,ny));
                    }
                }
            }
        }

    }
    static class Pair<F,S>
    {
        F first;
        S second;
        Pair(F first, S second)
        {
            this.first=first;
            this.second=second;
        }
    }

}
