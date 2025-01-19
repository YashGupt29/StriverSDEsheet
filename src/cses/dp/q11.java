package cses.dp;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class q11 {
    public static void solve(int l, int b) {
        int [][] dp=new int[l+1][b+1];
        for (int length = 1; length <=l; length++) {
            for (int  breadth= 1; breadth <=b ; breadth++) {
                    if(length==breadth)
                    {
                        dp[length][breadth]=0;
                    }
                    else{
                        int mincuts=Integer.MAX_VALUE;
                        for (int i = 1; i <length; i++) {
                            mincuts=Math.min(mincuts,dp[i][breadth] + dp[length-i][breadth] + 1);
                        }
                        for (int i = 1; i <breadth ; i++) {
                            mincuts=Math.min(mincuts,dp[length][i] + dp[length][breadth-i] + 1);
                        }
                        dp[length][breadth]=mincuts;
                    }
            }
        }
        System.out.println(dp[l][b]);
    }

        public static void main(String[] args) throws IOException {

            int length = InputReader.nextInt();
            int breadth = InputReader.nextInt();

            solve(length, breadth);
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
