package cses.dp;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
public class q13 {
    public static void solve(int n, int[] arr) {
        long sum=0;
        for (int i = 0; i < n; i++) {
            sum+=arr[i];
        }
        long [][] dp=new long[n][n];
        for (int l = n-1; l >=0 ; l--) {
            for (int r = l; r < n ; r++) {
                if(l==r)
                {
                    dp[l][r]=arr[l];
                }else {
                    dp[l][r]=Math.max(arr[l] - dp[l+1][r],arr[r] - dp[l][r-1]); //gain it is of player 1 by subracting the score of player 2
                }
            }
        }
        long score=(sum + dp[0][n-1])/2;
        System.out.println(score);
    }

        public static void main(String[] args) throws IOException {

            int n = InputReader.nextInt();
            int[] arr = InputReader.nextIntArray(n);

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
        }
}
