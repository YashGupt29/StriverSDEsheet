import java.util.Arrays;

public class rotateArray {
    public static void main(String[] args) {
        int [] arr={1,2,3,4,5,6,7};
        rotate(arr,3);

    }
    public  static  void rotate(int[] nums, int k) {
        //A[i] == B[(i+x) % A.length]
        int [] arr =new int[nums.length];
        for(int i=0;i<nums.length;i++)
        {
            arr[(i+k)%nums.length]=nums[i];
        }
        for(int i=0;i<nums.length;i++)
        {
            nums[i]=arr[i];
        }
        System.out.println(Arrays.toString(nums));

    }
}
