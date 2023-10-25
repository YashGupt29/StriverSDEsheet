public class validPalindrome {
    public static void main(String[] args) {
        String  s="a";
        System.out.println(isPalindrome(0,s));

    }
    public static boolean isPalindrome(int i,String s) {
        s = s.toLowerCase().replaceAll("[^a-z0-9]", "");

        if(i>=s.length()/2)
        {
            return true;
        }
        if(s.charAt(i)!=s.charAt(s.length()-i-1))
        {
            return  false;
        }
        return isPalindrome(i+1,s);

    }


}
