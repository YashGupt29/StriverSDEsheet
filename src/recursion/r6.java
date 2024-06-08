package recursion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class r6 {
    public static void main(String[] args) {
        String s = "a";
        String s2="b";
        System.out.println(betterString(s,s2));
    }

    public static String betterString(String str1,String str2) {
        List<List<String>> ans = new ArrayList<>();
        Set<String> set = new HashSet<>();
        List<String> arr = new ArrayList<>();
        subsetHelper(str1, 0, ans, arr, set);
        List<List<String>> ans2 = new ArrayList<>();
        Set<String> set2 = new HashSet<>();
        List<String> arr2 = new ArrayList<>();
        subsetHelper(str2,0,ans2,arr2,set2);

        return ans.size()>=ans2.size()?str1:str2;
    }

    public static void subsetHelper(String s, int index, List<List<String>> ans, List<String> arr, Set<String> set) {
        if (index >= s.length()) {
            String subset = String.join("", arr);
            if (!set.contains(subset) && !arr.isEmpty()) {
                ans.add(new ArrayList<>(arr));
                set.add(subset);
            }
            return;
        }
        arr.add(s.charAt(index) + "");
        subsetHelper(s, index + 1, ans, arr, set);
        arr.remove(arr.size() - 1);
        subsetHelper(s, index + 1, ans, arr, set);
    }
}
