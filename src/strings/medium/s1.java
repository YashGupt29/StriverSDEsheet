package strings.medium;

import java.util.*;

public class s1 {
    public static void main(String[] args) {
        String s="acbb";
        System.out.println(frequencySort(s));

    }
    public static String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        List<Character> characters=new ArrayList<>(map.keySet());
        Collections.sort(characters, (a, b) -> map.get(b) - map.get(a));
        StringBuilder sortedString = new StringBuilder();
        for(char ch:characters)
        {
            int freq=map.get(ch);
            for (int i = 0; i <freq ; i++) {
                sortedString.append(ch);
            }
        }
        return sortedString.toString();



    }

}
