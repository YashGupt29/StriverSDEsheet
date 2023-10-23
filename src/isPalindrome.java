public class isPalindrome {
    public static void main(String[] args) {
        System.out.println(checkPalindrome("yash"));

    }
    static boolean checkPalindrome(String word)
    {
        int p1=0;
        int p2=word.length()-1;
        while(p1<p2) {
            char ch_1 = word.charAt(p1);
            char ch_2 = word.charAt(p2);
            if(ch_1!=ch_2)
            {
                return  false;
            }
            p1++;
            p2--;
        }
        return true;
    }

}
