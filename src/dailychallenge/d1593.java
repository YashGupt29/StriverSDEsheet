package dailychallenge;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class d1593 {
    public static void main(String[] args) {
        System.out.println(maxUniqueSplit("aba"));
    }
    public static int maxUniqueSplit(String s) {
        int [] max=new int[1];
        helper(0,s,max);
        return max[0];
    }
    static Set<String> memo=new HashSet<>();
    public static int helper(int i,String s,int [] max)
    {
        if(i>=s.length())
        {
            return 0;
        }
        int freq=0;
        for (int k = i+1; k <=s.length(); k++) {
            String word=s.substring(i,k);
            if( !memo.contains(word))
            {
                memo.add(word);
                int currentFreq=1 + helper(k,s,max);
                freq=Math.max(freq,currentFreq);
                max[0] =Math.max(max[0],freq);
                memo.remove(word);
            }
        }

        return  freq;
    }
}
