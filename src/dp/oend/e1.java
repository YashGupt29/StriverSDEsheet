package dp.oend;

import java.util.Map;

public class e1 {
    public static void main(String[] args) {
        System.out.println(climbStairs(3));

    }
    public static int climbStairs(int n) {
       return helper(n);
    }
    public static int helper(int n)
    {
        if(n==0) return 1;
        if(n==1) return 0;
        int left=helper(n-1);
        int right=helper(n-2);
        return left+right;
    }

}
