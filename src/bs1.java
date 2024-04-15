public class bs1 {
    public static void main(String[] args) {
        int [] nums={-1,0,3,5,9,12};
        int target=2;
        System.out.println(search(nums,target));

    }
    public static int search(int[] nums, int target) {
        int first=0;
        int last=nums.length-1;
        int mid=0;
        int found=-1;
        while(first<=last)
        {
             mid=first+(last-first)/2;

            if(target==nums[mid])
            {
                found=mid;
                return found;
            }
            if(target>nums[mid])
            {
                first=mid+1;
            }
            if (target<nums[mid])
            {
                last=mid-1;
            }

        }
        return found;

    }
}
