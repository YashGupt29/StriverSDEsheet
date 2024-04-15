public class bs4 {
    public static void main(String[] args) {
        int[] arr = {1,3,5,6};
        int  x = 7;
        int ind = searchInsert(arr,  x);
        System.out.println("The lower bound is the index: " + ind);

    }
    public static  int searchInsert(int[] nums, int target)
    {
        int first=0;
        int last=nums.length-1;
        int ans=nums.length;
        while(first<=last)
        {
            int mid=first +(last-first)/2;
            if(nums[mid]>=target)
            {
                ans=mid;
                last=mid-1;
            }
            else {
                first=mid+1;
            }
        }
        return ans;

    }
}
