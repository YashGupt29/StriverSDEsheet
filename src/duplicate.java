import java.util.HashMap;
import java.util.Map;

public class duplicate {
    public static void main(String[] args) {
        int [] nums={1,2,3,1};
        System.out.println(containsDuplicate(nums));

    }
    public static boolean containsDuplicate(int[] nums) {

        HashMap<Integer,Integer> mp=new HashMap<>();
        for (int i = 0; i <nums.length ; i++) {
            int freq=1;
            if(mp.containsKey(nums[i]))
            {
                freq=mp.get(nums[i])+1;
                if(freq>=2) return true;
            }
            mp.put(nums[i],freq);
        }
//        for(Map.Entry<Integer,Integer> it :mp.entrySet())
//        {
//            System.out.println(it.getKey()+"--->"+it.getValue());
//        }
        return false;


    }
}
