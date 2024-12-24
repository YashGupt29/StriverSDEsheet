package cses.graph;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class q3 {
        public static void solve(int n, int m, List<List<Integer>> graph) {
            boolean [] visited=new boolean[n+1];
            List<Integer> ans=new ArrayList<>();
            int comp=0;
            for (int i = 1; i <=n; i++) {
                if(!visited[i])
                {
                    ans.add(i);
                    comp++;
                    dfs(i,visited,graph);
                }
            }
            System.out.println(comp-1);
            for (int i = 1; i < ans.size(); i++) {
                System.out.print(ans.get(i-1)+ " ");
                System.out.println(ans.get(i));
            }
        }
        public static void dfs(int node,boolean [] visited,List<List<Integer>> graph)
        {
            visited[node]=true;
            for(int currNode:graph.get(node))
            {
                if(!visited[currNode])
                {
                    dfs(currNode,visited,graph);
                }

            }
        }

        public static void main(String[] args) throws IOException {

            int n = InputReader.nextInt();
            int m = InputReader.nextInt();
            int [][] arr=InputReader.nextInt2DArray(m,2);
            List<List<Integer>> graph=new ArrayList<>();
            for (int i = 0; i <=n ; i++) {
                graph.add(new ArrayList<>());
            }
            for (int i = 0; i < arr.length; i++) {
                graph.get(arr[i][1]).add(arr[i][0]);
                graph.get(arr[i][0]).add(arr[i][1]);
            }
            solve(n, m, graph);
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
        }
}
