import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class longestSubArray {

    public static void main(String[] args) {
        int [] arr={2,0,0,3};

        System.out.println( longestSubarrayWithSumKOptimal(arr,3));

    }
    public static int longestSubarrayWithSumK(int []a, long k)
    {

        int maxLength=0;
        for (int i = 0; i <a.length ; i++)
        {
            for (int j = 0; j <a.length ; j++)
            {     long sum=0;
                for (int l = i; l <= j ; l++)
                {
                    sum+=a[l];
                }
                if(sum==k)
                {
                    int length=j-i+1;
                    maxLength=Math.max(length,maxLength);
                    break;
                }
            }


        }
        return maxLength;

    }
    public static int longestSubarrayWithSumKOptimal(int []a, long k)
    {
        HashMap<Long,Integer> preSum=new HashMap<>();
        long sum=0;
        int maxLength=0;
        for (int i = 0; i < a.length; i++)
        {
            sum+=a[i];
            if(sum==k)
            {
                maxLength=Math.max(maxLength,i+1);
            }

            long rem=sum-k;
            if(preSum.containsKey(rem))
            {
              int length=i-preSum.get(rem);
              maxLength=Math.max(length,maxLength);
            }
            if(!preSum.containsKey(sum))
            {
                preSum.put(sum,i);
            }

        }
        return maxLength;

    }

}
