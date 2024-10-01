package graph.algozenith.topo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class topo {
    public static void main(String[] args) {
        // Number of vertices (a, b, c, d, e, f) -> 6 vertices
        int v = 6;

        // Initialize adjacency list for 6 vertices
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= v; i++) { // Using 1-based indexing
            adj.add(new ArrayList<>());
        }

        // Adding edges according to the given graph
        adj.get(1).add(2); // a -> b (a is 1, b is 2)
        adj.get(1).add(3); // a -> c (a is 1, c is 3)
        adj.get(2).add(4); // b -> d (b is 2, d is 4)
        adj.get(3).add(4); // c -> d (c is 3, d is 4)
        adj.get(3).add(5); // c -> e (c is 3, e is 5)
        adj.get(4).add(6); // d -> f (d is 4, f is 6)

        // Get topological ordering
        List<Integer> result = topological(v, adj);
        System.out.println(result);

        // Print the topological order
        for (int node : result) {
            System.out.print((char) ('a' + node - 1) + " "); // Converting index back to character
        }
    }

    static List<Integer> topo;
    static int[] vis;

    public static List<Integer> topological(int v, List<List<Integer>> adj) {
        topo = new ArrayList<>();
        vis = new int[v + 1]; // 1-based indexing
        for (int i = 1; i <= v; i++) {
            if (vis[i] == 0) {
                dfs(adj, i);
            }
        }
        Collections.reverse(topo);
        return topo;
    }

    public static void dfs(List<List<Integer>> adj, int node) {
        vis[node] = 1;
        for (int v : adj.get(node)) {
            if (vis[v] == 0) {
                dfs(adj, v);
            }
        }
        topo.add(node);
    }
}
