import java.util.*;

public class hard3 {
    public static void main(String[] args) {
        int nums []={-2,0,1,1,2};
        System.out.println(threeSumOptimized(nums));

    }
    public static  List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> st= new HashSet<>();
        for (int i = 0; i <nums.length ; i++) {
            Set<Integer> mp= new HashSet<>();
            for (int j = i+1; j <nums.length ; j++) {
                if(mp.contains(-(nums[i]+nums[j])))
                {
                    ArrayList<Integer> al= new ArrayList<>();
                    al.add(nums[i]);
                    al.add(nums[j]);
                    al.add(-(nums[i]+nums[j]));
                    al.sort(null);
                    st.add(al);
                }
                else {
                    mp.add(nums[j]);
                }
            }
        }
       List<List<Integer>> ans=new ArrayList<>(st);
        return ans;


    }
    public static  List<List<Integer>> threeSumOptimized(int[] nums) {
        List<List<Integer>> ans= new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i <nums.length ; i++) {
            if(i!=0 && nums[i]==nums[i-1]) continue;
            int j=i+1;
            int k=nums.length-1;
            while(j<k)
            {
                int sum=nums[i]+nums[j]+nums[k];
                if(sum<0)
                {
                    j++;
                }
                else if (sum>0)
                {
                    k--;
                }
                else {
                    List <Integer> list= new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    ans.add(list);
                    j++;
                    k--;

                    while(j<k && nums[j]==nums[j-1]) {
                        j++;
                    }
                    while(j<k && nums[k]==nums[k+1])
                    {
                        k--;
                    }
                }
            }

            
        }
        return ans;
    }
}
