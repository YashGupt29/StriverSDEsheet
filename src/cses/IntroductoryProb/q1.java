package cses.IntroductoryProb;

import java.util.Scanner;

public class q1 {
    private static final int MAX = 1000000;
    private static long[] memo = new long[MAX + 1];

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = 159487;
        in.close();
        StringBuilder result = new StringBuilder();
        weird(n, result);
        System.out.println(result.toString().trim());
    }

    public static void weird(long n, StringBuilder result) {
        while (n != 1) {
            result.append(n).append(" ");
            if (n <= MAX && memo[(int) n] != 0) {
                n = memo[(int) n];
            } else {
                long next;
                if ((n & 1) == 0) {
                    next = n / 2;
                } else {
                    next = 3 * n + 1;
                }
                if (n <= MAX) {
                    memo[(int) n] = next;
                }
                n = next;
            }
        }
        result.append(n);
    }
}
