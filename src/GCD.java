public class GCD {
    public static void main (String args[]) {
       int num= calcGCD(4,6);
        System.out.println(num);
    }

    public static int calcGCD(int n, int m) {
        int max=0;
        int GCD=0;
        for(int i=1;i<=Math.min(n,m);i++)
        {
          if(n%i==0 && m%i==0)
          {
              GCD=i;
          }
        }
        return GCD;

    }
}