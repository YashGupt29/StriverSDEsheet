import java.util.Arrays;
import java.util.HashMap;

public class twoSum {
    public static void main(String[] args) {
        int book []={3,2,4};
        int n= book.length;
        int target=6;
        System.out.println(Arrays.toString(twoSum(book, target)));
    }
    public static String read(int n, int []book, int target){
        int sum=0;
        for(int i=0;i<book.length;i++)
        {
            for(int j=i+1;j<book.length;j++)
            {
                sum=sum+book[i]+book[j];
                if(sum==target)
                {
                    return "YES";

                }
                else{
                    sum=0;
                }
            }

        }
        return "NO";
    }
    public static  int[] twoSum(int[] nums, int target)
    {
        HashMap<Integer,Integer> num=new HashMap<>();
        for (int i = 0; i <nums.length ; i++) {
            int rem=target-nums[i];
            if(num.containsKey(rem))
            {
                return new int []{num.get(rem),i};
            }
            else {
                num.put(nums[i],i);
            }

        }
        return new int []{0,0};

    }
    public static  String reads(int n, int []book, int target)
    {
        Arrays.sort(book);
        int left=0;
        int right=book.length-1;
        int sum=0;
        while(left<right) {
            sum=book[left]+book[right];
            if (sum == target) {
                return "YES";
            }
            if (sum > target) {
                right--;
            }
            if (sum < target) {
                left++;
            }
        }

        return "NO";
    }


}
