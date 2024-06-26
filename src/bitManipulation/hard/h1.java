package bitManipulation.hard;

import java.util.Arrays;

public class h1 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(AllPrimeFactors(100)));

    }
    public static int[] AllPrimeFactors(int N)
    {
        int [] arr = new int[(int) Math.sqrt(N)];
        int j=0;
        for(int i=2;i<=N;i++)
        {
            if(N%i==0)
            {
                arr[j]=i;
                j++;
            }
            while(N % i==0)
            {
                N=N/i;
            }
        }
        int count=0;
        for (int i = 0; i < arr.length ; i++) {
           if(arr[i]!=0)
           {
               arr[count++]=arr[i];
           }
           else {
               break;
           }
        }
        return Arrays.copyOf(arr,count);
    }
}
