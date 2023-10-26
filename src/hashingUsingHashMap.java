import java.util.HashMap;
import java.util.Map;

public class hashingUsingHashMap {
    public static void main(String[] args) {
        int [] arr={2,1, 2, 3, 1, 3, 2, 12};
        int q=12;

        HashMap<Integer,Integer> mp=new  HashMap<>();
        for (int key : arr) //iterating
        {
            int freq = 0;
            if (mp.containsKey(key)) {
                freq = mp.get(key);//getting current freq
            }
            freq++;//updating freq
            mp.put(key,freq);//update

        }
        //iterating over Map
        for (Map.Entry<Integer, Integer> it : mp.entrySet()) {
            System.out.println(it.getKey() + "->" + it.getValue());
        }
        if(mp.containsKey(q)) System.out.println(mp.get(q));
    }
}
