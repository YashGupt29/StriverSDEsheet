import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class bsmedium10 {
    public static void main(String[] args) {
        int[] arr = {7,2,5,10,8};
        int k=2;
        System.out.println(splitArray(arr,k));


    }
    public  static  int splitArray(int[] arr, int k) {
        int first = Collections.max(Arrays.asList(Arrays.stream(arr).boxed().toArray(Integer[]::new)));
        int last=findSum(arr);
        while(first<=last)
        {
            int mid=first +(last-first)/2;
            if(calculateMaxSum(arr,k,mid))
            {
                last=mid-1;

            }
            else {
                first=mid+1;

            }

        }
        return first;



    }
    public static  boolean calculateMaxSum(int [] arr,int k,int mid)
    {
        int sum=0;
        int count=1;
        for (int j : arr) {
            if (sum + j <=mid) {
                sum += j;
            } else {
                count += 1;
                sum = j;
            }

        }
        return count <=k;
    }
    public static int findSum(int [] arr)
    {
        int sum=0;
        for(int num:arr)
        {
            sum+=num;
        }
        return sum;
    }
}
