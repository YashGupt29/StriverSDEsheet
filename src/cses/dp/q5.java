package cses.dp;

import java.util.Arrays;
import java.util.List;

public class q5 {
    static final long MOD = 1000000007;

    // Function to find the number of distinct ordered ways to
    // produce a money sum X using coins
    static long solve(int N, int X, List<Long> coins) {
        // dp[] array such that dp[i] stores the number of
        // ordered ways to construct sum i
        long[] dp = new long[X + 1];
        Arrays.fill(dp, 0);

        // Initialize dp[0] = 1 as there is only one way to
        // construct sum 0 that is to not choose any coin
        dp[0] = 1;

        // Iterate over all coins from 0 to N - 1
        for (int i = 0; i < N; i++) {
            // Iterate over all sums j from coins[i] to X
            for (int j = coins.get(i).intValue(); j <= X; j++) {
                // Add the number of ways to construct sum (j -
                // coins[i]) to dp[j]
                dp[j] = (dp[j] + dp[j - coins.get(i).intValue()]) % MOD;
            }
        }

        // Return the number of ordered ways to construct sum X
        return dp[X];
    }

    public static void main(String[] args) {
        // Sample Input
        int N = 3, X = 2000;
        List<Long> coins = Arrays.asList(1L, 1500L, 1000L);

        System.out.println(solve(N, X, coins));
    }
}



