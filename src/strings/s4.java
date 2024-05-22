package strings;

public class s4 {
    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "flight"};
        System.out.println(longestCommonPrefixOptimized(strs));
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        String prefix = strs[0];

        for (int i = 1; i < strs.length; i++) {
            prefix = compare(prefix, strs[i]);
            if (prefix.isEmpty()) {
                break;
            }
        }

        return prefix;
    }

    public static String compare(String s1, String s2) {
        StringBuilder prefix = new StringBuilder();
        int minLength = Math.min(s1.length(), s2.length());
        for (int i = 0; i < minLength; i++) {
            if (s1.charAt(i) == s2.charAt(i)) {
                prefix.append(s1.charAt(i));
            } else {
                break;
            }
        }
        return prefix.toString();
    }
    public static String longestCommonPrefixOptimized(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        String prefix = strs[0];

        for (int i = 1; i < strs.length; i++) {

            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }

        return prefix;
    }
}
