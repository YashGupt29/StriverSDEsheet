package Linkedin;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class c9 {
    public static void main(String[] args) {
        int [] arr={4,5};
        int [] target={1,1};
        System.out.println(minStepToReachTarget(arr,target,6));
    }
    public static boolean check(int x,int y,int n)
    {
        return x>=0 && y>=0 && x<n && y<n;
    }
    public static int minStepToReachTarget(int[] KnightPos, int[] TargetPos, int N)
    {
        int [][] vis=new int[N][N];
        int [] dx={2,-2,-2,2,-1,-1,1,1};
        int [] dy={1,1,-1,-1,2,-2,-2,2};
        PriorityQueue<Tuple> queue=new PriorityQueue<>((a,b)->Integer.compare(a.times,b.times));
        queue.add(new Tuple(KnightPos[1]-1,KnightPos[0]-1,0));
        vis[KnightPos[1]-1][KnightPos[0]-1]=1;
        while (!queue.isEmpty())
        {
            Tuple curr=queue.poll();
            int x=curr.x;
            int y=curr.y;
            int times=curr.times;
            if(x==TargetPos[1]-1 && y==TargetPos[0]-1)
            {
                return times;
            }
            for (int i = 0; i < 8 ; i++) {
                int nx=x + dx[i];
                int ny=y + dy[i];
                if(check(nx,ny,N) && vis[nx][ny]==0)
                {
                    vis[nx][ny]=1;
                    queue.add(new Tuple(nx,ny,times+1));
                }
            }
        }
        return -1;
    }
    static class Tuple{
        int x;
        int y;
        int times;
        Tuple(int x,int y,int times)
        {
            this.x=x;
            this.y=y;
            this.times=times;
        }
    }
}
