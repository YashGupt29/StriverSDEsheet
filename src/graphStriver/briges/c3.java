package graphStriver.briges;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class c3 {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < 8; i++) {
            adj.add(new ArrayList<Integer>());
        }

        // Adding the edges to the adjacency list
        adj.get(2).add(0);
        adj.get(0).add(1);
        adj.get(1).add(2);
        adj.get(2).add(3);
        adj.get(3).add(4);
        adj.get(4).add(7);
        adj.get(4).add(5);
        adj.get(5).add(6);
        adj.get(6).add(7);
        adj.get(6).add(4);
        System.out.println(adj);
        System.out.println(kosaraju(adj.size(),adj));
    }
    static int [] vis;
    public static int kosaraju(int v, ArrayList<ArrayList<Integer>> adj)
    {
        Stack<Integer> stack=new Stack<>();
        vis=new int[v];
        ArrayList<ArrayList<Integer>> reversed=new ArrayList<>();
        for (int i = 0; i < v; i++) {
            reversed.add(new ArrayList<>());
        }
        for (int i = 0; i < v; i++) {
            if (vis[i] == 0) {
                dfs(i, stack, adj, v);
            }
        }
        reverseGraph(adj,reversed);
        vis=new int[v];
        int comp=0;
        while (!stack.isEmpty())
        {
            int node=stack.pop();
            if(vis[node]==0)
            {
                comp++;
                dfs2(node,reversed);
            }
        }
        return comp;
    }
    public static void reverseGraph(ArrayList<ArrayList<Integer>> adj,ArrayList<ArrayList<Integer>> reversed)
    {
        for (int i = 0; i < adj.size(); i++) {
            for(int v:adj.get(i))
            {
                reversed.get(v).add(i);
            }
        }
    }
    public static void dfs2(int node,ArrayList<ArrayList<Integer>> adj) {
        vis[node] = 1;
        for (int i : adj.get(node)) {
            if (vis[i] == 0) {
                dfs2(i, adj);
            }
        }
    }
    public static void dfs(int node,Stack<Integer> stack,ArrayList<ArrayList<Integer>> adj,int v)
    {
     vis[node]=1;
     for(int i:adj.get(node))
     {
         if(vis[i]==0)
         {
             dfs(i,stack,adj,v);
         }
     }

         stack.add(node);


    }



}
