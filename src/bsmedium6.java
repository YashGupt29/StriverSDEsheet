public class bsmedium6 {
    public static void main(String[] args) {
        int [] arr={10,50,100,100,50,100,100,100};
        System.out.println(shipWithinDays(arr,5));

    }
    public static int shipWithinDays(int[] weights, int days) {
        int first=maxElement(weights);
        int last=sumArray(weights);
        while(first<=last)
        {
            int mid=first+(last-first)/2;
            if(findDays(weights,mid)<=days)
            {
                last=mid-1;
            }
            else {
                first=mid+1;
            }

        }
        return first;

    }
    public  static int sumArray(int [] arr)
    {

        int sum = 0;

        // Loop through the array and accumulate the sum
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }
    public static int maxElement(int [] v)
    {
        int maxi = Integer.MIN_VALUE;;
        int n = v.length;
        //find the maximum:
        for (int i = 0; i < n; i++) {
            maxi = Math.max(maxi, v[i]);
        }
        return maxi;
    }
    public static  int findDays(int [] arr,int mid)
    {
        int day=1,load=0;
        for (int i = 0; i <arr.length ; i++) {
            if(load+arr[i]>mid)
            {
                day+=1;
                load=arr[i];
            }
            else {
                load+=arr[i];
            }
        }
        return day;

    }
}
