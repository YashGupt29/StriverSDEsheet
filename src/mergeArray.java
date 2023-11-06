import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class mergeArray {
    public static void main(String[] args)
    {
        int [] a={3 ,3 ,4 ,5 ,6, 7, 8, 9, 9, 9 };
        int [] b={2, 4, 10, 10 };
        System.out.println(sortedArray2(a,b));

    }
    public static List < Integer > sortedArray(int []a, int []b) {
        ArrayList<Integer> list=new ArrayList<>();
        int left= 0;
        int right=a.length-1;
        int low=0;
        int high=b.length-1;
        while(left<=right && low<=high)
        {
            if(a[left]<b[low])
            {
                if(!list.contains(a[left])) {
                    list.add(a[left]);
                }
                left++;
            }
             else if(a[left]==b[low])
            {
                if(!list.contains(a[left]))
                {
                    list.add(a[left]);
                }
                left++;
                low++;
            }
            else {
                if(!list.contains(b[low])) {
                list.add(b[low]);}
                low++;

            }
        }
        while(left<=right)
        {
            if(!list.contains(a[left])) {
                list.add(a[left]);
            }
            left++;
        }
        while(low<=high)
        {
            if(!list.contains(b[low])) {
                list.add(b[low]);
            }  low++;
        }
        return  list;
    }
    public static List < Integer > sortedArray1(int []a, int []b)
    {
        HashMap<Integer,Integer > mp=new HashMap<>();
        ArrayList<Integer> list=new ArrayList<>();
        for(int i=0;i<a.length;i++)
        {
            mp.put(a[i],mp.getOrDefault(a[i],0)+1);
        }
        for(int i=0;i<b.length;i++)
        {
            mp.put(b[i],mp.getOrDefault(b[i],0)+1);
        }
        for(int it :mp.keySet())
        {
            list.add(it);
        }
        return  list;
    }
    public static List < Integer > sortedArray2(int []a, int []b)
    {
        ArrayList<Integer> list=new ArrayList<>();
        HashSet<Integer> mp=new HashSet<>();
        for(int i=0;i<a.length;i++)
        {
            mp.add(a[i]);
        }
        for(int i=0;i<b.length;i++)
        {
            mp.add(b[i]);
        }
        for(int it:mp)
        {
            list.add(it);

        }
        return list;
    }
}
