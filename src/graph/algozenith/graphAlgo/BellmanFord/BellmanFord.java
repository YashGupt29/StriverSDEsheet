package graph.algozenith.graphAlgo.BellmanFord;

import java.util.ArrayList;
import java.util.Arrays;

public class BellmanFord {
    public static void main(String[] args) {

    }
    public static int[] bellman_ford(int V, ArrayList<ArrayList<Integer>> edges, int S) {
        int [] dist=new int[V];
        Arrays.fill(dist,(int)(1e9));
        for (int i = 0; i < edges.size(); i++) {
            for(ArrayList<Integer> it:edges)
            {
                int u= it.get(0);
                int v=it.get(1);
                int weight=it.get(2);
                if(dist[u]!= 1e8 && dist[u] + weight < dist[v])
                {
                    dist[v]=dist[u] + weight;
                }
            }
        }
        for(ArrayList<Integer> it: edges)
        {
            int u=it.get(0);
            int v=it.get(1);
            int wt=it.get(2);
            if(dist[u]!=1e8 && dist[u] + wt < dist[v])
            {
                int [] temp=new int[1];
                temp[0]=-1;
                return temp;
            }
        }
        return dist;
    }
}