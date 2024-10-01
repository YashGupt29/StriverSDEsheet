package dpAtcoderr;

import java.util.Arrays;
import java.util.Scanner;

public class q4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long w = sc.nextLong();
        long[][] arr = new long[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = sc.nextLong(); // weight of item i
            arr[i][1] = sc.nextLong(); // value of item i
        }
        System.out.println(solve(n, w, arr));
    }

    public static long solve(int n, long w, long[][] arr) {
        // dp array of size n+1 and weight limit w+1
        long[][] dp = new long[n][(int) (w + 1)];
        for (long[] v : dp) {
            Arrays.fill(v, -1);
        }
        return helper(n, w, arr, arr.length - 1, w, dp);
    }

    public static long helper(int n, long w, long[][] arr, int index, long target, long[][] dp) {
        if (index == 0) {
            // Base case: if we can take the first item (if it fits within the target weight)
            if (target >= arr[0][0]) {
                return arr[0][1];
            } else {
                return 0;
            }
        }

        if (dp[index][(int) target] != -1) return dp[index][(int) target];

        long take = Long.MIN_VALUE;

        // Option 1: take the current item if it fits in the remaining capacity
        if (target >= arr[index][0]) {
            take = arr[index][1] + helper(n, w, arr, index - 1, target - arr[index][0], dp);
        }

        // Option 2: don't take the current item
        long notTake = helper(n, w, arr, index - 1, target, dp);

        // Store and return the maximum of taking and not taking the current item
        dp[index][(int) target] = Math.max(take, notTake);
        return dp[index][(int) target];
    }
}
