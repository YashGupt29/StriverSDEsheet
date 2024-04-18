public class bs10 {
    public static void main(String[] args) {
        int nums []={35 ,43, 45, 1, 2, 9 ,12, 13, 19, 20, 26, 28, 29 ,32};
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
                if(nums[first]<min && min<nums[mid])
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
