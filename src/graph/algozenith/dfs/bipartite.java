package graph.algozenith.dfs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class bipartite {
    public static void main(String[] args) {
        solve();
    }
    static List<List<Integer>> graph;
    static int [] vis;
    static boolean isbipartite;
    public  static void dfs(int node,int color)
    {
        vis[node]=color;
        for(int v:graph.get(node))
        {
            if(vis[v]==0)
            {
                dfs(v,1 ^ 2 ^ color);
            }
            else {
                if(vis[v]==vis[node])
                {
                    isbipartite=false;
                }
            }
        }

    }
    public static void solve()
    {
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        graph=new ArrayList<>();
        vis=new int[n+1];
        isbipartite=true;
        for (int i = 0; i <=n ; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i <m ; i++) {
            int a=sc.nextInt();
            int b=sc.nextInt();
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        for (int i = 1; i <=n ; i++) {
            if(vis[i]==0)
            {
                dfs(i,1);
            }
        }
        System.out.println(isbipartite);

    }
}
