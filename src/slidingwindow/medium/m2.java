package slidingwindow.medium;

public class m2 {
    public static void main(String[] args) {
        int [] arr={0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
        System.out.println(longestOnes(arr,3));

    }
    public static int longestOnes(int[] nums, int k) {
        int maxLength=0;
        int zerocount=0;
        int i=0;
        int j=0;
        while(j<nums.length)
        {
            if(nums[j]==0)
            {
                zerocount++;
            }
            while(zerocount>k)
            {
                if(nums[i]==0)
                {
                    zerocount--;
                }
                i++;
            }
            maxLength=Math.max(maxLength,j-i+1);
            j++;
        }
        return maxLength;
    }
}
