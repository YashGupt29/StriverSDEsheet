import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class findFreq {
    public static void main(String[] args) {
        int[] arr ={11,14,8,3,12,14,1,7,4,3};
        System.out.println(Arrays.toString(countFrequency(10, 14, arr)));

    }
    public static int[] countFrequency(int n, int x, int []nums){
        int [] arr=new int[x+1];
        HashMap<Integer,Integer> mp=new HashMap<>();
        for(int i=0;i<n;i++)
        {
            int key=nums[i];
            int freq=0;
            if(mp.containsKey(key))
            {
                freq= mp.getOrDefault(key, 0);
            }
            freq++;
            mp.put(key,freq);

        }
        for(int i=0;i<x;i++)
        {
           arr[i]= mp.getOrDefault(i + 1, 0);
        }
        return arr;


    }
}
