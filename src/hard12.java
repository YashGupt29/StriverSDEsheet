public class hard12 {
    public static void main(String[] args) {
        int[] arr = {2,3,-2,4};
        long maxSum = maxProduct(arr);
        System.out.println("The maximum subarray sum is: " + maxSum);

    }
    public static long maxProduct(int[] nums) {
        long product=1;
        long max=Integer.MIN_VALUE;
        for (int i = 0; i <nums.length ; i++) {
            product=product*nums[i];
            if(product>max){
                max=product;
            }
            if(product<0)
            {
                product=0;
            }

        }
        return product;

    }
}
