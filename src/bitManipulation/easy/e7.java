package bitManipulation.easy;

public class e7 {
    public static void main(String[] args) {
        System.out.println(setBit(15));

    }
    public static int setBit(int n) {
        return n | n+1;
    }
}
