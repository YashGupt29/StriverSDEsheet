package strings;

public class s1 {
    public static void main(String[] args) {
        String s = "(()())";
        System.out.println(removeOuterParentheses(s));
    }

    public static String removeOuterParentheses(String s) {
        int count = 0;
        StringBuilder newString = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                if (count > 0) {
                    newString.append('('); // Concatenate '(' to newString if count is greater than 0
                }
                count++;
            } else if (s.charAt(i) == ')') {
                count--;
                if (count > 0) {
                    newString.append(')'); // Concatenate ')' to newString if count is still greater than 0 after decrementing
                }
            }
        }
        return newString.toString();
    }
}
