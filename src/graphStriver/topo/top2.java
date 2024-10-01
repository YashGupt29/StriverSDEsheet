package graphStriver.topo;

import java.util.*;

public class top2 {
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
    static int [] indegree;
    public static int[] topoSort(int v, ArrayList<ArrayList<Integer>> adj)
    {
        indegree=new int[v];
        for (int i = 0; i < v; i++) {
            for(int k: adj.get(i))
            {
                indegree[k]++;
            }
        }
        Queue<Integer> queue=new LinkedList<>();
        for (int i = 0; i < v; i++) {
            if(indegree[i]==0)
            {
                queue.add(i);
            }
        }
        List<Integer> ans=new ArrayList<>();
        while(!queue.isEmpty())
        {
            int node=queue.poll();
            ans.add(node);
            for(int k:adj.get(node))
            {
                indegree[k]--;
                if(indegree[k]==0)
                {
                    queue.add(k);
                }
            }
        }
        int [] arr=new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            arr[i]=ans.get(i);
        }
        return arr;
    }
}
