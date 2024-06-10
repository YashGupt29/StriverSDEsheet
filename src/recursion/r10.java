package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class r10 {
    public static void main(String[] args) {
        int [] arr={1,1,1,2,2};
                System.out.println(combinationSum2(arr,4));

    }
    public static List<List<Integer>> combinationSum2(int[] candidates, int target)
    {
        Arrays.sort(candidates);
        List<List<Integer>> ans=new ArrayList<>();
        combinationSumHelper(candidates,target,0,ans,new ArrayList<>());
        return  ans;
    }
    public static void combinationSumHelper(int [] cands,int target,int index,List<List<Integer>> ans,List<Integer> arr)
    {
            if(target==0)
            {
                ans.add(new ArrayList <>(arr) );
                return;
            }
        for (int i = index; i < cands.length ; i++)
        {
            if(i>index && cands[i]==cands[i-1]) continue;
            if (cands[i] > target) break;

            arr.add(cands[i]);
            combinationSumHelper(cands,target-cands[i],i+1,ans,arr);
            arr.remove(arr.size()-1);
        }

    }
}
