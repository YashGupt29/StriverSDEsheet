import java.util.Arrays;

public class moveZeroe {
    public static void main(String[] args)
    {
        int [] arr={0,1,0,3,12,0,3};
        moveZeroes(arr);

    }
    public static void moveZeroes(int[] nums) {
        int [] arr=new int[nums.length];
        int count=0;
        for(int i=0;i<nums.length;i++)
        {

            if(nums[i]!=0)
            {
                arr[count]=nums[i];
                count++;
            }
        }
        for(int i=0;i<nums.length;i++)
        {
            nums[i]=arr[i];
        }
        System.out.println(Arrays.toString(nums));

    }
}
