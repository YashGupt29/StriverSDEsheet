package graphStriver.dfs;

import java.util.ArrayList;

public class d5 {
    public static void main(String[] args) {
        // Initialize the 2D array
        int[][] array = {
                {1,2},{3},{3},{}
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
    static int [] vis;
    public static boolean isCycle(int v, ArrayList<ArrayList<Integer>> adj) {
        boolean iscycle=true;
        vis=new int[v];
        for (int i = 0; i < v ;i++) {
            if(vis[i]==0 && !dfs(adj,i,-1)){
                iscycle=false;
                break;
            }
        }
        return iscycle;
    }
    public  static boolean dfs(ArrayList<ArrayList<Integer>> adj,int node,int parent)
    {
        vis[node]=1;
        for(int v:adj.get(node))
        {
            if(vis[v]==0)
            {
                if( dfs(adj,v,node))
                {
                    return true;
                }
            }
            else if(v!=parent)
            {
                return false;
            }
        }
        return true;
    }
}
