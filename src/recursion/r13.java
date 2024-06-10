package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class r13 {
    public static void main(String[] args) {
        int [] arr={1,2,3,4,5,6,7,8,9};
        System.out.println(combinationSum2(arr,9,3));

    }
    public static List<List<Integer>> combinationSum2(int[] candidates, int target,int k)
    {
        Arrays.sort(candidates);
        List<List<Integer>> ans=new ArrayList<>();
        combinationSumHelper(candidates,target,0,ans,new ArrayList<>(),k);
        return  ans;
    }
    public static void combinationSumHelper(int [] cands,int target,int index,List<List<Integer>> ans,List<Integer> arr,int k)
    {
        if(target==0 && arr.size()==k)
        {
            ans.add(new ArrayList <>(arr) );
            return;
        }
        for (int i = index; i < cands.length ; i++)
        {
            if(i>index && cands[i]==cands[i-1]) continue;
            if (cands[i] > target) break;
            if(arr.size()>k) break;


            arr.add(cands[i]);
            combinationSumHelper(cands,target-cands[i],i+1,ans,arr,k);
            arr.remove(arr.size()-1);
        }

    }
}
