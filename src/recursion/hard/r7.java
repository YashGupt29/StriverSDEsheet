package recursion.hard;

import java.util.ArrayList;
import java.util.List;

public class r7 {
    public static void main(String[] args) {
        String s="105";
        System.out.println(addOperators(s,6));

    }
    public static  List<String> addOperators(String num, int target) {
        List<String> ans= new ArrayList<>();
        if(num == null || num.length() == 0) return ans;
        helper(ans,num,target,"",0,0,0);
        return ans;

    }
    public static void helper(List<String> ans,String num,int target,String s,int pos,long prev,long res)
    {
        if(pos==num.length())
        {
            if(target==res)
            {
                ans.add(s);
            }
            return;
        }

        for(int i=pos;i<num.length();i++)
        {
            if(i>pos && num.charAt(pos)=='0') break;
            Long curr=Long.parseLong(num.substring(pos,i+1));
            if(pos==0)
            {
                helper(ans,num,target,s+curr,i+1,curr,res+curr);
            }
            else {

                helper(ans,num,target,s+"+"+curr,i+1,curr,res+curr);
                helper(ans,num,target,s+"-"+curr,i+1,-curr,res-curr);
                helper(ans,num,target,s+"*"+curr,i+1,prev*curr,(res-prev)+(prev*curr));
            }

        }

    }
}
