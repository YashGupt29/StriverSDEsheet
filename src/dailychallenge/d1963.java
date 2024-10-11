package dailychallenge;

import java.util.Stack;

public class d1963 {
    public static void main(String[] args) {
        String s="]]][[[";
        System.out.println(minSwaps(s));
    }
    public static int minSwaps(String s) {
        StringBuilder sb=new StringBuilder(s);
        int imbalanceCount=0;
        int count=0;
        Stack<Character> stack=new Stack<>();
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='[')
            {
               count++;
            } else if (count!=0 && sb.charAt(i)==']') {
              count--;
            }
            else {
                imbalanceCount++;
            }
        }
        return (imbalanceCount + 1)/2;
    }
}
