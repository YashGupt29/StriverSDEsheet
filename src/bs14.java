public class bs14 {
    public static void main(String[] args) {
        int [] nums={1,2,1,3,5,6,4};
        System.out.println(findPeakElement(nums));

    }
    public static int findPeakElement(int[] nums) {
        if(nums.length==1) return 0;
        if(nums[nums.length-1]>nums[nums.length-2]) return nums.length-1;
        if(nums[0]>nums[1]) return 0;

       int first=1;
       int last=nums.length-2;
       int peak=-1;
       while (first<=last)
       {
           int mid=first+(last-first)/2;
           if(nums[mid]>nums[mid+1] && nums[mid]>nums[mid-1])
           {
               peak=nums[mid];
           }
           if(nums[mid]>nums[mid-1] )
           {
               first=mid+1;
           }
           else {
               last=mid-1;
           }
       }
       return peak;

    }
}
