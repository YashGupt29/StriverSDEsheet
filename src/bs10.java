public class bs10 {
    public static void main(String[] args) {
        int nums []={5,1,2,3,4};
        System.out.println(findMin(nums));

    }
    public static  int findMin(int[] nums) {
        int first=0;
        int min=Integer.MAX_VALUE;
        int last=nums.length-1;
        while(first<=last)
        {
            int mid=first+(last-first)/2;
            if(nums[mid]<min)
            {
                min=nums[mid];
            }
            if(nums[first]<=nums[mid])
            {
                if(nums[first]<min && min<nums[last])
                {
                    last=mid-1;
                }
                else {
                    first=mid+1;
                }
            }
            else {
                if(nums[mid]<min && min<nums[last])
                {
                    first=mid+1;
                }
                else {
                    last=mid-1;
                }
            }
        }
        return min;

    }
}
