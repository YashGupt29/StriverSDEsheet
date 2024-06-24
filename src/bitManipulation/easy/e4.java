package bitManipulation.easy;

public class e4 {
    public static void main(String[] args) {

    }
    public boolean isPowerOfTwo(int n) {
        if(n<=0) return false;
        return (n & n-1)== 0;

    }
}
