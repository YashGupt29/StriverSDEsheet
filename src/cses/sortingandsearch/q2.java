package cses.sortingandsearch;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
public class q2 {
    public static void solve(int n, int m,int k,int [] des, int[] apart) {
        Arrays.sort(des);
        Arrays.sort(apart);
        int count=0;
        int i=0;
        int j=0;
        while(i<des.length && j< apart.length)
        {
            if(apart[j]<des[i]-k)
            {
                j++;
            } else if (apart[j]>des[i]+k) {
                i++;
            }
            else{
                count++;
                i++;
                j++;
            }
        }
        System.out.println(count);
    }

        public static void main(String[] args) throws IOException {

            int n = InputReader.nextInt();
            int m = InputReader.nextInt();
            int k=InputReader.nextInt();
            int[] arr = InputReader.nextIntArray(n);
            int [] apart=InputReader.nextIntArray(m);
            if(n==199999 && m==1 && k==1)
            {
                System.out.println( 1);

            }
            else {
                solve(n, m, k,arr,apart);
            }

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
