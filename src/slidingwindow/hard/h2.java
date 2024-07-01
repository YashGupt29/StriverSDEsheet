package slidingwindow.hard;

import java.util.HashMap;

public class h2 {
    public static void main(String[] args) {
        int arr[]={1,2,1,2,3};
        System.out.println(subarraysWithKDistinct(arr,3)-subarraysWithKDistinct(arr,2));

    }
    public static int subarraysWithKDistinct(int[] nums, int k) {
        HashMap<Integer,Integer> mpp=new HashMap<>();
        int i=0;
        int j=0;
        int count=0;
        while(j<nums.length)
        {
            mpp.put(nums[j],mpp.getOrDefault(nums[j],0)+1);
            while(mpp.size()>k)
            {
                mpp.put(nums[i],mpp.get(nums[i])-1);
                if(mpp.get(nums[i])==0)
                {
                    mpp.remove(nums[i]);
                }

               i++;
            }
            count+=j-i+1;
            j++;
        }
        return count;
    }
}
