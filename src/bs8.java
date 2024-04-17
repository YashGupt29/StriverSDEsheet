import java.util.Arrays;

public class bs8 {
    public static void main(String[] args) {
        int[] arr={1,3};
        System.out.println(index(arr));
        System.out.println(search(arr,1));

    }
    public static int search(int[] nums, int target) {
        int index=index(nums);
        Arrays.sort(nums);
        return binarysearch(nums,target,index);

    }



    public static int binarysearch(int[] nums, int target,int index) {
        int first = 0;
        int last = nums.length - 1;
        int found = -1;
        while (first <= last) {
            int mid = first + (last - first) / 2;

            if (target == nums[mid]) {
                found = mid;
                return (found+index)%nums.length;

            }
            if (target > nums[mid]) {
                first = mid + 1;
            }
            if (target < nums[mid]) {
                last = mid - 1;
            }

        }
        return -1;


    }

    public  static int index(int [] nums)
    {
        int index=0;
        for (int i = 1; i <nums.length ; i++) {
            if(nums[i]<nums[i-1])
            {
                index=i;
            }
        }
        return index;

    }

}
