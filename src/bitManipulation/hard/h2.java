package bitManipulation.hard;

import java.util.ArrayList;
import java.util.List;

public class h2 {
    public static void main(String[] args) {
        print_divisors(20);

    }
    public static void print_divisors(int n) {
        List<Integer> ans=new ArrayList<>();

        for (int i = 1; i <= (int)(Math.sqrt(n)) ; i++) {
            if(n % i==0)
            {
                ans.add(i);
                if((i !=n/i))
                {
                    ans.add(n/i);
                }
            }

        }
        System.out.println(ans);

    }
}
