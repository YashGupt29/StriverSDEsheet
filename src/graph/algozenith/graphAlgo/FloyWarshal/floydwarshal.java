package graph.algozenith.graphAlgo.FloyWarshal;

import java.util.Scanner;

public class floydwarshal {
    static int[][] dist = new int[404][404];
    static int[][] par = new int[404][404];

    // Function to print the path from i to j
    static void printPath(int i, int j) {
        if (i != j) {
            printPath(i, par[i][j]);
        }
        System.out.print(j + " ");  // Print the node in the path
    }

    public static void solve() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();  // number of nodes
        int m = sc.nextInt();  // number of edges

        // Initialize the distance array
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    dist[i][j] = (int) 1e9; // Initialize distances to infinity
                } else {
                    dist[i][j] = 0;  // Distance to itself is 0
                }
            }
        }

        // Reading the input and setting the distances
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            dist[a][b] = Math.min(dist[a][b], c);
        }

        // Initialize the parent array for path reconstruction
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    par[i][j] = -1;  // No parent for the same node
                } else {
                    par[i][j] = i;  // Initialize parent to the source
                }
            }
        }

        // Floyd-Warshall algorithm for shortest paths
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                        par[i][j] = par[k][j]; // Update the parent array for path reconstruction
                    }
                }
            }
        }

        // Print the distance matrix and paths
        System.out.println("Shortest distance matrix:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (dist[i][j] == (int) 1e9) {
                    System.out.print("INF ");  // No path exists
                } else {
                    System.out.print(dist[i][j] + " ");
                }
            }
            System.out.println();
        }

        // Query for specific paths and print them
        System.out.println("Enter the source and destination to print the path (or -1 -1 to stop):");
        while (true) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            if (u == -1 && v == -1) break;  // Stop if -1 -1 is entered

            if (dist[u][v] == (int) 1e9) {
                System.out.println("No path exists from " + u + " to " + v);
            } else {
                System.out.print("Path from " + u + " to " + v + ": " + u + " ");
                printPath(u, v);  // Call printPath to print the path
                System.out.println();
            }
        }

        sc.close();
    }

    public static void main(String[] args) {
        solve();
    }
}
