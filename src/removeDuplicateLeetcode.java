import java.util.ArrayList;

public class removeDuplicateLeetcode {
    public static void main(String[] args) {
        int[] nums ={0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicates(nums));

    }
    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int uniqueElements = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] != nums[i + 1]) {
                nums[uniqueElements] = nums[i];
                uniqueElements++;
            }
        }

        nums[uniqueElements] = nums[nums.length - 1];
        uniqueElements++;

        return uniqueElements;
    }

}
