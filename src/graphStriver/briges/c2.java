package graphStriver.briges;

import java.util.*;

public class c2 {
    public static void main(String[] args) {
        List<List<Integer>> arr = new ArrayList<>();
        arr.add(new ArrayList<>(Arrays.asList(1)));
        arr.add(new ArrayList<>(Arrays.asList(0, 4)));
        arr.add(new ArrayList<>(Arrays.asList(4, 3)));
        arr.add(new ArrayList<>(Arrays.asList(4, 2)));
        arr.add(new ArrayList<>(Arrays.asList(1, 2, 3)));

        System.out.println(articulationPoints(arr.size(), arr));
    }
    static int [] tin;
    static int [] low;
    static int [] vis;
    static ArrayList<Integer> ans;
    static int timer;
    public static ArrayList<Integer> articulationPoints(int v, List<List<Integer>> adj)
    {
        tin=new int[v];
        low=new int[v];
        vis=new int[v];
        ans=new ArrayList<>();
        timer=1;
        System.out.println(adj);
        Set<Integer> contain=new HashSet<>();
        dfs(0,-1,adj,contain);
        Collections.sort(ans);
        return ans;

    }
    public static void dfs(int node, int parent, List<List<Integer>> adj, Set<Integer> contain)
    {
        vis[node]=1;
        tin[node]=low[node]=timer++;
        int child=0;
        for(int v:adj.get(node))
        {
            if(vis[v]==0)
            {
                dfs(v,node,adj,contain);
                low[node]=Math.min(low[node],low[v]);
                if(low[v]>=tin[node] && !contain.contains(node) && parent!=-1)
                {
                    ans.add(node);
                }
                child++;

            }
            else{
                low[node]=Math.min(low[node],tin[v]);
            }
        }
        if(child>1 && parent==-1)
        {
            ans.add(node);
        }
    }
}
