package dailychallenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class q2 {
    public static void main(String[] args) {
        int [] arr={1,3,-1,-3,5,3,6,7};
        int k=3;
        System.out.println(Arrays.toString(maxSlidingWindow(arr, k)));
    }
    public static  int [] maxSlidingWindow(int[] nums, int k) {
        int i=0;
        int j=0;
        List<Integer> arr=new ArrayList<>();
        while(j<nums.length)
        {
            while(k<=0)
            {
                i++;
                k++;
            }
            if(k==1)
            {
                arr.add(findMax(nums,i,j));
            }

            j++;
            k--;
        }
        int [] ans=new int[arr.size()];
        for (int l = 0; l <arr.size() ; l++) {
            ans[l]=arr.get(l);

        }
        return ans;
    }
    public static  int findMax(int [] nums, int i, int j)
    {
        int max=Integer.MIN_VALUE;
        for (int k = i; k <=j ; k++) {
            max=Math.max(max,nums[k]);
        }
        return max;
    }


}
