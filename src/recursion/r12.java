package recursion;

import java.util.ArrayList;
import java.util.List;

public class r12 {
    public static void main(String[] args) {
        int [] arr={1,2,2};
        System.out.println(subsetsWithDup(arr));

    }
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        susbsetsHelper(0,ans,new ArrayList<>(),nums);
        return ans;


    }
    public  static void  susbsetsHelper(int index,List<List<Integer>> ans,List<Integer> arr,int [] nums)
    {
        ans.add(new ArrayList<>(arr) );
        for (int i = index; i <nums.length; i++) {
            if(i>index && nums[i]==nums[i-1]) continue;
            arr.add(nums[i]);
            susbsetsHelper(i+1,ans,arr,nums);
            arr.remove(arr.size()-1);
        }


    }
}
