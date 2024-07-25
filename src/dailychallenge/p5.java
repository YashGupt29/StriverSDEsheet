package dailychallenge;

import java.util.Arrays;
import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

public class p5 {
    public static void main(String[] args) {
        String [] names={"Mary","John","Emma"};
        int [] heigth={180,165,170};
        System.out.println(Arrays.toString(sortPeople(names, heigth)));

    }
    public static String[] sortPeople(String[] names, int[] heights) {
       String [] hash=new String[9999];
       String [] ans=new String[heights.length];
        for (int i = 0; i < heights.length; i++) {
            hash[heights[i]]=names[i];
        }
        Arrays.sort(heights);
        int index=0;
        for (int i = heights.length-1; i >= 0 ; i--) {
            ans[index++]=hash[heights[i]];
        }
        return ans;
    }

}
