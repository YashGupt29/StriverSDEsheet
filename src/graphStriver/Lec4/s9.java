package graphStriver.Lec4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class s9 {
    public static void main(String[] args) {
        int [][] arr={{0,6,7},{0,1,2},{1,2,3},{1,3,3},{6,3,3},{3,5,1},{6,5,1},{2,5,1},{0,4,5},{4,6,2}};
        System.out.println(countPaths(7,arr));
    }
    public static int countPaths(int n, int[][] roads) {
        List<List<Pair>> adj=new ArrayList<>();
        for (int i = 0; i <n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < roads.length; i++) {
            adj.get(roads[i][0]).add(new Pair(roads[i][1],roads[i][2]));
            adj.get(roads[i][1]).add(new Pair(roads[i][0],roads[i][2]));

        }
        long [] dist=new long[n];
        int [] ways=new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        PriorityQueue<Pair> queue=new PriorityQueue<>((a, b)->Long.compare(a.time,b.time));
        queue.add(new Pair(0,0));
        dist[0]=0;
        ways[0]=1;
        int MOD=(int)(1e9 + 7);
        while (!queue.isEmpty())
        {
            Pair curr=queue.poll();
            int node=curr.node;
            long time= (long)(curr.time);
            for(Pair v:adj.get(node))
            {
                int newNode=v.node;
                long newTime=(long)(v.time);
                if(dist[newNode]>time + newTime)
                {
                    dist[newNode]=time+ newTime;
                    queue.add(new Pair(newNode,dist[newNode]));
                    ways[newNode]=ways[node];
                }
                else if(dist[newNode]==time + newTime)
                {
                    ways[newNode] = (ways[node]  % MOD + ways[newNode]  % MOD) % MOD;

                }

            }
        }
        System.out.println(Arrays.toString(ways));
        return ways[n-1] % MOD;
    }
    static class Pair{
        int node;
        long time;
        Pair(int node ,long time)
        {
            this.node=node;
            this.time=time;
        }
    }

}
