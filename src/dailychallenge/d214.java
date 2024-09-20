package dailychallenge;

public class d214 {
    public static void main(String[] args) {

        System.out.println(shortestPalindrome("aacecaaa")); // Output: "aaacecaaa"
        System.out.println(shortestPalindrome("abcd"));     // Output: "dcbabcd"
    }
    public static String shortestPalindrome(String s) {
        String rev = new StringBuilder(s).reverse().toString();
        int lcsLength = longestCommonSubsequence(s, rev);
        int charsToAdd = s.length() - lcsLength;

        // The part of the string that is not in the LCS, reversed
        String toAdd = s.substring(lcsLength);
        String prefixToAdd = new StringBuilder(toAdd).reverse().toString();

        // Construct the shortest palindrome
        return prefixToAdd + s;
    }

    private static int longestCommonSubsequence(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n + 1][m + 1];

        // Build the DP table for LCS
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[n][m];
    }


}
