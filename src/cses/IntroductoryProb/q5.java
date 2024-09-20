import java.util.Scanner;

public class q5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.close();
        sol(n);
    }

    public static void sol(int n) {
        if (n == 2 || n == 3) {
            System.out.println("NO SOLUTION");
            return;
        }

        StringBuilder result = new StringBuilder();

        // Add even numbers first
        for (int i = 2; i <= n; i += 2) {
            result.append(i).append(" ");
        }

        // Add odd numbers
        for (int i = 1; i <= n; i += 2) {
            result.append(i).append(" ");
        }

        // Print result at once
        System.out.println(result.toString().trim());
    }
}
