package graphStriver.topo;

import java.util.*;

public class topo5 {
    public static void main(String[] args) {
        int [][] graph={{1,2},{2,3},{5},{0},{5},{},{}};
        System.out.println(eventualSafeNodes(graph));
    }
    public static List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> ans=new ArrayList<>();
        int v=graph.length;
        List<List<Integer>> revGraph=new ArrayList<>();
        for (int i = 0; i < v; i++) {
            revGraph.add(new ArrayList<>());
        }
        reversedGraph(graph,v,revGraph);
        KahnsAlgo(v,revGraph,ans);
        Collections.sort(ans);
         return ans;
    }
    public static void reversedGraph(int [][] graph,int v,List<List<Integer>> ans)
    {
        for (int i = 0; i < v; i++) {
            for(int k:graph[i])
            {
               ans.get(k).add(i);
            }
        }
    }
    public static void KahnsAlgo(int v,List<List<Integer>> arr,List<Integer> topo)
    {
        int [] indegree= new int[v];
        for (int i = 0; i < arr.size(); i++) {
            for(int j:arr.get(i))
            {
                indegree[j]++;
            }
        }
        Queue<Integer> queue=new LinkedList<>();
        for (int i = 0; i < v; i++) {
            if(indegree[i]==0)
            {
                queue.add(i);
            }
        }
        while (!queue.isEmpty())
        {
            int node=queue.poll();
            topo.add(node);
            for(int k:arr.get(node))
            {
                indegree[k]--;
                if(indegree[k]==0)
                {
                    queue.add(k);
                }
            }
        }
    }
}
