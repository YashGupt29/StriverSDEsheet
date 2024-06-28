package slidingwindow.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class m3 {
    public static void main(String[] args) {
        int [] arr={3,3,3,1,2,1,1,2,3,3,4};
        System.out.println(totalFruits(3,arr));

    }
    public static int totalFruits(int N, int[] fruits) {
        HashMap<Integer,Integer> bucket=new HashMap<>();
        int maxFruits=0;
        int i=0;
        int j=0;
        while(j<fruits.length)
        {
              if(bucket.containsKey(fruits[j]))
              {
                 bucket.put(fruits[j],bucket.get(fruits[j])+1);
              }else {
                  bucket.put(fruits[j],1);
              }
              while(bucket.size()>2)
                {
                   bucket.put(fruits[i],bucket.get(fruits[i])-1);
                   if(bucket.get(fruits[i])==0)
                   {
                       bucket.remove(fruits[i]);
                   }
                    i++;
                }

            maxFruits=Math.max(maxFruits,j-i+1);
            j++;
        }
        return maxFruits;
    }
}
