package recursion;

import java.util.ArrayList;
import java.util.List;

public class r14 {
    public static void main(String[] args) {
        String s="";
        System.out.println(letterCombinations(s));

    }
    public static List<String> letterCombinations(String digits) {
        List<String> ans=new ArrayList<>();
        if(digits.isEmpty())
        {
            return ans;
        }
        String [] arr={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        letterCombinationHelper(0,arr,digits,ans,new StringBuilder());
        return  ans;



    }
    public  static  void letterCombinationHelper(int currentIndex,String [] arr,String digits,List<String> ans,StringBuilder comb)
    {
        if(currentIndex==digits.length())
        {
            ans.add(comb.toString());
            return;
        }
        int num=Character.getNumericValue(digits.charAt(currentIndex));
        String code=arr[num];
        for (int i = 0; i <code.length() ; i++) {
            char ch=code.charAt(i);
            comb.append(ch);
            letterCombinationHelper(currentIndex+1,arr,digits,ans,comb);
            comb.deleteCharAt(comb.length()-1);
        }

    }
}
