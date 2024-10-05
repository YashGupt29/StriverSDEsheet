package graphStriver.Lec4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class s8 {
    public static void main(String[] args) {
    int [][] arr={{1,2,1}};
        System.out.println(networkDelayTime(arr,2,2));
    }
    public static int networkDelayTime(int[][] times, int n, int k) {
        List<List<Pair>> adj=new ArrayList<>();
        for (int i = 0; i <=n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < times.length; i++) {
            adj.get(times[i][0]).add(new Pair(times[i][1],times[i][2]));
        }
        int [] dist=new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        PriorityQueue<Pair> queue=new PriorityQueue<>((a,b)->Integer.compare(a.signal,b.signal));
        queue.add(new Pair(k,0));
        dist[0]=0;
        dist[k]=0;
        while (!queue.isEmpty())
        {
         Pair curr=queue.poll();
         int node=curr.node;
         int signal= curr.signal;
         for(Pair v:adj.get(node))
         {
            int newNode=v.node;
            int newSignal=v.signal;
            if(dist[newNode]>dist[node] + newSignal)
            {
                dist[newNode]=dist[node] + newSignal;
                queue.add(new Pair(newNode,dist[newNode]));
            }
         }
        }
        System.out.println(Arrays.toString(dist));
        int max=Integer.MIN_VALUE;
        for (int i = 0; i <=n; i++) {
            max=Math.max(dist[i],max);
        }
        return max==Integer.MAX_VALUE?-1:max;
    }
    static class Pair{
        int node;
        int signal;
        Pair(int node ,int signal)
        {
            this.node=node;
            this.signal=signal;
        }
    }
    static class Tuple{
        int node;
        int signal;
        int time;
        Tuple(int node,int signal,int time)
        {
            this.node=node;
            this.signal=signal;
            this.time=time;
        }
    }
}
