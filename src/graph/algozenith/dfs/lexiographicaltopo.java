package graph.algozenith.dfs;

import java.util.*;

public class lexiographicaltopo {
    public static void main(String[] args) {
        // Number of vertices (a, b, c, d, e, f) -> 6 vertices
        int v = 4;

        // Initialize adjacency list for 6 vertices
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= v; i++) { // Using 1-based indexing
            adj.add(new ArrayList<>());
        }

        adj.get(1).add(2);  // a -> b
        adj.get(2).add(3);  // b -> c
        adj.get(3).add(1);  // c -> a (Cycle formed: a -> b -> c -> a)



        // Get topological ordering and check for cycles
        List<Integer> result = topological(v, adj);
        if (result.size() == v) {
            System.out.println("Topological Order: " + result);
        }
    }

    public static List<Integer> topological(int v, List<List<Integer>> adj) {
        int[] inDegree = new int[v + 1]; // To keep track of in-degrees (1-based indexing)

        // Calculate in-degrees
        for (int i = 1; i <= v; i++) {
            for (int neighbor : adj.get(i)) {
                inDegree[neighbor]++;
            }
        }

        // Queue to process nodes with in-degree 0
        PriorityQueue<Integer> queue=new PriorityQueue<>();
        // Add all vertices with in-degree 0 to the queue
        for (int i = 1; i <= v; i++) {
            if (inDegree[i] == 0) {
                queue.offer(-i);
            }
        }

        // List to store the topological order
        List<Integer> topoOrder = new ArrayList<>();

        while (!queue.isEmpty()) {
            int node = -queue.poll();
            topoOrder.add(node);

            // Reduce the in-degree of all neighbors of the current node
            for (int neighbor : adj.get(node)) {
                inDegree[neighbor]--;
                // If in-degree becomes 0, add it to the queue
                if (inDegree[neighbor] == 0) {
                    queue.offer(-neighbor);
                }
            }
        }

        // If topoOrder contains all nodes, then it is a valid topological sort
        return topoOrder;
    }
}
