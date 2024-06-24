package bitManipulation.easy;

public class e3 {
    public static void main(String[] args) {
        System.out.println(oddEven(2));

    }
    public static String oddEven(int n)
    {
        return (n & 1)==0?"even":"odd";

    }
}
