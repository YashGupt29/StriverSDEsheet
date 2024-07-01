package slidingwindow.medium;

import java.util.HashMap;

public class m5 {
    public static void main(String[] args) {
        int[] nums = generateLargeArray(1000000); // Generate a large test array
        int goal = 2;

        long startTime = System.currentTimeMillis();
        int resultSliding = numSubarraysWithSumSliding(nums, goal);
        long endTime = System.currentTimeMillis();
        System.out.println("Sliding Window Result: " + resultSliding + " Time: " + (endTime - startTime) + " ms");

        startTime = System.currentTimeMillis();
        int resultPrefixSum = numSubarraysWithSum(nums, goal);
        endTime = System.currentTimeMillis();
        System.out.println("Prefix Sum with Hash Map Result: " + resultPrefixSum + " Time: " + (endTime - startTime) + " ms");
    }
    private static int[] generateLargeArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = (int) (Math.random() * 2); // Binary array
        }
        return array;
    }
    public static int numSubarraysWithSumSliding(int[] nums, int goal)
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
    public static int numSubarraysWithSum(int[] nums, int goal)
    {
        HashMap<Integer,Integer> mpp=new HashMap<>();
        int preSum=0;
        int cnt=0;
        mpp.put(0,1);
        for (int i = 0; i <nums.length ; i++)
        {
            preSum+=nums[i];
            if(mpp.containsKey(preSum-goal))
            {
                cnt+=mpp.get(preSum-goal);
            }
            mpp.put(preSum,mpp.getOrDefault(preSum,0)+1);
        }

        return cnt;
    }
}
