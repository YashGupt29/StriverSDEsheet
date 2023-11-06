import java.util.HashMap;
import java.util.Map;

public class singleNumber {
    public static void main(String[] args) {
        int nums []={4,1,2,1,2};
        System.out.println(singleNumberFind(nums));

    }
    public static int singleNumberFind(int[] nums)
    {
        HashMap <Integer,Integer> mp=new HashMap<>();
        for(int i=0;i<nums.length;i++)
        {
            int key=nums[i];
            int freq=0;
            if(mp.containsKey(key))
            {
                freq=mp.get(key);
            }
            freq++;
            mp.put(key,freq);
        }
        for(Map.Entry<Integer,Integer> it:mp.entrySet())
        {
            if(it.getValue()==1)
            {
               return  it.getKey();

            }
        }
        return 0;


    }
}
