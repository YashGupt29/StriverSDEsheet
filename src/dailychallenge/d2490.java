package dailychallenge;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class d2490 {
    public static void main(String[] args) {
        String s="leetcode exercises sound delightful";
        System.out.println(isCircularSentence(s));
    }
    public static boolean isCircularSentence(String sentence) {
        int n=sentence.length();
        if(sentence.charAt(0)!=sentence.charAt(n-1))
        {
         return false;
        }
        String[] words = sentence.split(" ");
        char prev=words[0].charAt(words[0].length()-1);
        for (int i = 1; i < words.length; i++) {
            String word=words[i];
            char curr=word.charAt(0);
            if(curr!=prev)
            {
                return false;
            }
            prev=word.charAt(word.length()-1);
        }
        return true;
    }
}
