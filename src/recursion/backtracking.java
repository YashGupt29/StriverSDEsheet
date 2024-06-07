package recursion;

public class backtracking {
    public static void backtrack(int n, int depth) {
        // Base case: If depth exceeds n, stop recursion
        if (depth > n) {
            return;
        }

        // Print the current depth
        System.out.println("Recursive call " + depth);

        // Recursive call with increased depth
        backtrack(n, depth + 1);
        backtrack(n, depth + 1);


        // Backtrack: Print that backtracking starts
        System.out.println("Now backtracking starts at depth " + depth);
    }

    public static void main(String[] args) {
        // Call the backtrack method with n = 3 and starting depth 1
        backtrack(3, 1);
    }
}
