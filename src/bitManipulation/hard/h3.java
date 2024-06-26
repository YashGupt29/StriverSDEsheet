package bitManipulation.hard;

import java.util.Arrays;

public class h3 {
    public static void main(String[] args) {
//        System.out.println(Arrays.toString(countPrimes(10)));
        System.out.println(countPrimes(10));

    }
    public static int countPrimes(int n) {
        int count=0;
        int [] prime=new int [n+1];
        Arrays.fill(prime, 1);

        for (int i = 2; i * i <= n; i++) {
            if(prime[i]==1)
            {
                for (int j = i *i; j <=n ; j=j+i) {
                    prime[j]=0;
                }
            }
        }

        for (int i = 2; i < n ; i++) {
            if(prime[i]==1)
            {
                count++;
            }

        }
        return count;

    }
    public static int countPrimesBrute(int n)
    {
        int cnt=0;
        n=n-1;
        while(n>=2)
        {
            if(isPrime(n))
            {
                cnt++;
            }
            n--;
        }
        return cnt;
    }
    public static boolean isPrime(int n) {
        if (n <= 1) return false;
        if (n <= 3) return true;

        if (n % 2 == 0 || n % 3 == 0) return false;

        for (int i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) return false;
        }

        return true;
    }
}
