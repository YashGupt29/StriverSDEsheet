package dailychallenge;

import java.util.HashMap;
import java.util.Stack;

public class d1190 {
    public static void main(String[] args) {
        String s="(ed(et(oc))el)";
        System.out.println(reverseParentheses(s));
    }

    public static String reverseParentheses(String s) {
         int [] map=new int[s.length()];
        int count=0;
        for (int i = 0; i < s.length() ; i++) {
            if(s.charAt(i)=='(')
            {
                count++;
               map[count]=i;
            }
        }
        return helper(s,count,new StringBuilder(),map);
    }
    public static  String helper(String s, int count,StringBuilder sb,int [] map)
    {
        if(count==0)
        {
            sb.append(s);
            return sb.toString();
        }
        int i=map[count];
        int j=i;
        while(s.charAt(j)!=')')
        {
            j++;
        }
        helper(reverseSubstring(s,i,j),count-1,sb,map);
        return sb.toString();
    }
    public static String reverseSubstring(String s, int startIndex, int endIndex) {
        int adjustedStart = startIndex + 1;
        int adjustedEnd = endIndex - 1;
        StringBuilder sb = new StringBuilder(s.substring(adjustedStart, adjustedEnd + 1));
        sb.reverse();

        return s.substring(0, startIndex) + sb.toString() + s.substring(endIndex + 1);
    }
}
