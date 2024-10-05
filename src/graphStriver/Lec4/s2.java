package graphStriver.Lec4;

import java.util.*;

public class s2 {
    public static void main(String[] args) {
        int [][] arr={{0,1,2},{0,4,1},{4,5,4},{4,2,2},{1,2,3},{2,3,6},{5,3,1}};
        System.out.println(Arrays.toString(shortestPath(6, 7, arr)));
    }
     static List<Integer> ans;
     static int [] dist;
    public static int[] shortestPath(int n,int m, int[][] edges) {
        List<List<Pair>> adj=new ArrayList<>();
        dist=new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        ans=new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            adj.get(edges[i][0]).add(new Pair(edges[i][1],edges[i][2]));
        }
        PriorityQueue<Pair> queue=new PriorityQueue<>((a,b)-> Integer.compare(a.weight,b.weight));
        queue.add(new Pair(0,0));
        dist[0]=0;
        while (!queue.isEmpty())
        {
            Pair curr=queue.poll();
            int node=curr.node;
            int weight=curr.weight;
            for(Pair v:adj.get(node))
            {
                int neighb=v.node;
                int neighweight=v.weight;
                if(dist[neighb]>dist[node] +neighweight)
                {
                    dist[neighb]=dist[node]+neighweight;
                    queue.add(new Pair(neighb,dist[neighb]));
                }
            }
        }
        for (int i = 0; i < dist.length; i++) {
            if(dist[i]==Integer.MAX_VALUE)
            {
                dist[i]=-1;
            }
        }
        return dist;
    }

    static class Pair{
        int node;
        int weight;
        Pair(int first,int second)
        {
            this.node=first;
            this.weight=second;
        }
    }
}
