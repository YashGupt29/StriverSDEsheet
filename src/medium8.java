import java.util.Arrays;

public class medium8 {
    public static void main(String[] args) {
        int[] num ={2,1,5,4,3,0,0};
        nextPermutation(num);

    }
    public static void nextPermutation(int[] nums) {
        int n=nums.length;
        int index=-1;
        for (int i = n-2; i >=0; i--) {
            if(nums[i]<nums[i+1])
            {
                index=i;
                break;
            }
        }
        if(index==-1)
        {
            Arrays.sort(nums);
            System.out.println(Arrays.toString(nums));
        }
        else {
            for (int i = n - 1; i >= index; i--) {
                if (nums[i] > nums[index]) {
                    swap(nums, index, i);
                    break;
                }
            }
            Arrays.sort(nums, index + 1, n );

            System.out.println(Arrays.toString(nums));
        }


    }
    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
