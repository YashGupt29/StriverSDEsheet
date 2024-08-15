package dailychallenge;

public class potd1 {
    public static void main(String[] args) {
        int [] nums={0,1,0,1,1,0,0};
        System.out.println(minSwaps(nums));
    }

    public static int minSwaps(int[] nums)
    {
        int totalones=0;
        int maxOnesInWindow=Integer.MIN_VALUE;
        int n=nums.length;
        int [] extendedNums= new int[2 * n];
        for (int i = 0; i < n; i++) {
            if(nums[i]==1)
            {
                totalones+=1;
            }
        }
        for (int i = 0; i < n; i++) {
            extendedNums[i]=nums[i];
            extendedNums[i+n]=nums[i];
        }
        int ones=0;
        for (int i = 0; i < totalones ; i++) {
            if(extendedNums[i]==1)
            {
                ones+=1;
            }
        }
        for (int i = totalones; i < 2 * n ; i++) {
            if(extendedNums[i]==1) ones+=1;
            if(extendedNums[i-totalones]==1) ones--;
            maxOnesInWindow=Math.max(maxOnesInWindow,ones);
        }
        return totalones-maxOnesInWindow;
    }

}
