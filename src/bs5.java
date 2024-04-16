import java.util.Arrays;

public class bs5 {
    public static void main(String[] args) {
        int[] arr = {3, 4, 7, 8, 8, 10};
        int n = 6, x = 8;
        System.out.println(Arrays.toString(getFloorAndCeil(arr, n, x)));

    }
    public static int[] getFloorAndCeil(int[] a, int n, int x) {
        return new int[] {getFloor(a,x),getCeil(a,x)};

    }
    public static int getCeil(int []a,int x)
    {
        int first=0;
        int last=a.length-1;
        int ceil=-1;
        while(first<=last)
        {
            int mid=first+(last-first)/2;
            if(a[mid]>=x)
            {
                ceil=a[mid];
                last=mid-1;
            }
            else {
                first=mid+1;
            }

        }
        return ceil;


    }
    public static int getFloor(int [] a,int x)
    {
        int first=0;
        int last=a.length-1;
        int floor=-1;
        while(first<=last)
        {
            int mid=first+(last-first)/2;
            if(a[mid]<=x)
            {
                floor=a[mid];
                first=mid+1;
            }
            else {
                last=mid-1;
            }
        }
        return floor;
    }
}
