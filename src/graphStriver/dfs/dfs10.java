package graphStriver.dfs;

import java.util.*;

public class dfs10 {
    public static void main(String[] args) {
        String s="hit";
        String t="cog";
        String [] arr={"hot","dot","dog","lot","log","cog"};
        List<String> ans = new ArrayList<>(Arrays.asList(arr));
        System.out.println(ladderLength(s,t,ans));
    }
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> words = new HashSet<>(wordList);
        Queue<Pair<String , Integer>> queue= new LinkedList<>();
        queue.add(new Pair<>(beginWord,1));
        while(!queue.isEmpty())
        {
            Pair<String,Integer> curr= queue.poll();
            String oldWord=curr.first;
            int level= curr.second;
            if(oldWord.equals(endWord))
            {
               return level;
            }
            for (int i = 0; i < oldWord.length(); i++) {
                char [] c=oldWord.toCharArray();
                for (int j = 'a'; j <='z'; j++) {
                  c[i]=(char)(j);
                  String word=new String(c);
                  if(words.contains(word))
                  {
                      words.remove(oldWord);
                      queue.add(new Pair<>(word,level+1));
                  }
                }
            }
        }
        return 0;

    }
    static class Pair<F,S>
    {
        F first;
        S second;
        Pair(F first, S second)
        {
            this.first=first;
            this.second=second;
        }
    }
}
