
public class Main {
    public static void main(String[] args) {
        int rev=reverse(1463847412);
        System.out.println(rev);

    }
    public static  int reverse(int x)
    {
        int rem;int rev=0;
        while(x!=0)
        {
            rem=x%10;


            if(rev<=Integer.MIN_VALUE/10 || rev>=Integer.MAX_VALUE/10) {
                return  0;
            }
            rev = rev * 10 + rem;
            x = x / 10;
        }
        return rev;
    }
}