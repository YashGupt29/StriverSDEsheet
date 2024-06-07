package recursion;

public class r3 {
    public static void main(String[] args) {
        System.out.println(countGoodNumbers(50));

    }
    static final int MOD = (int) 1e9 + 7;

    public static int countGoodNumbers(long n) {
        long even=n/2;
        long odd=n-even;
        return (int)((pow(5,odd,MOD)*pow(4,even,MOD)%MOD));

    }
    public static long pow(long base,long n,int mod )
    {
        if(n==0)
        {
            return 1;
        }
        if(n%2==0)
        {
            long power=pow(base,n/2,mod);
            return (power*power)%mod;

        }
        else {
            long power=pow(base,n-1,mod);
            return ((power*power)%mod *base)%mod;
        }
    }
}
