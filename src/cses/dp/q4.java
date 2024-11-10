package cses.dp;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class q4 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int MOD = 1_000_000_007;
        long[] dp = new long[x + 1];
        dp[0] = 1;

        // Keeping the original logic structure as required
        for (int target = 1; target <= x; target++) {
            long sum = 0; // Accumulate sum to reduce modulo frequency
            for (int i = 0; i < n; i++) {
                int coins = arr[i];
                if (coins > target) {
                    continue;
                }
                sum += dp[target - coins];
                if (sum >= MOD) sum -= MOD;
            }
            dp[target] = sum;
        }

        System.out.println(dp[x]);
    }
}
