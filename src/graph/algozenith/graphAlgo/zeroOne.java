package graph.algozenith.graphAlgo;

import java.util.*;

public class zeroOne {
    static ArrayList<ArrayList<Pair>> adj;

    public static void main(String[] args) {
        solve();
    }

    public static void solve() {
        adj = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int n, m;
        n = sc.nextInt(); // Number of nodes
        m = sc.nextInt(); // Number of edges

        // Initialize adjacency list for each node
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        // Reading edges
        for (int i = 0; i < m; i++) {  // Change loop to run 'm' times (i < m)
            int a, b, c;
            a = sc.nextInt();
            b = sc.nextInt();
            c = sc.nextInt(); // 'c' is the weight (either 0 or 1)

            // Add the edge for an undirected graph
            adj.get(a).add(new Pair(b, c));
            adj.get(b).add(new Pair(a, c)); // Adding reverse edge if the graph is undirected
        }

        int source = sc.nextInt(); // Read the source node
        bfs01(source, n); // Call bfs01 with source and the number of nodes
    }

    // 0-1 BFS function
    public static void bfs01(int source, int n) {
        int[] dist = new int[n + 1]; // Distance array size should match the number of nodes 'n'
        Deque<Integer> deque = new LinkedList<>();

        Arrays.fill(dist, Integer.MAX_VALUE); // Fill with a large value
        dist[source] = 0; // Distance to source is 0
        deque.add(source); // Start from the source

        // Standard 0-1 BFS loop
        while (!deque.isEmpty()) {
            int curr = deque.poll();

            for (Pair v : adj.get(curr)) {
                int neighbor = v.first;
                int weight = v.second;

                // Relaxation step: update distance if a shorter path is found
                if (dist[neighbor] > dist[curr] + weight) {
                    dist[neighbor] = dist[curr] + weight;

                    if (weight == 0) {
                        deque.addFirst(neighbor); // Push to front for weight 0
                    } else {
                        deque.addLast(neighbor); // Push to back for weight 1
                    }
                }
            }
        }

        // Output the shortest distances to all nodes from the source
        for (int i = 1; i <= n; i++) {
            System.out.print(dist[i] == Integer.MAX_VALUE ? "INF " : dist[i] + " ");
        }
        System.out.println();
    }

    // Pair class to store graph edges
    static class Pair {
        int first; // Neighbor node
        int second; // Weight (0 or 1)

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
}
