package slidingwindow.medium;

public class m5 {
    public static void main(String[] args) {
        int [] arr={0,0,0,0,0};
        int goal=0;
        System.out.println(numSubarraysWithSum(arr,goal));

    }
    public static int numSubarraysWithSum(int[] nums, int goal)
    {
        int x= Helper(nums,goal);
        int y=Helper(nums,goal-1);
        return x-y;
    }

    public static int Helper(int[] nums, int goal) {
        if(goal<0) return 0;
        int i=0;
        int j=0;
        int cnt=0,sum=0;
        while(j<nums.length)
        {
            sum=sum+nums[j];
            while (sum>goal)
            {
                sum=sum-nums[i];
                i++;
            }
           cnt=cnt+j-i+1;
            j++;
        }
        return cnt;
    }
}
