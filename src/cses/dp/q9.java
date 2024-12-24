package cses.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.List;
import java.util.StringTokenizer;

public class q9 {
    public static int MOD = (int) (1e9) + 7;
    public static final int N = (int) (1e6 + 10);

    public static void main(String[] args) throws IOException {
        long[] oneBlock = new long[N + 1];
        long[] twoBlock = new long[N + 1];
        oneBlock[1] = 1;
        twoBlock[1] = 1;
        for (int i = 2; i <= N; i++) {
            oneBlock[i] = (2 * oneBlock[i - 1] + twoBlock[i - 1]) % MOD;
            twoBlock[i] = (4 * twoBlock[i - 1] + oneBlock[i - 1]) % MOD;
        }
        int n = InputReader.nextInt();
        while (n > 0) {
            int height = InputReader.nextInt();
            System.out.println((oneBlock[ height] + twoBlock[ height]) % MOD);
            n--;
        }
    }

    static class InputReader {
        private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        private static StringTokenizer st;

        public static String next() throws IOException {
            while (st == null || !st.hasMoreTokens()) {
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
    }
}
