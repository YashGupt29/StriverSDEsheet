package dailychallenge;

public class p3028 {
    public static void main(String[] args) {
        int [] arr={3,2,-3,-4};
        System.out.println(returnToBoundaryCount(arr));
    }
    public static int returnToBoundaryCount(int[] nums) {
        int [] prefix=new int [nums.length];
        int sum=0;
        prefix[0]=nums[0];
        for(int i=1;i<nums.length;i++)
        {
           prefix[i]=prefix[i-1] + nums[i];
        }
        for (int i = 0; i < prefix.length ; i++) {
            if(prefix[i]==0)
            {
                sum+=1;
            }

        }

        return sum;
    }
}
