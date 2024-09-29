package graphStriver.dfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class d6 {
    public static void main(String[] args) {
        // Initialize the 2D array
        int[][] array = {
                {1},
                {0, 2, 4},
                {1, 3},
                {2, 4},
                {1, 3}
        };

        // Convert 2D array into ArrayList<ArrayList<Integer>>
        ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();

        // Populate the ArrayList
        for (int[] row : array) {
            ArrayList<Integer> innerList = new ArrayList<>();
            for (int num : row) {
                innerList.add(num);
            }
            arrayList.add(innerList);
        }
        System.out.println(isCycle(5,arrayList));

    }
    public static boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        int [] vis=new int[V];
        for (int i = 0; i < V; i++) {
            if(vis[i]==0 && bfs(adj,vis))
            {
                return true;
            }
        }
        return false;
    }
    public static boolean bfs( ArrayList<ArrayList<Integer>> adj,int [] vis)
    {
        Queue<Pair<Integer,Integer>> queue=new LinkedList<>();

        queue.add(new Pair<>(0,-1));
        while(!queue.isEmpty())
        {
            Pair<Integer, Integer> curr=queue.poll();
            int node=curr.first;
            int parent=curr.second;
            vis[node]=1;
            for(int v:adj.get(node))
            {
                if(vis[v]==0)
                {
                    queue.add(new Pair<>(v,node));
                    vis[v]=1;
                }
                else if(v!=parent) {
                    return true;
                }
            }
        }
        return false;

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

