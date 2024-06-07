package recursion;

public class r2 {
    public static void main(String[] args) {
        double x= 2.00000;
        System.out.println(myPow(x,10
        ));


    }
    public static double myPow(double x, int n) {
        if(n==0 )
        {
            return 1;
        }
        if(n<0)
        {
            n=-n;
            x=1/x;
        }
        return n%2==0?myPow(x*x,n/2):x*myPow(x*x,n/2);
    }
}
