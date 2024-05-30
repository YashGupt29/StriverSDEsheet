package strings.medium;

public class s4 {
    public static void main(String[] args) {
        String s = "2147483648";
        System.out.println(myAtoiOptimized(s));

    }

    public static int myAtoi(String s) {
        s = s.trim();
        if (s.isEmpty()) {
            return 0;
        }
        if(s.substring(1).startsWith("0"))
        {
            s = removeLeadingZeroes(s);

        }



        boolean isNegative = false;
        int startIndex = 0;

        if (s.length() > 0 && (s.charAt(0) == '-' || s.charAt(0) == '+')) {
            isNegative = s.charAt(0) == '-';
            startIndex = 1;
        }

        StringBuilder num = new StringBuilder();
        for (int i = startIndex; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                num.append(s.charAt(i));
            } else {
                break;
            }
        }

        if (num.length() == 0) {
            return 0;
        }

        String numstr = num.toString();
        String maxstr = String.valueOf(Integer.MAX_VALUE);
        String minstr = String.valueOf(Integer.MIN_VALUE).substring(1);

        if (numstr.length() > maxstr.length() ||
                (numstr.length() == maxstr.length() && numstr.compareTo(maxstr) > 0)) {
            return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        }

        if (isNegative && (numstr.length() > minstr.length() ||
                (numstr.length() == minstr.length() && numstr.compareTo(minstr) > 0))) {
            return Integer.MIN_VALUE;
        }

        long parsedNum = isNegative ? -Long.parseLong(numstr) : Long.parseLong(numstr);
        return (int) parsedNum;
    }

    public static String removeLeadingZeroes(String s) {
        s = s.trim();

        boolean isNegative = false;
        boolean isPositive=false;
        if (s.startsWith("-")) {
            isNegative = true;
            s = s.substring(1);
        } else if (s.startsWith("+")) {
            isPositive=true;
            s = s.substring(1);
        }

        s = s.replaceFirst("^0+", "");

        if (s.isEmpty()) {
            s = "0";
        }

        if (isNegative && !s.equals("0")) {
            s = "-" + s;
        }
        if((!isNegative && s.startsWith("-"))|| !isPositive && s.startsWith("+"))
        {
            return "";
        }


        return s;
    }
    public static int myAtoiOptimized(String s) {
        if (s.equals("")) {
            return 0;
        }

        int res = 0, i = 0, sign = 1;

        while (i < s.length() && s.charAt(i) == ' ') {
            i++;
        }

        if (i < s.length() && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            if (s.charAt(i++) == '-') {
                sign = -1;
            }
        }
        while (i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && s.charAt(i) - '0' > 7)) {
                if (sign == -1) {
                    return Integer.MIN_VALUE;
                }
                return Integer.MAX_VALUE;
            }

            res = res * 10 + (s.charAt(i++) - '0');
        }
        return sign * res;
    }

}
