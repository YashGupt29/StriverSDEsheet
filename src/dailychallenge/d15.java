package dailychallenge;

import java.util.ArrayList;

public class d15 {
    public static void main(String[] args) {
        int [] arr={7,2,1};
        int target=2;
        System.out.println(subarraySum(arr,target));
    }
    static ArrayList<Integer> subarraySum(int[] arr, int target) {
        int n=arr.length;
        ArrayList<Integer> ans=new ArrayList<>();
        int i=0;
        int j=0;
        int currentSum=0;
        while(i<=j && j<n)
        {
            currentSum+=arr[j];
            while(currentSum>target && i<=j)
            {

                currentSum-=arr[i];
                i++;
            }
            if(currentSum==target)
            {
                ans.add(i+1);
                ans.add(j+1);
                return ans;
            }
            j++;
        }
        ans.add(-1);
        return ans;
    }
}
