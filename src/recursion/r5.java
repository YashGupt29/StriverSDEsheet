package recursion;

import java.util.ArrayList;
import java.util.List;

public class r5 {
    public static void main(String[] args) {
        System.out.println( subsets(new int []{1,2,2}));

    }
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> arr=new ArrayList<>();
         subsetHelper(nums,0,ans,arr);
         return ans;

    }
    public static  void subsetHelper(int [] nums,int index,List<List<Integer>> ans,List<Integer> arr)
    {
        if(index>=nums.length)
        {
            ans.add(new ArrayList<>(arr));
            return;
        }
        arr.add(nums[index]);
        subsetHelper(nums,index+1,ans,arr);
        arr.remove(arr.size()-1);
        subsetHelper(nums,index+1,ans,arr);
    }
}
