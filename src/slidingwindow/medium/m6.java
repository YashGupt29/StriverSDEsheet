package slidingwindow.medium;

public class m6 {
    public static void main(String[] args) {

        int [] arr={2,2,2,1,2,2,1,2,2,2};
        int x=numberOfSubarrays(arr,2);
        int y=numberOfSubarrays(arr,1);
        System.out.println(x);
        System.out.println(x-y);

    }
    public static int numberOfSubarrays(int[] nums, int k) {
        int i=0;
        int j=0;
        int count=0;
        int  noOfOdd=0;
        while(j<nums.length)
        {
            if((nums[j] & 1)==1)
            {
                noOfOdd++;
            }
            while(noOfOdd>k)
            {
                if((nums[i] & 1)==1)
                {
                    noOfOdd--;
                }
                i++;
            }
            count=count+j-i+1;
            j++;
        }
        return count;
    }
}
