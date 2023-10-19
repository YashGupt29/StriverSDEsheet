public class addNumRec {
    public static void main(String[] args) {
        sumAll(3,0);

    }

    public static  void sumAll(long i,long sum) {
        if(i==0)
        {
            System.out.println(sum);
            return;
        }
        sumAll(i-1,sum+i);

    }
}
