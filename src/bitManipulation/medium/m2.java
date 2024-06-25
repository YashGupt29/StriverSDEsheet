package bitManipulation.medium;

import java.util.Arrays;

public class m2 {
    public static void main(String[] args) {
        int [] a={2,2,1};
        System.out.println(singleNumber(a));

    }
    public static int singleNumber(int[] nums) {
        int count=0;
        for (int i = 0; i <nums.length ; i++) {
            count=count ^ nums[i];
        }
        return count;

    }
}
