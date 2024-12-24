package cses.graph;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class q1 {
    static int [] dx={-1,1,0,0};
    static int [] dy={0,0,1,-1};
    public static boolean check(int x,int y,int n,int m)
    {
        return x<n && y<m && x>=0 && y>=0;
    }
    public static void bfs(int startI, int startJ, char[][] arr, boolean[][] visited) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startI, startJ});
        visited[startI][startJ] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int i = current[0];
            int j = current[1];

            for (int k = 0; k < 4; k++) {
                int newI = i + dx[k];
                int newJ = j + dy[k];
                if (check(newI, newJ, arr.length, arr[0].length) && arr[newI][newJ] == '.' && !visited[newI][newJ]) {
                    visited[newI][newJ] = true;
                    queue.offer(new int[]{newI, newJ});
                }
            }
        }
    }

    public static void solve(int n, int m, char[][] arr) {
        boolean[][] visited = new boolean[n][m];
        int comp = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && arr[i][j] == '.') {
                    comp++;
                    bfs(i, j, arr, visited);
                }
            }
        }
        System.out.println(comp);
    }
        public static void main(String[] args) throws IOException {

            int n = InputReader.nextInt();
            int m=InputReader.nextInt();
            char[][] arr=InputReader.nextChar2DArray(n,m);

            solve(n,m,arr);
        }

        static class InputReader {

            private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            private static StringTokenizer st;

            public static String next() throws IOException {
                if (st == null || !st.hasMoreTokens()) {
                    st = new StringTokenizer(br.readLine());
                }
                return st.nextToken();
            }

            public static int nextInt() throws IOException {
                return Integer.parseInt(next());
            }

            public static long nextLong() throws IOException {
                return Long.parseLong(next());
            }

            public static double nextDouble() throws IOException {
                return Double.parseDouble(next());
            }

            public static int[] nextIntArray(int n) throws IOException {
                int[] arr = new int[n];
                for (int i = 0; i < n; i++) {
                    arr[i] = nextInt();
                }
                return arr;
            }

            public static long[] nextLongArray(int n) throws IOException {
                long[] arr = new long[n];
                for (int i = 0; i < n; i++) {
                    arr[i] = nextLong();
                }
                return arr;
            }

            public static int[][] nextInt2DArray(int rows, int cols) throws IOException {
                int[][] arr = new int[rows][cols];
                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < cols; j++) {
                        arr[i][j] = nextInt();
                    }
                }
                return arr;
            }

            public static long[][] nextLong2DArray(int rows, int cols) throws IOException {
                long[][] arr = new long[rows][cols];
                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < cols; j++) {
                        arr[i][j] = nextLong();
                    }
                }
                return arr;
            }
            public static char[][] nextChar2DArray(int rows, int cols) throws IOException {
                char[][] grid = new char[rows][cols];
                for (int i = 0; i < rows; i++) {
                    String line = br.readLine();
                    for (int j = 0; j < cols; j++) {
                        grid[i][j] = line.charAt(j);
                    }
                }
                return grid;
            }
        }
}
