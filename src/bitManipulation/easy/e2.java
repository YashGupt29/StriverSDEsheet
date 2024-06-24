package bitManipulation.easy;

public class e2 {
    public static void main(String[] args) {
        System.out.println( checkKthBit(4,2));


    }
    public static boolean checkKthBit(int n, int k)
    {
        return !((n & 1<<k)==0);
    }
}
