import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class hard2 {
    public static void main(String[] args) {
        int [] nums = {2,1,3,4,1,5,6,1};
        System.out.println(majorityElement(nums));


    }
    public static  List<Integer> majorityElementTheekThak(int[] nums)
    {
        HashMap<Integer,Integer> mp=new HashMap<>();
        ArrayList<Integer> list=new ArrayList<>();

        int length=nums.length/3;
        for (int i = 0; i <nums.length ; i++)
        {
            int freq=0;
           if(mp.containsKey(nums[i]))
           {
               freq=mp.get(nums[i]);
           }
           freq++;
           mp.put(nums[i],freq);
        }
        for (Map.Entry<Integer, Integer> it : mp.entrySet()) {
//            System.out.println(it.getKey() + "->" + it.getValue());
            if(it.getValue()>length)
            {
                list.add(it.getKey());
            }
        }
        return list;

    }
    //Moore's voting algorithm
    public static  List<Integer> majorityElement(int[] nums)
    {
        ArrayList<Integer> list=new ArrayList<>();
        int cnt1=0,cnt2=0;
        int el1=Integer.MIN_VALUE;
        int el2=Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if(cnt1==0 && el2!=nums[i])
            {
                cnt1=1;
                el1=nums[i];
            }
            else if(cnt2==0 && el1!=nums[i])
            {
                cnt2=1;
                el2=nums[i];
            }
            else if(nums[i]==el1)
            {
                cnt1++;
            }
            else if(nums[i]==el2)
            {
                cnt2++;
            }
            else {
                cnt1--;
                cnt2--;
            }
        }
        cnt1=0;cnt2=0;
        for (int i = 0; i <nums.length ; i++) {
            if(nums[i]==el1)
            {
                cnt1++;
            }
            if(nums[i]==el2)
            {
                cnt2++;
            }
            
        }
        int mini=(nums.length/3)+1;
        if(cnt1>=mini) list.add(el1);
        if(cnt2>=mini) list.add(el2);
        return list;

    }

}
