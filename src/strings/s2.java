package strings;

public class s2 {
    public static void main(String[] args) {
        String s="the sky is blue";
//        System.out.println(countSpaces(s));
        System.out.println(reverseWordsOptimized(s));

    }
    public static String reverseWords(String s) {
        String newString="";
        int start=0;
        for(int i=0;i<=s.length();i++)
        {
            if( i==s.length() ||s.charAt(i)==' ' )
            {
                String word=s.substring(start,i);
                newString=word+" "+newString;
                start=i+1;
            }
        }
        newString=newString.trim();
        String [] words=newString.split("\\s+");

        return String.join(" ",words);
    }
    public static String reverseWordsOptimized(String s) {
        StringBuilder newString=new StringBuilder ();
        s=s.trim();
        int start=0;
        int end=s.length()-1;

        for(int i=end;i>=start;i--)
        {
            if(s.charAt(i)==' ')
            {
                newString.append(s, i+1, end+1).append(" ");
                while(i>=start && s.charAt(i)==' ')
                {
                    i--;
                }
                end=i;
            }
        }
        newString.append(s, 0, end+1);
        return newString.toString();
    }

}
