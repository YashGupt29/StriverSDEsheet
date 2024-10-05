package graphStriver.Lec4;

import java.util.*;

public class s1 {
    public static void main(String[] args) {
        int [][] graph={{0,1},{0,3},{3,4},{4,5},{5,6},{1,2},{2,6},{6,7},{7,8},{6,8}};
        System.out.println(Arrays.toString(shortestPath(graph, 9, 10, 0)));
    }
    public static int[] shortestPath(int[][] edges,int n,int m ,int src) {
        List<List<Integer>> graph=new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());

        }
        for(int [] it : edges) {
            graph.get(it[0]).add(it[1]);
            graph.get(it[1]).add(it[0]);
        }
        System.out.println(graph);
        int [] distance=new int[n];
        Arrays.fill(distance,-1);
        Queue<Integer> queue=new LinkedList<>();
        queue.add(src);
        distance[src]=0;
        while(!queue.isEmpty())
        {
            int node =queue.poll();
            for(int v:graph.get(node))
            {
                if(distance[v]==-1)
                {
                    distance[v]=distance[node]+1;
                    queue.add(v);
                }
            }
        }
        return distance;
    }

}
