package strings;

import java.util.HashMap;

public class s5 {
    public static void main(String[] args) {
        String s="egg";
        String t="add";
        System.out.println(isIsomorphic(s,t));

    }
    public static boolean isIsomorphic(String s, String t)
    {
        if(s.length()!=t.length())
        {
            return false;
        }
        HashMap<Character,Character> maps=new HashMap<>();
        HashMap<Character,Character> mapt=new HashMap<>();
        for (int i = 0; i <s.length() ; i++) {
            char chars=s.charAt(i);
            char chart=t.charAt(i);
            if(maps.containsKey(chars))
            {
                if(maps.get(chars)!=chart)
                {
                    return false;
                }

            }
            else {
                maps.put(chars,chart);
            }
            if(mapt.containsKey(chart))
            {
                if(mapt.get(chart)!=chars)
                {
                    return false;
                }

            }
            else {
                mapt.put(chart,chars);
            }
        }
        return true;

    }

}
