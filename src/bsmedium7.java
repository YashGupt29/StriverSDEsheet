public class bsmedium7 {
    public static void main(String[] args) {
        int [] arr={2,3,4,7,11};
        System.out.println(findKthPositive(arr,5));
    }
    public static int findKthPositive(int[] arr, int k) {
        int first=0;
        int last=arr.length-1;
        while(first<=last)
        {
            int mid=first+(last-first)/2;
            if((arr[mid]-(mid+1))<k)
            {
                first=mid+1;
            }
            else{
                last=mid-1;
            }
        }
        return k+last+1;

    }

}
