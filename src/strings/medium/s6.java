package strings.medium;

import java.util.Collections;

public class s6 {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));

    }
    public static  String longestPalindrome(String s)
    {
        StringBuilder longest=new StringBuilder();
        int maxLength=0;
        for (int i = 0; i <s.length() ; i++) {
            String oddPalindrome=expandAroundCenter(s,i,i);
            String evenPalindrome=expandAroundCenter(s,i,i+1);
            if(oddPalindrome.length()>maxLength)
            {
                longest.setLength(0);
                longest.append(oddPalindrome);
                maxLength=oddPalindrome.length();
            }
            if(evenPalindrome.length()>maxLength)
            {
                longest.setLength(0);
                longest.append(evenPalindrome);
                maxLength=evenPalindrome.length();
            }
        }
        return longest.toString();

    }
    public static  String expandAroundCenter(String s,int left,int right)
    {
        while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right))
        {
            left--;
            right++;
        }
        return s.substring(left+1,right);

    }


    public  String longestPalindromeBrute(String s) {
        if(s.length()==1)
        {
            return s;
        }
        String longest="";
        String sub="";
        int length=0,maxlength=0;
        for (int i = 0; i <s.length() ; i++) {
            for (int j = i+1; j <=s.length() ; j++) {


                sub = s.substring(i, j);
                if (checkPalindrome(sub)) {
                    if (sub.length() > maxlength) {
                        maxlength = sub.length();
                        longest = sub;
                    }

                }
            }

        }
        return longest;

    }
    public static  boolean checkPalindrome(String s)
    {
        StringBuilder rev= new StringBuilder();
        for (int i = 0; i <s.length() ; i++) {
            rev.insert(0, s.charAt(i));

        }
        return rev.toString().equals(s);


    }

}
