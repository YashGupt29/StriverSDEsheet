import java.util.Arrays;

public class bsmedium8 {
    public static void main(String[] args) {
        int [] arr={0, 3, 4, 7, 10, 9};
        System.out.println(aggressiveCows(arr,4));

    }
    public static int aggressiveCows(int []stalls, int k) {
        int n = stalls.length;
        Arrays.sort(stalls);
        int start=1;
        int last=stalls[n - 1];
        while(start<=last)
        {
            int mid=start+(last-start)/2;
            if(canWePlace(stalls, mid, k))
            {
                start=mid+1;

            }
            else {
                last=mid-1;
            }

        }
        return last;

    }
    public static boolean canWePlace(int [] stalls,int distance,int k)
    {
        int countCows=1;
        int last=stalls[0];
        for (int i = 1; i <stalls.length ; i++)
        {
            if(stalls[i]-last>=distance)
            {
                countCows+=1;
                last=stalls[i];
            }
            if(countCows>=k)
            {
                return true;
            }

        }
        return false;
    }
    public static int [] minMax(int [] arr)
    {
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        for (int i = 0; i <arr.length ; i++) {
            if(arr[i]>max)
            {
                max=arr[i];
            }
            if(arr[i]<min)
            {
                min=arr[i];
            }

        }
        return new int[]{min,max};
    }
}
