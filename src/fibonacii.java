public class fibonacii {
    public static void main(String[] args) {
    fiboPrint(8);

    }
    static  int fibo(int n)
    {
        if(n==1 || n==0)
        {
            return n;
        }
        int last=fibo(n-2);
        int first=fibo(n-1);
        return first+last;

    }
    static  void fiboPrint(int n)
    {
        for(int i=0;i<=n;i++)
        {
            System.out.print(fibo(i)+" ");
        }

    }
}
