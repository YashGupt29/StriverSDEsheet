package dp.lc;
import cses.dp.q14;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
public class lc1262 {
    public  static int rec(int i,int x,int [] nums)
    {
        int n=nums.length;
        if(i==n)
        {
            if(x==0)
            {
                return 0;
            }
            else {
                return Integer.MIN_VALUE;
            }
        }
        return Math.max(rec(i+1,x,nums),rec(i+1,x + nums[i] % 3,nums));
    }
    public static int maxSumDivThree(int[] nums) {
        int n=nums.length;
        int [][] dp=new int [n+1][3];
        for(int [] arr:dp)
        {
            Arrays.fill(arr,Integer.MIN_VALUE);
        }
        dp[0][0]=0;
        for (int i = 1; i <=n ; i++) {
            for (int r = 0; r < 3; r++) {
                int notTake=dp[i-1][r];
                int take=Integer.MIN_VALUE;
                if(dp[i-1][(r-(nums[i-1] % 3) + 3 )% 3]!=Integer.MIN_VALUE)
                {
                     take=dp[i-1][r] + nums[i-1];
                }
                dp[i][r]=Math.max(take,notTake);
            }
        }
        System.out.println(Arrays.deepToString(dp));
        return dp[n][0];
    }
        public static void main(String[] args) throws IOException {
            int n = InputReader.nextInt();
            int[] arr = InputReader.nextIntArray(n);

            int ans=maxSumDivThree(arr);
            System.out.println(ans);
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
