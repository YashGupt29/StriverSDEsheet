package cses.dp;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;
public class q8 {
    static final int MOD = (int) (1e9) + 7;
    public static void solve(int n, int m, int[] arr) {

        int [][] dp=new int[n][m+1];
        if(arr[0]!=0)
        {
            dp[0][arr[0]]=1;
        }else {
            for (int i = 1; i <=m ; i++) {
                dp[0][i]=1;
            }
        }
        for (int i = 1; i <n ; i++) {
            for (int j = 1; j <=m ; j++) {
                if(arr[i]==0 || arr[i]==j)
                {
                    dp[i][j]=dp[i-1][j];
                    if (j > 1) dp[i][j] = (dp[i][j] + dp[i - 1][j - 1]) % MOD;
                    if (j < m) dp[i][j] = (dp[i][j] + dp[i - 1][j + 1]) % MOD;
                }
            }
        }
        long ans=0;
        if(arr[n-1]==0)
        {
            for (int j = 1; j <=m ; j++) {
                ans+=dp[n-1][j];
            }
        }else {
            ans=dp[n-1][arr[n-1]];
        }
        System.out.println(ans % MOD);

    }

        public static void main(String[] args) throws IOException {

            int n = InputReader.nextInt();
            int target = InputReader.nextInt();

            int[] arr = InputReader.nextIntArray(n);

            solve(n, target, arr);
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
