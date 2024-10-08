package graph.algozenith.graphAlgo.dsu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class UnionFind {
    int n, setSize;
    int[] parent, rank;

    // Default constructor
    public UnionFind() {}

    // Parameterized constructor
    public UnionFind(int a) {
        n = setSize = a;
        parent = new int[n + 1];
        rank = new int[n + 1];

        // Initialize each node to be its own parent (self-loop) and set rank to 1
        for (int i = 1; i <= n; ++i) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    // Find function with path compression
    public int find(int x) {
        if (x != parent[x]) {
            parent[x] = find(parent[x]); // Path compression
        }
        return parent[x];
    }

    // Union function with rank-based merging
    public void merge(int x, int y) {
        int xRoot = find(x);
        int yRoot = find(y);

        if (xRoot != yRoot) {
            if (rank[xRoot] >= rank[yRoot]) {
                parent[yRoot] = xRoot;
                rank[xRoot] += rank[yRoot];
            } else {
                parent[xRoot] = yRoot;
                rank[yRoot] += rank[xRoot];
            }
            setSize--; // Decrease the number of disjoint sets
        }
    }

    // Return the current number of disjoint sets
    public int size() {
        return setSize;
    }

    // Kruskal's algorithm to find the Minimum Spanning Tree (MST)
    public static int MST() {
        Scanner in = new Scanner(System.in);
        int n, m;
        n = in.nextInt(); // number of nodes
        m = in.nextInt(); // number of edges

        ArrayList<Pair<Integer, Pair<Integer, Integer>>> adj = new ArrayList<>();

        // Read the edges
        for (int i = 0; i < m; i++) {
            int a = in.nextInt(); // node 1
            int b = in.nextInt(); // node 2
            int c = in.nextInt(); // weight of the edge
            adj.add(new Pair<>(c, new Pair<>(a, b)));
        }

        // Sort edges by their weights (first element of Pair)
        adj.sort((edge1, edge2) -> edge1.first.compareTo(edge2.first));

        // Initialize Union-Find structure
        UnionFind dsu = new UnionFind(n);

        int mstWeight = 0; // To store the total weight of the MST
        int edgesUsed = 0; // Number of edges added to the MST

        // Iterate through the sorted edges
        for (Pair<Integer, Pair<Integer, Integer>> edge : adj) {
            int weight = edge.first;
            int u = edge.second.first;
            int v = edge.second.second;

            // If u and v are in different sets, add this edge to the MST
            if (dsu.find(u) != dsu.find(v)) {
                dsu.merge(u, v); // Union the two sets
                mstWeight += weight; // Add the edge's weight to the MST
                edgesUsed++;

                // If we've used n-1 edges, the MST is complete
                if (edgesUsed == n - 1) {
                    break;
                }
            }
        }

        // If we used fewer than n-1 edges, the graph wasn't connected
        if (edgesUsed != n - 1) {
            System.out.println("The graph is not connected, no MST exists.");
            return -1;
        }

        return mstWeight; // Return the total weight of the MST
    }

    // Utility class for storing pairs
    static class Pair<F, S> {
        F first;
        S second;

        Pair(F first, S second) {
            this.first = first;
            this.second = second;
        }
    }

    public static void main(String[] args) {
        System.out.println("Minimum Spanning Tree weight: " + MST());
    }
}
