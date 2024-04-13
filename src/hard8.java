import java.util.Arrays;

public class hard8 {
    public static void main(String[] args) {
        int [] nums1={1,3,5,7,0,0,0,0,0};
        int [] nums2={0,2,6,8,9};
        merge(nums1,3,nums2,3);

    }
    public static  void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;

        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }

        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
        System.out.println(Arrays.toString(nums1));
    }
    public static  void mergeanother(int[] nums1, int m, int[] nums2, int n) {
        int i=m,j=0,k=0;
        while(i<m+n && j<n)
        {
            nums1[i]=nums2[j];
            i++;
            j++;
        }
        Arrays.sort(nums1);
        System.out.println(Arrays.toString(nums1));
    }
    }
