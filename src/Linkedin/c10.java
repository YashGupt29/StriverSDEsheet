package Linkedin;

public class c10 {
    public static void main(String[] args) {
        long [] a={10,5,2,6};
        int n=a.length;
        long k=100;
        System.out.println(countSubArrayProductLessThanK(a,n,k));
    }
    public static long countSubArrayProductLessThanK(long a[], int n, long k)
    {
        //sliding window appraoch
        int i=0;//windowOpen
        int j=0;//windowClose
        long count=0;
        long product=1;
        while(i<n && j<n)
        {
            product=product * a[j];
            while (i<=j  && product >=k )
            {
                product=product/a[i];
                i++;
            }
            count+=(j-i) + 1;
            j++;
        }
        return count;
    }
}
