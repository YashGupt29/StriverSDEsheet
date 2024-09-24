package graph.algozenith.dfs;

import java.util.*;


public class bfsMaze {
    static int n, m;
    static List<String> arr = new ArrayList<>();
    static int[][] dist;
    static List<List<Pair<Integer, Integer>>> par;
    // Directions for moving in a grid (up, down, left, right)
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    // Function to check if the move is within bounds and the cell is not blocked
    static boolean check(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < m && arr.get(x).charAt(y) != '#';
    }

    // BFS function to calculate the shortest distance from the starting point
    static void bfs(Pair<Integer, Integer> st) {
        Queue<Pair<Integer, Integer>> q = new LinkedList<>();
        dist = new int[n][m];
        par = new ArrayList<>();

        // Initializing distance array to a large number (like infinity)
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
            par.add(new ArrayList<>(Collections.nCopies(m, new Pair<>(-1, -1))));
        }

        // BFS starts from the source
        dist[st.first][st.second] = 0;
        par.get(st.first).set(st.second, new Pair<>(st.first, st.second)); // Set parent of the start as itself
        q.add(st);

        while (!q.isEmpty()) {
            Pair<Integer, Integer> cur = q.poll();
            int x = cur.first;
            int y = cur.second;

            // Check all 4 possible movements
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                // If the next position is valid and not yet visited
                if (check(nx, ny) && dist[nx][ny] > dist[x][y] + 1) {
                    dist[nx][ny] = dist[x][y] + 1;
                    par.get(nx).set(ny, new Pair<>(x, y)); // Set the parent of (nx, ny) as (x, y)
                    q.add(new Pair<>(nx, ny));
                }
            }
        }
    }

    // Recursive function to print the path from start to end
    static void printPath(Pair<Integer, Integer> st, Pair<Integer, Integer> en) {
        // Base case: if the current node is the start node, print it
        if (Objects.equals(st.first,en.first) && Objects.equals(st.second,en.second)) {
            System.out.println("(" + st.first + ", " + st.second + ")");
            return;
        }

        // Recursive case: first print the path from start to the parent of the current node
        Pair<Integer, Integer> parent = par.get(en.first).get(en.second);
        if (parent.first == -1 && parent.second == -1) {
            System.out.println("No path found!");
            return;
        }

        printPath(st, parent);

        // Then print the current node (en) after the recursive call
        System.out.println("(" + en.first + ", " + en.second + ")");
    }

    // Main solving function
    static void solve() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        // Reading the grid
        arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(sc.next());
        }

        // Reading start and end points
        Pair<Integer, Integer> st = new Pair<>(sc.nextInt(), sc.nextInt());
        Pair<Integer, Integer> en = new Pair<>(sc.nextInt(), sc.nextInt());

        // Running BFS from the starting point
        bfs(st);

        // Output distance to the endpoint
        if (dist[en.first][en.second] == Integer.MAX_VALUE) {
            System.out.println("No path to endpoint.");
        } else {
            System.out.println("Distance to endpoint: " + dist[en.first][en.second]);

            // Output the path from start to endpoint using recursion
            System.out.println("Path:");
            printPath(st, en);
        }
    }
    // Helper class for Pair similar to C++'s std::pair
    static class Pair<F, S> {
        F first;
        S second;
        public Pair(F first, S second) {
            this.first = first;
            this.second = second;
        }
    }


    public static void main(String[] args) {
        solve();

    }
}
