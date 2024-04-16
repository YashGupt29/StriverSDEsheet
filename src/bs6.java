import java.util.Arrays;

public class bs6 {
    public static void main(String[] args) {
        int arr[]={5,7,7,8,8,8,10};
        int target=8;
        System.out.println(Arrays.toString(searchRange(arr,target)));

    }
    public static int[] searchRange(int[] nums, int target) {
        return new int []{lowerBound(nums,nums.length,target),upperBound(nums,nums.length,target)};



    }
    public static int lowerBound(int []arr, int n, int x) {

        int first=0;
        int last=arr.length-1;
        int ans=-1;
        while(first<=last)
        {
            int mid=first+(last-first)/2;
            if(arr[mid]==x)
            {
                ans=mid;
            }
            if(arr[mid]>=x)
            {

                last=mid-1;

            }
            else {
                first=mid+1;
            }

        }
        return ans;
    }
    public static int upperBound(int []arr, int n, int x){
        int first=0;
        int last=arr.length-1;
        int ans=-1;
        while(first<=last)
        {
            int mid=first+(last-first)/2;
            if(arr[mid]==x)
            {
                ans=mid;
            }
            if(arr[mid]>x)
            {
                last=mid-1;
            }
            else {
                first=mid+1;
            }

        }
        return ans;
    }

}
