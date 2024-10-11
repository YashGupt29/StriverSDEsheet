package dailychallenge;

import java.util.Stack;

public class d962 {
    public static void main(String[] args) {
    int [] arr={9,8,1,0,1,9,4,0,4,1};
        System.out.println(maxWidthRamp(arr));
    }
    public static int maxWidthRamp(int[] nums) {
        Stack<Integer> stack=new Stack<>();
        int n=nums.length;
        stack.push(0);
        for (int i = 1; i < nums.length; i++) {
            int element=stack.peek();
            if(nums[element]>nums[i])
            {
                stack.push(i);
            }
        }
        int max=Integer.MIN_VALUE;
        for (int j = n-1; j >=0; j--) {
            int i=stack.peek();
            while(!stack.isEmpty() && nums[j]>=nums[i])
            {
                max=Math.max(max,(j-i));
                stack.pop();
                if(stack.isEmpty())
                {
                    break;
                }
                i=stack.peek();
            }
            if(stack.isEmpty())
            {
                break;
            }
        }
        return max;
    }
}
