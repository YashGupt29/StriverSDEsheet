package graphStriver.dfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class bfs {
    public static void main(String[] args) {
    solve();
    }
    public static void solve()
    {
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for (int i = 0; i <=n ; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i <m ; i++) {
            int a=sc.nextInt();
            int b=sc.nextInt();
            adj.get(a).add(b);
            adj.get(b).add(a);
        }
        bfsOfGraph(n,adj);
    }

    public static ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        Queue<Integer> queue=new LinkedList<>();
        ArrayList<Integer> ans=new ArrayList<>();
        int [] vis=new int[V];
        queue.add(0);
        vis[0]=1;
        while(!queue.isEmpty())
        {
            int curr=queue.poll();
            ans.add(curr);

            for(int v:adj.get(curr))
            {
                if(vis[v]==0)
                {
                    vis[v]=1;
                    queue.add(v);
                }
            }
        }
        return ans;
    }
}

