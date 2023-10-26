import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class highestLowestFreq {
    public static void main(String[] args) {
        int [] arr= {1,
                2, 2, 5, 6, 7, 11, 13, 13, 17, 17, 18, 18, 19

        };
        System.out.println(Arrays.toString(getFrequencies(arr)));
    }
    public static int [] getFrequencies(int []v) {
        int maxEle=0;
        int minEle=0;
        int maxFre=0;
        int minFre=Integer.MAX_VALUE;
        HashMap <Integer,Integer> mp=new HashMap<>();
        for(int i=0;i<v.length;i++)
        {
            int key=v[i];
            int freq=0;
            if(mp.containsKey(key))
            {
                freq=mp.get(key);
            }
            freq++;
            mp.put(key,freq);
        }
        for(Map.Entry<Integer,Integer> it: mp.entrySet())
        {
            int count=it.getValue();
            int element= it.getKey();
            if(count>maxFre || (count==maxFre && element<maxEle))
            {

                maxFre=count;
                maxEle=element;
            }
            if(count < minFre || (count == minFre && element < minEle))
            {

                minEle=element;
                minFre=count;
            }
        }
        return new int[]{maxEle,minEle};

    }
}
