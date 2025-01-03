package cses.dp;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;
public class q6 {
    public static int MOD=(int)(1e9) + 7;
    public static void solve(int n, char[][] arr) {
        int [][] dp=new int[n][n];
        dp[0][0]=arr[0][0]=='*'?0:1;
        for (int row = 0; row < n ; row++) {
            for (int col = 0; col < n; col++) {
                if(row==0 && col==0) continue;
                if(arr[row][col]!='*')
                {
                    int left=0;
                    int up=0;
                    if(row>0)
                    {
                        left=dp[row-1][col];
                    }
                    if(col>0)
                    {
                        up=dp[row][col-1];
                    }
                    dp[row][col]=(left+up) % MOD;
                }
                else {
                    dp[row][col]=0;
                }
            }
        }
        System.out.println(dp[n-1][n-1] % MOD);
    }

        public static void main(String[] args) throws IOException {

            int n = InputReader.nextInt();
            char [][] arr=InputReader.nextChar2DArray(n,n);
            solve(n, arr);
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
