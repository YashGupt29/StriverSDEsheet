package graphStriver.dfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class dfs7 {
    public static void main(String[] args) {
        int [][] arr={{0,0,0},{0,1,0},{1,1,1}};
        System.out.println(Arrays.deepToString(updateMatrix(arr)));
    }
    static boolean check(int x, int y,int n,int m) {
        return x >= 0 && x < n && y >= 0 && y < m ;
    }
   public static  int [][] updateMatrix(int [][] mat)
   {
       int n= mat.length;
       int m=mat[0].length;
       int [] dx={-1,1,0,0};
       int [] dy={0,0,-1,1};
       Queue<Pair<Integer,Integer>> queue=new LinkedList<>();

       int [][] dist= new int[n][m];
       for (int i = 0; i < n; i++) {
           for (int j = 0; j < m; j++) {
               if (mat[i][j] == 0) {
                   queue.add(new Pair<>(i, j));
               } else {
                   dist[i][j] = Integer.MAX_VALUE;
               }
           }
       }
           while (!queue.isEmpty())
           {
               int size= queue.size();
               Pair<Integer,Integer> curr=queue.poll();
               int x= curr.first;
               int y= curr.second;
               for (int j = 0; j <4 ; j++) {
                   int nx= x + dx[j];
                   int ny=y +  dy[j];
                   if(check(nx,ny,n,m) && dist[nx][ny]> dist[x][y]+1)
                   {
                       dist[nx][ny]=1 + dist[x][y];
                       queue.add(new Pair<>(nx,ny));
                   }
               }
           }

       return dist;
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
