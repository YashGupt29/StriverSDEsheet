package cses.IntroductoryProb;

import java.util.Scanner;

public class q3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String input = in.nextLine();

        StringBuilder s = new StringBuilder(input);

        in.close();

        System.out.println(repetitions(s));
    }
    public static int repetitions(StringBuilder s) {
        int maxCount = 1;
        int currentCount = 1;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                currentCount++;
            } else {
                maxCount = Math.max(maxCount, currentCount);
                currentCount = 1;
            }
        }

        maxCount = Math.max(maxCount, currentCount);

        return maxCount;
    }
}
