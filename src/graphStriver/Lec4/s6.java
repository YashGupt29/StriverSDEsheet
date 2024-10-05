package graphStriver.Lec4;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class s6 {
    public static void main(String[] args) {
        int [][] arr={{1,2,2},{3,8,2},{5,3,5}};
        System.out.println(minimumEffortPath(arr));
    }
    public static boolean check(int n,int m,int x,int y)
    {
        return x<n && y<m && x>=0 && y>=0;
    }
    public static int minimumEffortPath(int[][] heights) {
        int n=heights.length;
        int m=heights[0].length;
        int  [][] distArr=new int[n][m];
        for(int [] arr:distArr)
        {
            Arrays.fill(arr,Integer.MAX_VALUE);
        }
        int [] dx={1,0,-1, 0};
        int [] dy={0,1, 0,-1};
        PriorityQueue<Tuple> queue=new PriorityQueue<>((a,b)->Integer.compare(a.dist,b.dist));
        queue.add(new Tuple(0,0,0));
        distArr[0][0]=0;
        while (!queue.isEmpty())
        {
            Tuple curr=queue.poll();
            int x=curr.x;
            int y=curr.y;
            int dist=curr.dist;
            if(x==n-1 && y==m-1) return dist;
            for (int i = 0; i < 4; i++) {
                int nx=x + dx[i];
                int ny=y + dy[i];
                if(check(n,m,nx,ny))
                {
                    int newEffort=Math.max(Math.abs(heights[nx][ny]-heights[x][y]),dist);
                    if( distArr[nx][ny]> newEffort)
                    {
                        distArr[nx][ny]= newEffort;
                        queue.add(new Tuple(newEffort,nx,ny));
                    }
                }

            }
        }
        System.out.println(Arrays.deepToString(distArr));
        return 0;
    }
    static class Tuple{
        int dist;
        int x;
        int y;
        Tuple(int dist,int x,int y)
        {
            this.x=x;
            this.y=y;
            this.dist=dist;
        }
    }

}
