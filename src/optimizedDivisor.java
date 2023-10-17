public class optimizedDivisor {

    public static void main(String[] args) {
        int sum=sumOfAllDivisors(5);
        System.out.println(sum);
    }
    public static int sumOfAllDivisors(int n){
        int sum=0;
        for(int i=1;i<=n;i++)
        {
            sum += sumOfDivisors(i);
        }
        return sum;
    }

    public static int sumOfDivisors(int n)
    {
        int sum=0;
        for(int i=1;i<=(int)Math.sqrt(n);i++)
        {
          if(n%i==0) {
              sum+=i;
              if (n / i != i) {
                 sum+=n/i;
              }
          }
        }
        return sum;
    }
}

