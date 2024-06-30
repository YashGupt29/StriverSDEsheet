package slidingwindow.medium;

import java.util.HashMap;

public class m4 {
    public static void main(String[] args) {
        System.out.println(characterReplacement("AABABBA",1));

    }
    public static int characterReplacement(String s, int k) {
        int i=0;
        int j=0;
        int [] count=new int[26];
        int maxFreq=0;
        int maxLength=0;
        while(j<s.length())
        {
            char ch=s.charAt(j);
            count[ch-'A']++;
            maxFreq=Math.max(maxFreq,count[ch-'A']);
            while((j-i+1)-maxFreq>k)
            {
                count[s.charAt(i)-'A']--;
                i++;
            }
            maxLength=Math.max(maxLength,j-i+1);
            j++;
        }
        return maxLength;

    }
}
