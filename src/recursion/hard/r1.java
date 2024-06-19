package recursion.hard;

import java.util.ArrayList;
import java.util.List;

public class r1 {
    public static void main(String[] args) {
        String s="aab";
        System.out.println(partition(s));

    }
    public static List<List<String>> partition(String s) {
        List<List<String>> ans= new ArrayList<>();
        partitionHelper(s,0,ans,new ArrayList<String >() );
        return ans;

    }
    public  static  void partitionHelper(String s,int start, List<List<String>> ans,List<String> arr)
    {
       if(start==s.length())
       {
           ans.add(new ArrayList<>(arr));
           return;
       }
       for(int i=start;i<s.length();i++)
       {
           String currentSubstring=s.substring(start,i+1);
           if(isPalindrome(currentSubstring))
           {
               arr.add(currentSubstring);
               partitionHelper(s,i+1,ans,arr);
               arr.remove(arr.size()-1);
           }
       }

    }
    public static boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        String reversedString = sb.toString();
        return s.equals(reversedString);
    }
}
