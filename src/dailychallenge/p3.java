package dailychallenge;

import java.util.*;

public class p3 {
    public static void main(String[] args) {
        int [] arr={1,0,1,0,1,1,0,0,1,0,1,1,0,0,0,1,1,0,1,0};
        int k=1;
        System.out.println(minChanges(arr,k));

    }
    public static int minChanges(int[] nums, int k) {
        int min=Integer.MAX_VALUE;
        int n=nums.length;
        int [] diff=new int[k+1];
        int [] maxdiff=new int [n/2];
        for (int i = 0; i <n/2 ; i++)
        {
            int a=nums[i];
            int b=nums[n-i-1];
            int difference=Math.abs(nums[i]-nums[n-i-1]);
            int maxDifference=Math.max(Math.max(a,b),k-Math.min(a,b));
            diff[difference]++;
            maxdiff[i]=maxDifference;
        }
        Arrays.sort(maxdiff);
        for (int i=0;i<diff.length;i++)
        {
            int rest=n/2-diff[i];
            int greater=lower_bound(maxdiff,i);
            min=Math.min(min,rest+greater);
        }
        return min;

    }
    public static  int lower_bound(int [] arr,int i)
    {
        int start=0;
        int last=arr.length-1;
        while(start<=last)
        {
            int mid=(start+last)/2;
            if(i>arr[mid])
            {
                start=mid+1;

            }
            else {
                last=mid-1;
            }
        }
        return start;

    }


}
