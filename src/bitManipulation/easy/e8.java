package bitManipulation.easy;

import java.util.ArrayList;
import java.util.List;

public class e8 {
    public static void main(String[] args) {
        System.out.println(get(5,6));

    }
    static List<Integer> get(int a, int b)
    {
       a=a ^ b;
       b=a ^ b;
       a=a ^ b;
        List<Integer> result = new ArrayList<>();
        result.add(a);
        result.add(b);
        return result;
    }
}
