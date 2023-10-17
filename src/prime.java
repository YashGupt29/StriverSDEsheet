public class prime {
    public static void main(String[] args) {
        System.out.println(isPrime(5));

    }
    public static boolean isPrime(int num) {
        int count=0;
        for(int i=1;i<=num;i++)
        {
            if(num%i==0)
            {
                count++;
            }

        }
        if(count==2)
        {
            return  true;
        }
        return  false;
    }
}
