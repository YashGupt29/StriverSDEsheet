public class mediumbs1 {
    public static void main(String[] args) {
        System.out.println(sqrtN(2));

    }
    public static int sqrtN(long n) {
        if(n==1) return 1;
        int first=0;
        int last= (int) (n/2);
        int found=-1;
        while(first<=last)
        {
            int mid=first+(last-first)/2;
            if((long) mid *mid==n || (n> (long) mid *mid && n< (long) (mid + 1) *(mid+1)) )
            {
                return mid;
            }
            if((long) mid *mid<n)
            {
                first=mid+1;
            }
            else {
                last=mid-1;
            }
        }
        return -1;
    }
}
