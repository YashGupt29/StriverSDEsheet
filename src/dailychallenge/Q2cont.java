package dailychallenge;

public class Q2cont {
    public static void main(String[] args) {
        int l = 10086764;
        int r = 96508040;
        System.out.println(nonSpecialCount(l, r));
    }

    public static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static int nonSpecialCount(int start, int end) {
        int totalNumbers = end - start + 1;

        if (4 >= start && 4 <= end) {
            totalNumbers--;
        }

        int number = 3;
        while (true) {
            long square = (long) number * number;
            if (square > end) {
                break;
            }
            if (isPrime(number) && square >= start && square <= end) {
                totalNumbers--;
            }
            number += 2;
        }

        return totalNumbers;
    }
}
