package Linkedin;

import java.util.ArrayList;
import java.util.Arrays;

public class c14 {
    public static void main(String[] args) {
    String [] s={"vml", "uds", "aih", "du", "vml", "uds"};//practice
        ArrayList<String> list = new ArrayList<>(Arrays.asList(s));
        System.out.println(shortestDistance(list,"vml","uds"));
    }
    public static int shortestDistance(ArrayList<String> s, String word1, String word2) {
        int lastPosword1=-1;
        int lastPosword2=-1;
        int min=Integer.MAX_VALUE;
        for (int i = 0; i < s.size(); i++) {
            if(s.get(i).equals(word1))
            {
                lastPosword1=i;
                if(lastPosword2!=-1)
                {
                    min=Math.min(min,Math.abs(lastPosword1-lastPosword2));
                }
            }
            if(s.get(i).equals(word2))
            {
                lastPosword2=i;
                if(lastPosword1!=-1)
                {
                    min=Math.min(min,Math.abs(lastPosword1-lastPosword2));
                }
            }
        }
        return min;
    }
}
