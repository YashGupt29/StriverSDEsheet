package graphStriver.dfs;

import java.util.*;

public class dfs11 {
    public static void main(String[] args) {


    }
    public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> words=new HashSet<>(wordList);
        Queue<ArrayList<String>> queue=new LinkedList<>();
        ArrayList<String> arr=new ArrayList<>();
        arr.add(beginWord);
        queue.add(arr);
        ArrayList<String > usedOnLevel=new ArrayList<>();
        usedOnLevel.add(beginWord);
        int level=0;
        List<List<String>> ans=new ArrayList<>();
        while(!queue.isEmpty())
        {
            ArrayList<String> vec=queue.poll();
            if(vec.size()>level)
            {
                level++;
                for(String it:usedOnLevel)
                {
                    words.remove(it);
                }
            }
            String word=vec.getLast();
            if(word.equals(endWord))
            {
                if(ans.size()==0)
                {
                    ans.add(vec);
                }
                else if(ans.get(0).size()==vec.size())
                {
                    ans.add(vec);
                }
            }
            for (int i = 0; i < word.length(); i++) {
                char [] characterArray=word.toCharArray();
                for (char j = 'a'; j < 'z'; j++) {
                    characterArray[i]=j;
                    String newWord=new String(characterArray);
                    if(words.contains(newWord))
                    {
                        vec.add(newWord);
                        ArrayList<String> temp=new ArrayList<>(vec);
                        queue.add(temp);
                        usedOnLevel.add(newWord);
                        vec.removeLast();
                    }
                }


            }
        }
        return ans;
    }
    static class Pair<F,S>
    {
        F first;
        S second;
        Pair(F first,S second)
        {
            this.first=first;
            this.second=second;
        }
    }
}
