package bitManipulation.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class h4 {
    public static void main(String[] args) {
        System.out.println(findPrimeFactors(12246));

    }
    public static void sieveHelper(int [] prime,int n) {
        for (int i = 2; i * i <= n; i++) {
            if(prime[i]==1)
            {
                for (int j = i *i; j <=n ; j=j+i) {
                    prime[j]=0;
                }
            }
        }
    }

    public static List<Integer> findPrimeFactors(int n) {
       int []  prime=new int [n+1];
        Arrays.fill(prime,1);
        sieveHelper(prime,n);
        List<Integer> ans=new ArrayList<>();
        for (int i = 2; i <=n ; i++) {

            while(n % i==0)
            {
                if(prime[i]==1)
                {
                    ans.add(i);
                }
                n=n/i;
            }
            
        }
        return ans;
    }
}
