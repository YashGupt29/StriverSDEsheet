public class mediumbs2 {
    public static void main(String[] args) {
        System.out.println(NthRoot(4,69));

    }
    public static int NthRoot(int n, int m) {
        if(m==1) return 1;
        int first=0;
        int last= (int) (m/2);
        int found=-1;
        while(first<=last)
        {
            int mid=first+(last-first)/2;
            if((long) Math.pow(mid,n)==m )
            {
                return mid;
            }
            if((long) Math.pow(mid,n)<m)
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
