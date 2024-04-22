public class bsmedium5 {
    public static void main(String[] args) {
        int [] arr={44,22,33,11,1};
        System.out.println(smallestDivisor(arr,5));

    }
    public static int smallestDivisor(int[] nums, int threshold) {
        int first=1;
        int last=maxElement(nums);
        while(first<=last)
        {
            int mid=first+(last-first)/2;
            if(check(nums,mid,threshold))
            {
                last=mid-1;

            }
            else {
                first=mid+1;

            }
        }
        return first;

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
    public static  boolean check(int [] nums,int mid, int threshold)
    {
        int sum=0;
        for (int i = 0; i <nums.length ; i++) {
            sum+= (int) Math.ceil((double) nums[i] /mid);
        }
        return sum<=threshold;

    }

}
