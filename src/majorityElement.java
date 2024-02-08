import java.util.HashMap;
import java.util.Map;

public class majorityElement {
    public static void main(String[] args) {
        int[] arr = {2, 1, 1, 1, 1,1, 3, 3};
        int ans = majorityOptimized(arr);
        System.out.println("The majority element is: " + ans);

    }
    //Moore's voting algorithm
    public static int majorityElements(int []v)
    {
        int n=v.length;
        HashMap<Integer,Integer> mp=new HashMap<>();
        for(int i=0;i<v.length;i++)
        {
            int value=mp.getOrDefault(v[i],0);
            mp.put(v[i],value+1);
        }
        for(Map.Entry<Integer,Integer> it:mp.entrySet())
        {
            if(it.getValue()>n/2)
            {
                return it.getKey();
            }
        }
        return -1;
    }
    public  static  int majorityOptimized(int []v){
        int n=v.length;
        int count=0;
        int el=0;
        for(int i=0;i<n;i++)
        {
            if(count==0)
            {
                el=v[i];
                count=1;
            }
            else if (el==v[i])
            {
                count++;
            }
            else
            {
                count--;
            }
        }
        int cnt=0;
        for(int i=0;i<n;i++)
        {
            if(v[i]==el) cnt++;
        }
       if(cnt>n/2)  return el;
       return -1;
    }
}
