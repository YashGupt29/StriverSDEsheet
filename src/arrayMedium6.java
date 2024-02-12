import java.util.ArrayList;
import java.util.Arrays;

public class arrayMedium6 {
    public static void main(String[] args) {
    int nums[]={3,1,-2,-5,2,-4};
        System.out.println(Arrays.toString(rearrangeArray(nums)));
    }
    public static int[] rearrangeArray(int[] nums)
    {
        ArrayList<Integer> positive=new ArrayList<>();
        ArrayList<Integer> negative=new ArrayList<>();
        for(int num : nums) {
            if(num > 0) {
                positive.add(num);
            } else {
                negative.add(num);
            }
        }
        for(int i=0;i< positive.size();i++)
        {
            nums[2*i]= positive.get(i);
            nums[2*i+1]= negative.get(i);
        }
        return nums;


    }
}
