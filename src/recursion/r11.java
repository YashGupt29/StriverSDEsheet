package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class r11 {
    public static void main(String[] args) {
        Integer[] array = {5, 2, 1};
        List<Integer> list = Arrays.asList(array);
        ArrayList<Integer> arr = new ArrayList<>(list);
        System.out.println(subsetSums(arr,2));




    }
    public static ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int n)
    {
        ArrayList<Integer> ans=new ArrayList<>();
        subsetSumHelper(0,0,arr,ans);
        return ans;

    }
    public  static  void subsetSumHelper(int index,int sum,ArrayList<Integer> arr,ArrayList<Integer> ans)
    {
        if(index>=arr.size())
        {
            ans.add(sum);
            return;
        }
//        ans.add(arr.get(index));
        subsetSumHelper(index+1,sum+arr.get(index),arr,ans);
        subsetSumHelper(index+1,sum,arr,ans);
    }
}
