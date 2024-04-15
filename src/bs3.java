public class bs3 {
    public static void main(String[] args) {
        int[] arr = {1 ,4 ,7 ,8 ,10 };
        int n = 5 ,x = 7;
        int ind = upperBound(arr, n, x);
        System.out.println("The lower bound is the index: " + ind);
    }
    public static int upperBound(int []arr, int n, int x){
        int first=0;
        int last=arr.length-1;
        int ans=n;
        while(first<=last)
        {
            int mid=first+(last-first)/2;
            if(arr[mid]>x)
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
