package graphStriver.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class dfs13 {
    public static void main(String[] args) {
    int [][] ans={{1,0},{0,2}};
        System.out.println(Arrays.toString(findOrder(4, ans)));
    }
    static ArrayList<Integer> topo;
    static int [] visCycle;
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        if(prerequisites.length==0)
        {
            int [] a=new int[numCourses];
            for (int i = 0; i < a.length; i++) {
                a[i]=i;
            }
            return a;
        }
        List<List<Integer>> graph=new ArrayList<>();
        for (int i = 0; i <numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        System.out.println(graph);
        int [] ans= new int[numCourses];
        topo=new ArrayList<>();
        visCycle= new int[numCourses];
        for (int i = 0; i < graph.size(); i++) {
            if(visCycle[i]==0 && isCycle(graph,i,-1))
            {
                return new int[]{};
            }
        }
        Collections.reverse(topo);
        for (int i = 0; i < ans.length; i++) {
            ans[i]=topo.get(i);
        }
        return ans;
    }
    public static boolean isCycle(List<List<Integer>> graph, int node,int parent)
    {
        visCycle[node]=1;
        for(int v:graph.get(node))
        {
            if(visCycle[v]==0)
            {
                if(isCycle(graph,v,node))
                {
                    return true;
                }
            }
            else if(visCycle[v]==1)
            {
                return true;
            }
        }
        visCycle[node]=2;
        topo.add(node);
        return false;
    }
}
