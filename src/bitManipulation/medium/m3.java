package bitManipulation.medium;

import java.util.ArrayList;
import java.util.List;

public class m3 {
    public static void main(String[] args) {
        int [] arr={1,2,3};
        System.out.println(subsets(arr));

    }
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        for (int i = 0; i < (1<<nums.length ); i++) {
            List<Integer> arr= new ArrayList<>();
            for (int j = 0; j < nums.length ; j++) {
                if( (i & (1<<j))!=0)
                {
                    arr.add(nums[j]);
                }
            }
            ans.add(arr);
            
        }
        return ans;

    }
}
