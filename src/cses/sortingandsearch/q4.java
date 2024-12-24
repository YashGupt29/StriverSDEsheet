package cses.sortingandsearch;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class q4 {
    public static void solve(int n, int m, int[] ticket,int [] customer) {
        TreeMap<Integer,Integer> tickets=new TreeMap<>();
        for (int i = 0; i < n; i++) {
            tickets.put(ticket[i], tickets.getOrDefault(ticket[i], 0) + 1);
        }
        for (int i = 0; i < m; i++) {
            Integer suitableTicket=tickets.floorKey(customer[i]);
            if(suitableTicket!=null) {
                System.out.println(suitableTicket);
                int freq = tickets.get(suitableTicket) - 1;
                if (freq == 0) {
                    tickets.remove(suitableTicket);
                } else {
                    tickets.put(suitableTicket, freq);
                }
            }
            else {
                System.out.println(-1);
            }
        }
    }

        public static void main(String[] args) throws IOException {

            int n = InputReader.nextInt();
            int m = InputReader.nextInt();

            int[] ticket = InputReader.nextIntArray(n);
            int [] customer=InputReader.nextIntArray(m);

            solve(n, m, ticket,customer);
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
