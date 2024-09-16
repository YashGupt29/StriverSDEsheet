
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
        int maxCount = 1;  // To store the maximum repetition length
        int currentCount = 1;  // To store the current repetition length

        // Iterate through the string to find the longest repetition
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {  // If the current character matches the previous one
                currentCount++;  // Increment the current count
            } else {
                maxCount = Math.max(maxCount, currentCount);  // Update the maximum count
                currentCount = 1;  // Reset the current count
            }
        }

        // Check for the last repetition segment
        maxCount = Math.max(maxCount, currentCount);

        return maxCount;  // Return the maximum repetition length
    }
}
