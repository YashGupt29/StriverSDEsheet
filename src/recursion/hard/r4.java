package recursion.hard;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class r4 {
    public static void main(String[] args) {

    }
    public static boolean wordBreak(String s, List<String> wordDict)
    {
       return wordBreakHelper(0,s, new HashSet<String>(wordDict));


    }
    public static  boolean wordBreakHelper(int p, String s, Set<String> ans)
    {
        if(p==s.length())
        {
            return true;
        }
        for (int i = p+1; i < s.length(); i++) {
            if(ans.contains(s.substring(p,i)) && wordBreakHelper(i,s,ans))
            {
                return true;
            }

        }
        return false;

    }
}
