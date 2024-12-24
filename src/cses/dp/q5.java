package cses.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class q5 {
    public static void solve(int n) {
        int [] dp=new int[n+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0]=0;
        for (int i = 1; i <=n; i++) {
             String num2str=Integer.toString(i);
             for(char ch:num2str.toCharArray())
             {
                 int digit=ch-'0';
                 if(digit!=0)
                 {
                     dp[i]=Math.min(dp[i],dp[i-digit] + 1);
                 }
             }
        }
        System.out.println(dp[n]);
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
