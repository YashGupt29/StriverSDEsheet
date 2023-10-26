import java.util.Arrays;

public class maximumFreq {
    public static void main(String[] args) {
        int[] nums = { 3,9,6};
        int k = 5; // Set the value of k
        System.out.println(maxFrequency(nums, k)); // Call the maxFrequency method
    }

    public static  int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums); // Sort the array in ascending order
        int n = nums.length;
        int left = 0; // Left pointer for the sliding window
        long sum = 0; // Sum of elements in the current window
        int maxFreq = 0; // Maximum frequency of an element

        for (int right = 0; right < n; right++) {
            // Add the difference between the current and previous element to the sum
            sum += nums[right];

            // Calculate the cost to make all elements in the current window equal to nums[right]
            // This cost is equal to (nums[right] * (right - left + 1) - sum)
            // If the cost is greater than k, we need to move the left pointer to decrease the cost
            //formula for [4,4,4] -[1,2,4]
            while (nums[right] * (right - left + 1) - sum > k) {
                sum -= nums[left]; // Decrement the left element
                left++; // Move the left pointer to the right
            }

            // Update the maximum frequency
            maxFreq = Math.max(maxFreq, right - left + 1);
            //return nums.lenght-left
        }

        return maxFreq;
    }


}
