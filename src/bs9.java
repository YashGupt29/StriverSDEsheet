public class bs9 {
    public static void main(String[] args) {
        int nums []={1,0,1,1};
        System.out.println(search(nums,0));

    }

    public static  boolean search(int[] nums, int target) {
        int first = 0;
        int last = nums.length - 1;
        while (first <= last) {
            while (first < last && nums[first] == nums[last]) {
                first++;
            }
            int mid = first + (last - first) / 2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[first] < nums[mid]) {
                if (nums[first] <=target && target <=nums[mid]) {
                    last = mid - 1;
                } else {
                    first = mid + 1;
                }
            } else {
                if (nums[mid] <= target && target <= nums[last]) {
                    first = mid + 1;
                } else {
                    last = mid - 1;
                }
            }


        }
        return false;
    }
}


