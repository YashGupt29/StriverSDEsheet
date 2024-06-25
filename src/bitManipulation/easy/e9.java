package bitManipulation.easy;

public class e9 {
    public static void main(String[] args) {

        System.out.println(divide(-2147483648
                ,-1));
    }

    public static int divide(int dividend, int divisor) {

        if (dividend == divisor) return 1;

        boolean sign = true;
        if (dividend < 0 && divisor >= 0) sign = false;
        if (dividend >= 0 && divisor < 0) sign = false;

        long n = Math.abs((long) dividend);
        long d = Math.abs((long) divisor);
        long ans = 0;

        while (n >= d) {
            int count = 0;
            while (n >= (d * (1L << (count + 1)))) { // Use long for shifting
                count++;
            }
            ans += (1L << count);
            n -= (d * (1L << count));
        }

        if (ans >= (1L << 31) && !sign) return Integer.MIN_VALUE; // Handle overflow for negative
        if (ans >= (1L << 31) && sign) return Integer.MAX_VALUE; // Handle overflow for positive

        return sign ? (int) ans : -1 * (int) ans;
    }
    public static int divideNaive(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor==-1) {
            return Integer.MAX_VALUE;
        }
        if(dividend==Integer.MAX_VALUE)
        {
            return  Integer.MAX_VALUE;
        }

            return dividend/divisor;

    }
}
