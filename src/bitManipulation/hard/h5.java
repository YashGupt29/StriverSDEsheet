package bitManipulation.hard;

public class h5 {
    public static void main(String[] args) {
        System.out.println(myPow(3.00000,10));

    }
    public static  double myPow(double x, int N) {
        long n=N;
        if(N<0)
        {
            n=-n;
            x=1/x;
        }
        double ans=1;
        double currentProduct=x;
        while(n>0)
        {
            if(n%2==1)
            {
                ans=ans * currentProduct;
            }
            currentProduct=currentProduct *currentProduct;
            n=n/2;
        }
        return ans;

    }
}
