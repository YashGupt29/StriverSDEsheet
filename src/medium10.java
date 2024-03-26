import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class medium10 {
    public static void main(String[] args) {
        int [] nums={1,2,0,1};
        System.out.println(longestConsecutive(nums));

    }
    public static int longestConsecutive(int[] nums) {
        int n=nums.length;
        if(n==0)
        {
            return 0;
        }
        int longest=1;
        Set<Integer> set=new HashSet<>();
        for (int i = 0; i <nums.length ; i++) {
            set.add(nums[i]);

        }
        for(int it:set)
        {
            if(!set.contains(it-1))
            {
                int cnt=1;
                int x=it;
                while(set.contains(x+1))
                {
                    x=x+1;
                    cnt=cnt+1;
                }
                longest=Math.max(longest,cnt);
            }
        }
        return longest;
    }
    public static int longestConsecutives(int[] nums) {
        Arrays.sort(nums);
        int length=1;
        int maxLength=1;
        for (int i = 0; i <nums.length-1 ; i++) {
            if(nums[i]+1==nums[i+1])
            {
                length+=1;
                maxLength=Math.max(maxLength,length);

            }
            else if (nums[i] != nums[i + 1]) {
                length = 1;
            }

        }
        if(nums.length==0 || nums.length==1)
        {
            return nums.length;
        }
        return maxLength;

    }
}
