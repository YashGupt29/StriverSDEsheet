package graph.algozenith.dijkstra;

import java.util.*;

public class code {
    static int n, m;
    static List<List<Pair>> g;   // Adjacency list for graph
    static long[] dist;          // Distance array
    static boolean[] vis;        // Visited array

    // Custom Pair class to store node and its distance
    static class Pair {
        int node;
        long weight;

        Pair(int node, long weight) {
            this.node = node;
            this.weight = weight;
        }
    }

    public static void dijkstra(int sc) {
        dist = new long[n + 1];
        vis = new boolean[n + 1];

        // Initialize distances to a very large value (similar to 1e18 in C++)
        Arrays.fill(dist, Long.MAX_VALUE);
        Arrays.fill(vis, false);

        dist[sc] = 0;

        // Priority Queue to process nodes by smallest distance, using negation
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Long.compare(a.weight, b.weight));
        pq.add(new Pair(sc, 0));  // Start with the source node, distance = 0

        while (!pq.isEmpty()) {
            Pair current = pq.poll();
            int u = current.node;

            // If the node is already visited, skip it
            if (vis[u]) continue;
            vis[u] = true;

            // Traverse through all neighbors of the current node
            for (Pair neighbor : g.get(u)) {
                int v = neighbor.node;
                long weight = neighbor.weight;

                // Relaxation step
                if (dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                    pq.add(new Pair(v, dist[v]));
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();  // number of nodes
        m = sc.nextInt();  // number of edges

        g = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            g.add(new ArrayList<>());
        }

        // Reading the edges
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            long w = sc.nextLong();
            g.get(u).add(new Pair(v, w));
            g.get(v).add(new Pair(u, w));  // Assuming undirected graph
        }

        int startNode = sc.nextInt();  // Source node for Dijkstra
        dijkstra(startNode);

        // Output the shortest distances from the source node
        for (int i = 1; i <= n; i++) {
            System.out.println("Distance to node " + i + ": " + (dist[i] == Long.MAX_VALUE ? "INF" : dist[i]));
        }

        sc.close();
    }
}
