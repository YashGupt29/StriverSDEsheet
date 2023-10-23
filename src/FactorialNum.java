import java.util.ArrayList;
import java.util.Arrays;

public class FactorialNum {
    public static void main(String[] args) {
        int n = 7;
        System.out.println(checkFact(2));
    }

    static ArrayList<Integer> checkFact(int n) {
        ArrayList<Integer> list=new ArrayList<>();


        for (int i = 1; i <= n; i++) {
            int fact = factorial(i);
            if (fact <= n) {
                list.add(fact);
            }
        }

        return list;
    }

    static int factorial(int n) {
        if (n == 0) {
            return 1;
        }
        return n * factorial(n - 1);
    }
}
