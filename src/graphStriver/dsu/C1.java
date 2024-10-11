package graphStriver.dsu;

//{ Driver Code Starts


import java.io.*;
import java.lang.*;
import java.util.*;

public class C1 {
    static BufferedReader br;
    static PrintWriter ot;

    public static void main(String[] args) {
        int V = 3; // Number of vertices
        int E = 3; // Number of edges

        // Initialize the adjacency list
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Given edges
        int[][] edges = {
                {0, 1, 5}, // Edge from vertex 0 to vertex 1 with weight 5
                {1, 2, 3}, // Edge from vertex 1 to vertex 2 with weight 3
                {0, 2, 1}  // Edge from vertex 0 to vertex 2 with weight 1
        };

        // Populate the adjacency list
        for (int[] edge : edges) {
            int u = edge[0]; // Source vertex
            int v = edge[1]; // Destination vertex
            int weight = edge[2]; // Edge weight

            // Add the edge to both vertices' lists (undirected graph)
            adj.get(u).add(new int[]{v, weight});
            adj.get(v).add(new int[]{u, weight});
        }
        System.out.println(adj);
        // Call the spanningTree method and print the result
        int mstWeight = Solution.spanningTree(V, E, adj);
        System.out.println("Weight of the Minimum Spanning Tree: " + mstWeight);
    }
}
// } Driver Code Ends


// User function Template for Java
class UnionFind{
    int n;
    int setSize;
    int [] par;
    int [] rank;
    UnionFind(int a)
    {
        n=a;
        setSize=n;
        par=new int [n];
        rank=new int[n];
        for(int i=0;i<n;i++)
        {
            par[i]=i;
            rank[i]=1;
        }
    }
    public int size() {
        return setSize;
    }
    public int find(int x)
    {
        if(x!=par[x])
        {
            par[x]=find(par[x]);
        }
        return par[x];
    }
    public void merge(int x,int y)
    {
        int xRoot=find(x);
        int yRoot=find(y);
        if(xRoot!=yRoot)
        {
            if(rank[xRoot]>=rank[yRoot])
            {
                par[yRoot]=xRoot;
                rank[xRoot]+=rank[yRoot];
            }
            else {
                par[xRoot]=yRoot;
                rank[yRoot]+=rank[xRoot];
            }
        }
        setSize--;
    }
}
class Solution {
    static int spanningTree(int V, int E, List<List<int[]>> adj) {
        List<int []> edges=new ArrayList<>();
        for(int i=0;i< V;i++)
        {
            for(int [] edge :adj.get(i))
            {
                int v=edge[0];
                int weight=edge[1];
                edges.add(new int[] {i, v, weight});
            }
        }
        Collections.sort(edges, (a, b) -> a[2] - b[2]);
        UnionFind dsu=new UnionFind(V);
        int mstWeight=0;
        int edgesUsed=0;
        for(int [] edge:edges)
        {
            int u=edge[0];
            int v=edge[1];
            int weight=edge[2];
            if(dsu.find(u)!=dsu.find(v))
            {
                dsu.merge(u,v);
                mstWeight+=weight;
                edgesUsed++;
                if(edgesUsed==V-1)
                {
                    break;
                }
            }
        }
    return mstWeight;
    }
}
