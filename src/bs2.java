public class bs2 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3 ,3, 5};
        int n = 6, x = 2;
        int ind = lowerBound(arr, n, x);
        System.out.println("The lower bound is the index: " + ind);

    }
    public static int lowerBound(int []arr, int n, int x) {

        int first=0;
        int last=arr.length-1;
        int ans=n;
        while(first<=last)
        {
            int mid=first+(last-first)/2;
            if(arr[mid]>=x)
            {
                ans=mid;
                last=mid-1;

            }
            else {
                first=mid+1;
            }

        }
        return ans;
    }

}
