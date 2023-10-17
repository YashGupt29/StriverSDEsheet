public class Palindrome {
    public static void main (String args[]) {

        System.out.println(palindromeNumber(51415));
        if(palindromeNumber(51415))
        {

            System.out.println("yes palindrome");
        }
        else {
        System.out.println("not palindrome ");}
    }
    public static boolean palindromeNumber(int n){
        int num=n;
        int rev=0;
        // Write your code here.
        while(n>0){
            int rem=n%10;
            rev=rev*10+rem;
            n=n/10;

        }

        return rev == num;

    }
}
