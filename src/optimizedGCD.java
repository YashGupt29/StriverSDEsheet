public class optimizedGCD {
    public static int calcGCD(int n, int m){
        // Write your code here.
        if(n==m)
        {
            return m;
        }
        int max=Math.max(n,m);
        int min=Math.min(n,m);
        int GCD=0;

        for(int i=1;i<=(max-min);i++)
        {
            if(n%i==0 && m%i==0)
            {
                GCD=i;
            }
        }
        return GCD;
    }
}