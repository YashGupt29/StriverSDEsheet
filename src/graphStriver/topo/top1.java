package graphStriver.topo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class top1 {
    public static void main(String[] args) {
        // Number of vertices
        int v = 4;

        // Adjacency list representation of the directed graph
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }

        // Adding edges: 1 -> 0, 2 -> 0, 3 -> 0
        adj.get(1).add(0);  // 1 -> 0
        adj.get(2).add(0);  // 2 -> 0
        adj.get(3).add(0);  // 3 -> 0

        // Running topological sort
        int[] result = topoSort(v, adj);

        // Print the topological sort result
        System.out.println("Topological Sort: " + Arrays.toString(result));
    }
      static List<Integer> topo;
     static int [] vis;
    public static int[] topoSort(int v, ArrayList<ArrayList<Integer>> adj)
    {
       topo=new ArrayList<>();
       vis=new int[v];
        for (int i = 0; i < v; i++) {
            if(vis[i]==0)
            {
                helper(adj,i);
            }
        }
        Collections.reverse(topo);
        int [] ans=new int[v];
        for(int i=0;i<topo.size();i++)
        {
         ans[i]=topo.get(i);
        }
        return ans;
    }
    public  static  void helper(ArrayList<ArrayList<Integer>> adj,int node)
    {
        vis[node]=1;
        for(int v:adj.get(node))
        {
            if(vis[v]==0)
            {
                helper(adj,v);
            }
        }
        topo.add(node);
    }
}
