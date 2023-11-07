import java.util.ArrayList;
import java.util.Arrays;

public class longestSubArray {

    public static void main(String[] args) {
        int [] arr={1,2,3,1,1,1,1};

        System.out.println( longestSubarrayWithSumK(arr,3));

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

}
