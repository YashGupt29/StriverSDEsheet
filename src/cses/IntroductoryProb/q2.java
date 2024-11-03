package cses.IntroductoryProb;
import java.util.Scanner;

public class q2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long[] arr = new long[n - 1];
        for (int i = 0; i < n - 1; i++) {
            arr[i] = in.nextLong();
        }
        in.close();
        System.out.println(missing(n, arr));
    }

    public static long missing(int n, long[] arr) {
        long sum = 0;
        for (long num : arr) {
            sum += num;
        }
        long actualSum = (long) n * (n + 1) / 2;
        return actualSum - sum;
    }
}
