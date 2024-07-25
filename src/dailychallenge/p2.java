package dailychallenge;

import java.util.HashMap;

public class p2 {
    public static void main(String[] args) {
        String s="abaacbcbb";
        System.out.println(minimumLength(s));
    }
    public static int minimumLength(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int ans = s.length();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);

            if (map.get(ch) > 2) {
                map.put(ch, 1);
                ans -= 2;
            }
        }

        return ans;
    }
}
