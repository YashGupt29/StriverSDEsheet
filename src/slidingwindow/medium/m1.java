package slidingwindow.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class m1 {
    public static void main(String[] args) {
        String s="dvdf";
        System.out.println(lengthOfLongestSubstring(s));

    }
    public static int lengthOfLongestSubstring(String s) {
        int i=0;
        int j=0;
        int maxLength=0;
        HashMap<Character,Integer> ch=new HashMap<>();
        while (j < s.length()) {
            if (ch.containsKey(s.charAt(j))) {
                i = Math.max(ch.get(s.charAt(j)) + 1, i);
            }
            ch.put(s.charAt(j), j);
            maxLength = Math.max(maxLength, j - i + 1);
            j++;
        }

        return maxLength;

    }
    public static int lengthOfLongestSubstringBrute(String s) {
        int maxCount=0;
        for (int i = 0; i < s.length() ; i++) {
            int count=0;
            Set<Character> ch= new HashSet<>();
            for (int j = i; j <s.length() ; j++) {
                if(ch.contains(s.charAt(j)))
                {
                    break;
                }
                count++;
                ch.add(s.charAt(j));
            }
            maxCount=Math.max(count,maxCount);
        }
        return maxCount;

    }

}
