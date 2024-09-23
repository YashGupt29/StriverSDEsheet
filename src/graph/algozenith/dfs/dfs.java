package graph.algozenith.dfs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class dfs {
    public static void main(String[] args) {
        solve();
    }
    static List<List<Integer>> graph;
    static int[] vis;
    public static void solve()
    {
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        graph=new ArrayList<>();
        vis=new int[n+1];
        for (int i = 0; i <=n ; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i <m ; i++) {
            int a=sc.nextInt();
            int b=sc.nextInt();
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        int comp=0;
        for (int i = 1; i <=n ; i++) {
            if(vis[i]==0)
            {
                comp++;
                dfs(i,comp);
            }
            
        }
        System.out.println("Number of components: " + comp);
    }
    public static void dfs(int node,int comp)
    {
        vis[node]=comp;
        for(int v: graph.get(node))
        {
            if(vis[v]==0)
            {
                dfs(v,comp);
            }
        }
    }

}
