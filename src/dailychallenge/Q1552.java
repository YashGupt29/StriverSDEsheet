package dailychallenge;

import java.util.Arrays;

public class Q1552 {
    public static void main(String[] args) {
        int [] arr={1,2,3,4,5,6,7,8,9,10};
        System.out.println(maxDistance(arr,4));

    }
    public static int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int first=1;
        int last=position[position.length-1];
        int best = 0;

        while(first<=last)
        {
            int mid=(first+last)/2;
            if(check(mid,m,position))
            {

                best = mid;
                first=mid+1;
            }
            else {
                last=mid-1;
            }
        }
        return best;

    }
    public  static boolean check(int mid,int m,int [] arr)
    {
        int count=1;
        int sum=0;
        for (int i = 0; i < arr.length; i++) {
            if(sum+arr[i]<=mid)
            {
                sum+=arr[i];
            }
            else if(arr[i]<=mid) {
                count++;
                sum=arr[i];
            }
        }
        return count<m;
    }
}
