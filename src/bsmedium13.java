public class bsmedium13 {
    public static void main(String[] args) {
        int[] arr1 = {2,3,4,5,6,7};
        int[] arr2 = {6 ,7 ,9 ,9, 10 };
        System.out.println(kthElement(arr1,arr2,6,5,11));

    }
    public static long kthElement( int [] arr1, int [] arr2, int n, int m, int k) {
        if(n>m)
        {
            return kthElement(arr2,arr1,m,n,k);
        }
        int first=Math.max(0,k-m);
        int last=Math.min(n,k);
        while(first<=last)
        {
            int mid1=first+(last-first)/2;
            int mid2=k-mid1;
            int l1= mid1==0?Integer.MIN_VALUE:arr1[mid1-1];
            int l2= mid2==0?Integer.MIN_VALUE:arr2[mid2-1];
            int r1= mid1<n?arr1[mid1]:Integer.MAX_VALUE;
            int r2= mid2<m?arr2[mid2]:Integer.MAX_VALUE;
            if(l1<=r2 && l2<=r1)
            {
                return Math.max(l1,l2);
            }
            else if(l1>r2) {
                last=mid1-1;

            }
            else {
                first=mid1+1;

            }

        }
        return 0;
            }
}
