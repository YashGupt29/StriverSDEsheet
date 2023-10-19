public class addNumRec {
    public static void main(String[] args) {
        System.out.println(sumFirstN(3));

    }
    public static long sumFirstN(long n)
    {
        long sum=0;
        if(n==0){
            return 0;
        }
        sum=n+sumFirstN(n-1);;
        return sum;

    }
}
