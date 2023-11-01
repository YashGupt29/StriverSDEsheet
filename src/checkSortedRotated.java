import java.util.Arrays;

public class checkSortedRotated {
    public static void main(String[] args) {
        int[] arr ={2,1,3,4};
        System.out.println(checkOptimized(arr));


    }
    public  static  boolean check(int[] nums)
    {
        if(nums.length==2)
        {
            return true;
        }
        if(isSorted(nums,0,nums.length-1))
        {
            return true;
        }
        else if(index(nums)>0)
        {
            int[] b =new int[nums.length];
            int x = nums.length-index(nums)-1;
            for(int i=0;i<nums.length;i++)
            {
//            A[i] == B[(i+x) % A.length]

               b[(i+x)%nums.length]=nums[i];

            }
            if(isSorted(b,0,b.length-1))
            {
                return true;
            }

        }
        if(index(nums)==0 &&   isSorted(nums,1,nums.length-1) && Arrays.stream(nums)
            .skip(1) // Skip the first element
            .allMatch(num -> nums[0] >= num))
        {
            return true;
        }
        return false;

    }
    public static  int index(int [] arr)
    {
        int pivotIndex;

        int low=1;
        int high=arr.length-1;
        while(low<high) {
            int pivot=arr[low];
            if (isSorted(arr, low+1, high) && (isSorted(arr,0,low)))
            {
                pivotIndex=low;
                return pivotIndex;
            }
            else {
                low++;
            }
        }
        return 0;

    }
    public static boolean isSorted(int [] arr,int low,int high)
    {
        boolean sort=true;
        for(int i=low;i<high;i++)
        {
            if(arr[i]>arr[i+1])
            {
                sort=false;
                break;
            }
        }
        return sort;
    }
    //optimised solution
    public  static  boolean checkOptimized(int[] nums) {
        int count = 0;

        for(int i = 0; i < nums.length-1; i++){
            if(nums[i] > nums[i+1])
                count++;
        }

        if(count == 0)
            return true;
        else if(count > 1)
            return false;
        else if(nums[0] >= nums[nums.length-1])
            return true;
        else
            return false;
    }
}




