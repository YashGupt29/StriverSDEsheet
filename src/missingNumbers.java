import java.util.Arrays;

public class missingNumbers {
    public static void main(String[] args)
    {
        int [] arr={3,0,1,2};
        System.out.println(missingNumber(arr));

    }
    public static int missingNumber(int[] nums) {
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++)
        {
            if(i!=nums[i])
            {
                return i;
            }
        }
        return nums.length;

    }
}
