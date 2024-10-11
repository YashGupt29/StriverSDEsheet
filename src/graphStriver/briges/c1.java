package graphStriver.briges;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class c1 {
    public static void main(String[] args) {
        List<List<Integer>> arr = new ArrayList<>();
        arr.add(Arrays.asList(1, 2));
        arr.add(Arrays.asList(1, 4));
        arr.add(Arrays.asList(2, 3));
        arr.add(Arrays.asList(4, 3));
        arr.add(Arrays.asList(4, 5));
        arr.add(Arrays.asList(5, 6));
        arr.add(Arrays.asList(6, 7));
        arr.add(Arrays.asList(6, 9));
        arr.add(Arrays.asList(7, 8));
        arr.add(Arrays.asList(9, 8));
        arr.add(Arrays.asList(8, 10));
        arr.add(Arrays.asList(10, 12));
        arr.add(Arrays.asList(10, 11));
        arr.add(Arrays.asList(11, 12));

        System.out.println(criticalConnections(13, arr));
    }

    static int timer;

    public static List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (List<Integer> it : connections) {
            adj.get(it.get(0)).add(it.get(1));
            adj.get(it.get(1)).add(it.get(0));
        }
        int[] vis = new int[n];
        int[] tin = new int[n];
        int[] low = new int[n];
        List<List<Integer>> bridges = new ArrayList<>();
        timer = 1;
        for (int i = 0; i < n; i++) {
            if (vis[i] == 0) {
                dfs(i, -1, vis, tin, low, adj, bridges);
            }
        }
        return bridges;
    }

    public static void dfs(int node, int parent, int[] vis, int[] tin, int[] low, List<List<Integer>> adj, List<List<Integer>> bridges) {
        vis[node] = 1;
        tin[node] = low[node] = timer++;
        for (int v : adj.get(node)) {
            if (v == parent) {
                continue;
            }
            if (vis[v] == 0) {
                dfs(v, node, vis, tin, low, adj, bridges);
                low[node] = Math.min(low[node], low[v]);
                if (low[v] > tin[node]) {
                    bridges.add(Arrays.asList(node, v));
                }
            } else {
                low[node] = Math.min(low[node], low[v]);
            }
        }
    }
}
