package graphStriver.Lec4;

import java.util.*;

public class s7 {
    public static void main(String[] args) {
        int [][] arr={{0,1,5},{1,2,5},{0,3,2},{3,1,2},{1,4,1},{4,2,1}};
        System.out.println(findCheapestPrice(5,arr,0,2,2));
    }

    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<Pair>> adj=new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < flights.length; i++) {
            adj.get(flights[i][0]).add(new Pair(flights[i][1],flights[i][2]));
        }
        int [] dist=new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        Queue<Tuple> queue = new LinkedList<>();
        queue.add(new Tuple(src,0,0));
        dist[src]=0;
        while (!queue.isEmpty())
        {
            Tuple curr=queue.poll();
            int node=curr.node;
            int cost=curr.cost;
            int stops=curr.stops;
            if(stops > k) continue;
            for(Pair v:adj.get(node))
            {
                int newCost= v.weight;
                int newNode=v.node;
                if(dist[newNode]>cost + newCost && stops<=k)
                {
                    dist[newNode]=cost+newCost;
                    queue.add(new Tuple(newNode,cost + newCost,stops+1));
                }
            }
        }
        System.out.println(Arrays.toString(dist));
        return dist[dst];
    }
    static class Pair{
        int node;
        int weight;
        Pair(int node,int weight)
        {
            this.node=node;
            this.weight=weight;
        }

    }
    static class  Tuple{
        int node;
        int cost;
        int stops;
        Tuple(int node,int cost,int stops)
        {
            this.node=node;
            this.cost=cost;
            this.stops=stops;
        }
    }


}
