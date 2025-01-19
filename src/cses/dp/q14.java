package cses.dp;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
public class q14 {
    public static int MOD=(int)(1e9) + 7;
    public static void solve(int n) {
        int sum= (n * (n+1))/2;
        if(sum % 2!=0)
        {
            System.out.println(0);
            return;
        }
        int target=sum/2;
        int [][] dp=new int[n][target+1];
        dp[0][0]=1;
        for (int i = 1; i <n; i++) {
            for (int j = 0; j <=target; j++) {
                if(j-i>=0)
                {
                    dp[i][j]=(dp[i-1][j] % MOD+ dp[i-1][j-i] % MOD ) % MOD; //dp[i-1][j] is number of ways to make sum j with i-1 if i is excluded
                }
                else {
                    dp[i][j]=dp[i-1][j] % MOD;
                }
            }
        }
        System.out.println(dp[n-1][target] % MOD);
    }

        public static void main(String[] args) throws IOException {

            int n = InputReader.nextInt();
            solve(n);
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
