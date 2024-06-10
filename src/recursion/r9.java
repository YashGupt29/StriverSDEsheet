package recursion;

import java.util.ArrayList;
import java.util.List;

public class r9 {
    public static void main(String[] args) {
        int [] arr={2,5,2,1,2};
        System.out.println(combinationSum(arr,5));

    }
    public static List<List<Integer>> combinationSum(int[] candidates, int target)
    {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> arr=new ArrayList<>();
        combinationSumHelper(candidates,target,ans,arr,0,0);
        return ans;
    }
    public static void combinationSumHelper(int [] cands,int target,List<List<Integer>> ans,List<Integer> arr,int index,int sum)
    {
        if(index>=cands.length)
        {
            if(sum==target)
            {
                ans.add(new ArrayList<>(arr));
            }

            return;
        }
        arr.add(cands[index]);
        if(sum+cands[index]<=target) {
            combinationSumHelper(cands, target, ans, arr, index, sum + cands[index]);
        }
        arr.remove(arr.size()-1);
        combinationSumHelper(cands,target,ans,arr,index+1,sum);

    }
}
