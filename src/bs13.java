public class bs13 {
    public static void main(String[] args) {
        int [] nums={1,1,2};
        System.out.println(singleNonDuplicate(nums));

    }
    public static  int singleNonDuplicate(int[] nums) {
        if(nums.length==1) return nums[0] ;
        if(nums[0]!=nums[1])
        {
            return nums[0];
        }
        if(nums[nums.length-1]!=nums[nums.length-2])
        {
            return nums[nums.length-1];
        }
        int first=0;
        int last=nums.length-2;
        while(first<=last)
        {
            int mid=first+(last-first)/2;
            if(nums[mid]!=nums[mid-1] && nums[mid] !=nums[mid+1])
            {
                return nums[mid];
            }
            if((nums[mid]==nums[mid-1] && mid%2==0) || nums[mid]==nums[mid+1] && mid%2!=0)
            {
                last=mid-1;
            }
            else {
                first=mid+1;
            }
        }
        return -1;

    }
}
