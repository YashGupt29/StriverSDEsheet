package dailychallenge;

public class d1717 {
    public static void main(String[] args) {
        String s="aabbaaxybbaabb";
        System.out.println(maximumGain(s,5,4));
    }
    public static int maximumGain(String s, int x, int y) {
        return helper(s,x,y,'b','a');
    }
    public static int helper(String s, int x, int y, char max, char min) {
        if (x > y) {
            x = x ^ y;
            y = x ^ y;
            x = x ^ y;

            max ^= min;
            min ^= max;
            max ^= min;
        }

        int count = 0;
        StringBuilder sb = new StringBuilder(s);

        for (int i = 0; i < sb.length() - 1; ) {
            if (sb.charAt(i) == max && sb.charAt(i + 1) == min) {
                count += y;
                sb.delete(i, i + 2);
                if (i > 0) i--;
            } else {
                i++;
            }
        }

        for (int i = 0; i < sb.length() - 1; ) {
            if (sb.charAt(i) == min && sb.charAt(i + 1) == max) {
                count += x;
                sb.delete(i, i + 2);
                if (i > 0) i--;
            } else {
                i++;
            }
        }

        System.out.println(sb.toString());
        return count;
    }

}
