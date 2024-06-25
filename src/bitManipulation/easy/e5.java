package bitManipulation.easy;

public class e5 {
    public static void main(String[] args) {
        System.out.println(countSetBitsBrute(4));

    }
    public static int countSetBitsBrute(int n){
        int count=0;
        while(n!=0)
        {
            count=count+countOnes(n);
            n--;
        }
        return count;
    }
    public  static int  countOnes(int n)
    {
        int count=0;
        while(n!=0)
        {
            count++;
            n=n & n-1;
        }
        return count;

    }
}
