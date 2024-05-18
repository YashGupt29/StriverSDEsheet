package strings;

public class s2 {
    public static void main(String[] args) {
        String s="a good   example";
//        System.out.println(countSpaces(s));
        System.out.println(reverseWords(s));

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

}
