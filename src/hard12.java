public class hard12 {
    public static void main(String[] args) {
        int[] arr = {2,3,-2,4};
        long maxSum = maxProductOptimized(arr);
        System.out.println("The maximum subarray sum is: " + maxSum);

    }
    public static long maxProduct(int[] nums) {
        int p1=nums[0];
        int p2=nums[0];
        int result=nums[0];
        for (int i = 1; i <nums.length ; i++) {
            int temp=Math.max(nums[i],Math.max(p1*nums[i],p2*nums[i]));
            p2=Math.min(nums[i],Math.min(p1*nums[i],p2*nums[i]));
            p1=temp;
             result=Math.max(result,p1);

        }
        return result;

    }
    public static int maxProductOptimized(int [] nums)
    {
        int prefix=1;
        int suffix=1;
        int max=Integer.MIN_VALUE;
        for (int i = 0; i <nums.length ; i++) {
            if(prefix==0) {
                prefix=1;
            }
            if(suffix==0)
            {
                suffix=1;
            }
            prefix=prefix*nums[i];
            suffix=suffix*nums[nums.length-i-1];
            max=Math.max(max,Math.max(prefix,suffix));

        }
        return max;
    }
}
