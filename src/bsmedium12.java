public class bsmedium12 {
    public static void main(String[] args) {
        int [] arr1 = {1, 2};
        int [] arr2 = {3, 4};
        System.out.println(findMedianSortedArrays(arr1, arr2));  // Output should be 2.5
    }

    public static double findMedianSortedArrays(int[] arr1, int[] arr2) {
        int n1 = arr1.length;
        int n2 = arr2.length;

        // Ensure the first array is the smaller array
        if (n1 > n2) {
            return findMedianSortedArrays(arr2, arr1);
        }

        int first = 0;
        int last = n1;

        while (first <= last) {
            int mid1 = first + (last - first) / 2;
            int mid2 = (n1 + n2 + 1) / 2 - mid1;

            int l1 = (mid1 == 0) ? Integer.MIN_VALUE : arr1[mid1 - 1];
            int r1 = (mid1 >= n1) ? Integer.MAX_VALUE : arr1[mid1];

            int l2 = (mid2 == 0) ? Integer.MIN_VALUE : arr2[mid2 - 1];
            int r2 = (mid2 >= n2) ? Integer.MAX_VALUE : arr2[mid2];

            if (l1 <= r2 && l2 <= r1) {
                if ((n1 + n2) % 2 == 0) {
                    return (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
                } else {
                    return Math.max(l1, l2);
                }
            } else if (l1 > r2) {
                last = mid1 - 1;
            } else {
                first = mid1 + 1;
            }
        }

        throw new IllegalArgumentException("Input arrays are not sorted or have other issues.");
    }
}
