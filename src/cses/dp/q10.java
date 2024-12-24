package cses.dp;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.List;
import java.util.StringTokenizer;

public class q10 {
    public static void solve(String word1,String word2) {
       int n=word1.length();
       int m=word2.length();
       int [][] dp=new int[n+1][m+1];
        for (int i = 0; i <=m ; i++) {
            dp[0][i]=i;
        }
        for (int i = 0; i <=n ; i++) {
            dp[i][0]=i;
        }
        for (int i = 1; i <=n; i++) {
            for (int j = 1; j <=m; j++) {
                if(word1.charAt(i-1)==word2.charAt(j-1))
                {
                    dp[i][j]= dp[i-1][j-1];
                }else {
                    dp[i][j]=Math.min(1+dp[i-1][j-1],Math.min(1+ dp[i-1][j],1+ dp[i][j-1]));
                }
            }
        }
        int ans = dp[n][m];

        System.out.println(ans);
    }
    public static void main(String[] args) throws IOException {

            String word1=InputReader.nextLine();
            String word2=InputReader.nextLine();

           solve(word1,word2);

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

            public static String nextLine() throws IOException {
                return br.readLine();
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
