package dailychallenge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class d241 {
    public static void main(String[] args) {
        String a="2-1-1";
        System.out.println(diffWaysToCompute(a));
    }
    private static HashMap<String ,List<Integer>> map=new HashMap<>();
    public static List<Integer> diffWaysToCompute(String expression) {
        if(map.containsKey(expression))
        {
            return map.get(expression);
        }
        List<Integer> ans=new ArrayList<>();
        for (int i = 0; i < expression.length(); i++) {
            char ch=expression.charAt(i);
            if(ch=='+' || ch=='-' || ch=='*')
            {
                List<Integer> leftResult=diffWaysToCompute(expression.substring(0,i));
                List<Integer> rightResult=diffWaysToCompute(expression.substring(i+1));
                for(int left:leftResult)
                {
                    for(int right:rightResult)
                    {
                        if(ch=='+')
                        {
                            ans.add(left+right);
                        }
                        if(ch=='-')
                        {
                            ans.add(left-right);
                        }
                        if(ch=='*')
                        {
                            ans.add(left * right);
                        }
                    }
                }
            }
        }
        if(ans.isEmpty())
        {
            ans.add(Integer.parseInt(expression));
        }
        map.put(expression,ans);
        return ans;
    }
}
