package graphStriver.dfs;

import java.util.ArrayList;
import java.util.Scanner;

public class dfs1 {
    public static void main(String[] args) {
        solve();
    }
    public static void solve()
    {
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        vis=new int[n+1];
        for (int i = 0; i <=n ; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i <m ; i++) {
            int a=sc.nextInt();
            int b=sc.nextInt();
            adj.get(a).add(b);
            adj.get(b).add(a);
        }
        dfsOfGraph(n,adj);
    }
    static int [] vis;
    public static ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        vis=new int[V+1];
        ArrayList<Integer> ans=new ArrayList<>();
        int comp=0;
        for (int i = 0; i < V; i++) {
            if(vis[i]==0)
            {
                comp++;
                dfs(adj,ans,i,comp);
            }
        }
        System.out.println(ans);
        return ans;
    }
    public static void dfs(ArrayList<ArrayList<Integer>> adj,ArrayList<Integer> ans,int node,int comp)
    {
        vis[node]=comp;
        ans.add(node);
        for(int v:adj.get(node))
        {
            if(vis[v]==0)
            {
                dfs(adj,ans,v,comp);
            }
        }
    }
}
