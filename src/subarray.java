import java.util.HashMap;

public class subarray {
    public static void main(String[] args) {
        int a []={ 1,2,1,0,1};
        int num=hashing(a,4);
        System.out.println(num);

    }
    static  int longestSubarrayWithSumK(int []nums, long k)
    {
        int left=0,right=0,maxLen=0,sum=nums[0];
        while(right<nums.length)
        {
            while(left<right && sum>k)
            {
                sum=sum-nums[left];
                left++;
            }
            if(sum==k)
            {
                maxLen=Math.max(maxLen,right-left+1);
            }
            right++;
            if(right<nums.length)
            {
                sum=sum+nums[right];
            }
        }
        return maxLen;
    }
    static int  hashing(int a[],long k)
    {
        HashMap <Long,Integer> preSumMap=new HashMap<>();
        long sum=0;
        int maxLen=0;
        for(int i=0;i<a.length;i++)
        {
            sum+=a[i];
           if(sum==k)
           {
               maxLen=Math.max(maxLen,i+1);
           }
           long rem=sum-k;
           if(preSumMap.containsKey(rem))
           {
               int len=i-preSumMap.get(rem);
               maxLen=Math.max(maxLen,len);
           }
           if(!preSumMap.containsKey(rem))
           {
               preSumMap.put(sum,i);
           }
        }
        return maxLen;
    }

    static int optimal(int[] a, int k) {
        int left = 0, right = 0, sum = 0, maxLength = 0;
        while (right < a.length) {
            sum += a[right];
            while (sum > k) {
                sum -= a[left];
                left++;
            }
            if (sum == k) {
                maxLength = Math.max(maxLength, right - left + 1);
            }
            right++;
        }
        return maxLength;
    }
}
