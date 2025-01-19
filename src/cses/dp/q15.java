package cses.dp;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
public class q15 {
    public static void solve(int n, int[] arr) {
        int [][] dp=new int[n+1][n+1];
        dp[0][0]=1;
        for (int index = n-1; index >=0; index--) {
            for (int prev = -1; prev < index; prev++) {
                    int notTake=dp[index+1][prev+1];
                    int take=Integer.MIN_VALUE;
                    if(prev==-1 || arr[index]>arr[prev])
                    {
                        take=1 + dp[index+1][index+1];
                    }
                    dp[index][prev+1]=Math.max(take,notTake);
            }
        }
        System.out.println(dp[0][0]);
    }

        public static void main(String[] args) throws IOException {

            int n = InputReader.nextInt();
            int[] arr = InputReader.nextIntArray(n);

            solve(n,  arr);
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
