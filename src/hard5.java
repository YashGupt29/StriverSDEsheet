import java.util.HashMap;

public class hard5 {
    public static void main(String[] args) {
        int [] arr={1,-1,0,0,2};
        System.out.println(getLongestZeroSumSubarrayLength(arr));

    }


    public static int getLongestZeroSumSubarrayLength(int []arr)
    {
        HashMap<Long,Integer> mp= new HashMap<>();
        long sum=0;
        int maxLen=0;
        for (int i = 0; i <arr.length ; i++)
        {
            sum=sum+arr[i];
            if(sum==0)
            {
                maxLen=Math.max(maxLen,i+1);
            }
            long rem=sum;
            if(mp.containsKey(rem))
            {
                int len=i-mp.get(rem);
                maxLen=Math.max(maxLen,len);
            }
            if(!mp.containsKey(rem))
            {
                mp.put(rem,i);
            }

        }
        return maxLen;


    }
//    public static int getLongestZeroSumSubarrayLength(int []arr)
//    {
//        int left=0,right=0,sum=0,maxLength=0;
//       while(right<arr.length)
//       {
//           sum+=arr[right];
//           while(sum>0)
//           {
//               sum-=arr[left];
//               left++;
//           }
//           if(sum==0)
//           {
//               maxLength=Math.max(maxLength,right-left+1);
//           }
//           right++;
//       }
//       return maxLength;
//    }


}
