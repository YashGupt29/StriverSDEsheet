package strings;

import java.util.HashMap;

public class s7 {
    public static void main(String[] args) {
        String s="anagram";
        String t="nagaram";
        System.out.println(isAnagram(s,t));

    }
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Integer> maps = new HashMap<>();
        HashMap<Character, Integer> mapt = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char chars = s.charAt(i);
            char chart = t.charAt(i);
            maps.put(chars, maps.getOrDefault(chars, 0) + 1);
            mapt.put(chart, mapt.getOrDefault(chart, 0) + 1);
        }

        return maps.equals(mapt);
    }
}
