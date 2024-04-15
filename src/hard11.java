import java.util.ArrayList;

public class hard11 {
    public static void main(String[] args) {
        int[] nums = {2147483647,2147483647,2147483647,2147483647,2147483647,2147483647};
        System.out.println(reversePairs(nums));

    }

    public static int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);

    }

    public static int mergeSort(int[] a, int left, int right) {
        int count = 0;
        if (left >= right) return count;
        if (left < right) {
            int mid = left + (right - left) / 2;
            count += mergeSort(a, left, mid);
            count += mergeSort(a, mid + 1, right);
            count += countInversion(a, left, mid, right);
            merge(a, left, mid, right);

        }
        return count;
    }

    public static int countInversion(int[] arr, int low, int mid, int high) {
        int count = 0;
        int j = mid + 1;
        for (int i = low; i <= mid; i++) {
            while (j <= high && arr[i] > 2 * arr[j]) {
                j++;
            }
            count += j - (mid + 1);

        }
        return count;

    }

    private static void merge(int[] arr, int low, int mid, int high) {
        ArrayList<Integer> temp = new ArrayList<>(); // temporary array
        int left = low;      // starting index of left half of arr
        int right = mid + 1;   // starting index of right half of arr

        //storing elements in the temporary array in a sorted manner//

        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp.add(arr[left]);
                left++;
            } else {
                temp.add(arr[right]);
                right++;
            }
        }

        // if elements on the left half are still left //

        while (left <= mid) {
            temp.add(arr[left]);
            left++;
        }

        //  if elements on the right half are still left //
        while (right <= high) {
            temp.add(arr[right]);
            right++;
        }

        // transfering all elements from temporary to arr //
        for (int i = low; i <= high; i++) {
            arr[i] = temp.get(i - low);
        }
    }
    class SolutionOptimized {
        public int reversePairs(int[] nums) {
            return mergeSort(nums, 0, nums.length - 1);
        }

        private int mergeSort(int[] arr, int low, int high) {
            if (low >= high) {
                return 0;
            }

            int mid = low + (high - low) / 2;
            int count = mergeSort(arr, low, mid) + mergeSort(arr, mid + 1, high);

            // Count reverse pairs
            int j = mid + 1;
            for (int i = low; i <= mid; i++) {
                while (j <= high && (long) arr[i] > 2 * (long) arr[j]) {
                    j++;
                }
                count += j - (mid + 1);
            }

            // Merge the sorted subarrays
            int[] temp = new int[high - low + 1];
            int left = low, right = mid + 1, idx = 0;
            while (left <= mid && right <= high) {
                if (arr[left] <= arr[right]) {
                    temp[idx++] = arr[left++];
                } else {
                    temp[idx++] = arr[right++];
                }
            }
            while (left <= mid) {
                temp[idx++] = arr[left++];
            }
            while (right <= high) {
                temp[idx++] = arr[right++];
            }
            for (int i = low; i <= high; i++) {
                arr[i] = temp[i - low];
            }

            return count;
        }
    }
}
