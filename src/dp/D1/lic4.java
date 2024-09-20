package dp.D1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class lic4 {
    public static void main(String[] args) {
        int [] arr={1,2,4,8};
        System.out.println(largestDivisibleSubset(arr));
    }
    public static List<Integer> largestDivisibleSubset(int[] arr) {
       int n=arr.length;
       int [] dp=new int[n];
       int [] hash=new int[n];
       int maxi=1;
       int lastIndex=-1;
       Arrays.fill(dp,1);
        for (int index= 0; index < n; index++) {
            hash[index]=index;
            for (int prev = 0; prev <=index-1; prev++) {
                if(arr[index] % arr[prev]==0 && 1+ dp[prev]>dp[index])
                {
                    dp[index]=1 +dp[prev];
                    hash[index]=prev;
                }
            }
            if(dp[index]>maxi)
            {
                maxi=dp[index];
                lastIndex=index;
            }
        }
        ArrayList<Integer> temp=new ArrayList<>();
        ArrayList<Integer> ans=new ArrayList<>();
        temp.add(arr[lastIndex]);
        while(hash[lastIndex]!=lastIndex)
        {
            lastIndex=hash[lastIndex];
            temp.add(arr[lastIndex]);
        }
        for (int i = temp.size()-1; i >=0 ; i--) {
            ans.add(temp.get(i));
        }
        return ans;
    }
}
