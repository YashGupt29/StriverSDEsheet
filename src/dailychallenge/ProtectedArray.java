package dailychallenge;

import java.util.*;

public class ProtectedArray {
    static final int MOD = 1000000007;

    public static int maximumPower(long k, List<Integer> power) {
        int n = power.size();
        int[][] rangeMax = new int[n][n];

        // Precompute the maximum power in every possible range [l, r]
        for (int l = 0; l < n; l++) {
            int maxPower = power.get(l);
            for (int r = l; r < n; r++) {
                maxPower = Math.max(maxPower, power.get(r));
                rangeMax[l][r] = maxPower;
            }
        }

        // Priority queue to keep track of the maximum powers across all ranges
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[2] != b[2]) {
                return b[2] - a[2]; // Max heap for power values
            } else {
                return a[0] - b[0]; // Leftmost herb if powers are equal
            }
        });

        for (int l = 0; l < n; l++) {
            for (int r = l; r < n; r++) {
                pq.add(new int[]{l, r, rangeMax[l][r]}); // [l, r, maxPower in range]
            }
        }

        long totalPower = 0;
        Set<String> usedPairs = new HashSet<>();

        while (k > 0 && !pq.isEmpty()) {
            int[] current = pq.poll();
            int l = current[0], r = current[1], maxPower = current[2];
            String pairKey = l + "-" + r;

            if (!usedPairs.contains(pairKey)) {
                totalPower = (totalPower + maxPower) % MOD;
                usedPairs.add(pairKey);
                k--;
            }
        }

        return (int) totalPower;
    }

    public static void main(String[] args) {
        List<Integer> power = Arrays.asList(4, 2, 4, 3, 5);
        long k = 5;
        int result = maximumPower(k, power);
        System.out.println("Maximum power increase after " + k + " days: " + result);
    }
}

