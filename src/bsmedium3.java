public class bsmedium3 {
    public static void main(String[] args) {
        int [] arr={805306368,805306368,805306368};
        System.out.println( minEatingSpeed(arr,1000000000));
    }
    public static int minEatingSpeed(int[] piles, int h) {
        int first=1;
        int last=maxElement(piles);
        int mid=0;
        while(first<=last)
        {
             mid=first+(last-first)/2;
            int totalhour=calculateTotalHours(piles,mid);
            if(totalhour<=h)
            {
                last=mid-1;
            }
            else {
                first=mid+1;
            }
        }
        return mid;

    }
    public static int calculateTotalHours(int[] v, int hourly) {
        int totalH = 0;
        int n = v.length;
        //find total hours:
        for (int i = 0; i < n; i++) {
            totalH +=  Math.ceil((double)(v[i]) / (double)(hourly));
        }
        return totalH;
    }
    public static int maxElement(int [] v)
    {
        int maxi = Integer.MIN_VALUE;;
        int n = v.length;
        //find the maximum:
        for (int i = 0; i < n; i++) {
            maxi = Math.max(maxi, v[i]);
        }
        return maxi;
    }

}
