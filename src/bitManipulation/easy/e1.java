package bitManipulation.easy;

public class e1 {
    public static void main(String[] args) {
        bitManipulation(8,1);

    }
    public static void bitManipulation(int num, int i) {
        if((num & 1<<i-1)==0)
        {
            System.out.print("0 ");
        }
        else {
            System.out.print("1 ");
        }
        System.out.print((num | 1<<i-1)+" ");
        System.out.print((num & ~(1<<i-1)));

    }
}
