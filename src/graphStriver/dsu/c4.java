package graphStriver.dsu;

import javax.swing.*;
import java.util.*;

public class c4 {
    public static void main(String[] args) {
        // Convert the 2D array to List<List<String>>
        List<List<String>> accounts = new ArrayList<>();
        accounts.add(Arrays.asList("John", "johnsmith@mail.com", "john_newyork@mail.com"));
        accounts.add(Arrays.asList("John", "johnsmith@mail.com", "john00@mail.com"));
        accounts.add(Arrays.asList("Mary", "mary@mail.com"));
        accounts.add(Arrays.asList("John", "johnnybravo@mail.com"));

        // Call the accountsMerge function
        List<List<String>> mergedAccounts = accountsMerge(accounts);

        System.out.println(mergedAccounts);
    }

    public static List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n=accounts.size();
        HashMap<String,Integer> map=new HashMap<>();
        UnionFind dsu=new UnionFind(n);
        List<List<String>> ans=new ArrayList<>();
       for(int i=0;i<accounts.size();i++)
       {
           for (int j = 1; j < accounts.get(i).size(); j++) {
               String mail=accounts.get(i).get(j);
               if(!map.containsKey(mail))
               {
                   map.put(mail,i);
               }
               else {
                   dsu.merge(i,map.get(mail));
               }
           }
       }

        ArrayList<String>[] mergedMail = new ArrayList[n];
        for (int i = 0; i < n; i++) mergedMail[i] = new ArrayList<String>();

        for(Map.Entry<String,Integer> it: map.entrySet())
        {
            String mail = it.getKey();
            int node= dsu.find(it.getValue());
            mergedMail[node].add(mail);
        }
        for (int i = 0; i < n; i++) {
            if(mergedMail[i].isEmpty()) continue;
            Collections.sort(mergedMail[i]);
            List<String> temp=new ArrayList<>();
            temp.add(accounts.get(i).getFirst());
            temp.addAll(mergedMail[i]);
            ans.add(temp);
        }
        return ans;
    }
}
