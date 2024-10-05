package graphStriver.topo;

import java.util.*;

public class topo3 {
    public static void main(String[] args) {
        int v = 4;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(0).add(1);
        adj.get(1).add(2);
        adj.get(2).add(3);
        adj.get(3).add(3);

        System.out.println( isCyclic(v, adj));

    }
    static int [] indegree;
    public static boolean isCyclic(int v, ArrayList<ArrayList<Integer>> adj) {
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
        System.out.println(ans);
        return ans.size() != v;
    }
}
