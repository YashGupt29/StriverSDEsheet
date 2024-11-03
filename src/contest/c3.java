package contest;

import java.util.*;

public class c3 {
    public static void main(String[] args) {
        int [] arr={2,4,8,16};
        String s="abcyy";
        System.out.println(maxScore(arr));
    }
    private static long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    private static long lcm(long a, long b) {
        return (a / gcd(a, b)) * b;
    }

    public static long maxScore(int[] nums) {
        int n = nums.length;
        long totalGCD = nums[0];
        long totalLCM = nums[0];

        for (int i = 1; i < n; i++) {
            totalGCD = gcd(totalGCD, nums[i]);
            totalLCM = lcm(totalLCM, nums[i]);
        }

        long maxScore = totalGCD * totalLCM;

        for (int i = 0; i < n; i++) {
            long newGCD = -1, newLCM = -1;
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                if (newGCD == -1) newGCD = nums[j];
                else newGCD = gcd(newGCD, nums[j]);

                if (newLCM == -1) newLCM = nums[j];
                else newLCM = lcm(newLCM, nums[j]);
            }
            maxScore = Math.max(maxScore, newGCD * newLCM);
        }

        return maxScore;
    }
}
