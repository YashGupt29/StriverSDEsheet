package dp.D1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class lic3 {
    public static void main(String[] args) {
        int [] arr={5,8,3,7,9,1};
        System.out.println(longestSubsequence(arr.length,arr));
    }
    public static int longestSubsequences(int n, int a[]) {
        int [] dp=new int [n+1];
        int maxi=1;
        Arrays.fill(dp,1);
        for (int index = 0; index < n; index++) {
            for (int prev = 0; prev <=index-1; prev++) {
                if(a[index]>a[prev] && 1+ dp[prev]>dp[index])
                {
                    dp[index]=1 + dp[prev];
                }
            }
            maxi=Math.max(maxi,dp[index]);
        }
        return maxi;
    }
    public static int longestSubsequence(int n, int[] a) {
        List<Integer> arr=new ArrayList<>();
        arr.add(a[0]);
        for (int i = 0; i < n-1; i++) {
            if(a[i+1]>arr.getLast())
            {
                arr.add(a[i+1]);
            }
            else {
                int index=lowerBound(arr,a[i+1]);
                arr.set(index,a[i+1]);
            }
        }
        return arr.size();
    }
    public static int lowerBound(List<Integer> arr, int num) {
        int first = 0;
        int last = arr.size();

        while (first < last) {
            int mid = (first + last) / 2;
            if (arr.get(mid) < num) {
                first = mid + 1;
            } else {
                last = mid;
            }
        }
        return first;
    }
}
