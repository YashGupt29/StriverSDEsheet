package graphStriver.topo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class topo4 {
    public static void main(String[] args) {

    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph=new ArrayList<>();
        for (int i = 0; i <numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        return KahnsAlgo(numCourses,graph);
    }
    public static boolean KahnsAlgo(int v,List<List<Integer>> arr)
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
        List<Integer> topo=new ArrayList<>();
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
        return topo.size()!=v;
    }
}
