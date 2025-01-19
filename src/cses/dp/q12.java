package cses.dp;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
public class q12 {
    public static void solve(int n,  int[] arr) {
        int sum=0;
        for (int i = 0; i < n; i++) {
            sum+=arr[i];
        }
        boolean [][] dp=new boolean[n+1][sum+1];
        dp[0][0]=true;
        for (int i = 1; i <=n; i++) {
            for (int j = 0; j <=sum ; j++) {
                if(dp[i - 1][j])
                {
                    dp[i][j]=true;
                }
                else if(j-arr[i-1]>=0 && dp[i-1][j-arr[i-1]])
                {
                    dp[i][j]=true;
                }else {
                    dp[i][j]=false;
                }
            }
        }
        List<Integer> ans=new ArrayList<>();
        for (int i = 1; i <=sum; i++) {
            if(dp[n][i])
            {
                ans.add(i);
            }
        }
        System.out.println(ans.size());
        for (Integer an : ans) {
            System.out.print(an + " ");

        }
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
