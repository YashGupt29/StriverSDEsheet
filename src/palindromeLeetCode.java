public class palindromeLeetCode {
    public static void main (String args[]){
        System.out.println(isPalindrome(10));
    }
    public static  boolean isPalindrome(int x) {

        int num=x;
        int rev=0;
        while(x>0){
            int rem=x%10;
            rev=rev*10+rem;
            x=x/10;
        }
        System.out.println(rev);
        return rev == num;
    }
}
