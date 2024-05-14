public class kadaneAlgoSubAraaySum {
    public static void main(String[] args) {
        int[] arr = {0,3,4,7,10,9};
        int n = arr.length;
        long maxSum = maxSubarraySum(arr, n);
        System.out.println("The maximum subarray sum is: " + maxSum);

    }
    public static long maxSubarraySum(int[] arr, int n) {
         long sum=0;
        long max=Long.MIN_VALUE;
        for (int i = 0; i <n ; i++) {
            sum=sum+arr[i];
            if(sum>max){
                max=sum;
            }

            if(sum<0){
                sum=0;
            }



        }
        return max;
    }

}
