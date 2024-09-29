package graphStriver.dfs;

import java.util.ArrayList;
import java.util.Arrays;

public class d2 {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        list.add(new ArrayList<>(Arrays.asList(1, 0, 1)));
        list.add(new ArrayList<>(Arrays.asList(0, 1, 0)));
        list.add(new ArrayList<>(Arrays.asList(1, 0, 1)));
        System.out.println(numProvinces(list,3));
    }
    public static int numProvinces(ArrayList<ArrayList<Integer>> adj, int v) {
        ArrayList<ArrayList<Integer>> arr=new ArrayList<>();
        for (int i = 0; i <=adj.size() ; i++) {
            arr.add(new ArrayList<>());

        }
        for (int i = 1; i <=adj.size() ; i++) {
            for (int j = 1; j <= adj.size(); j++) {
                if(adj.get(i-1).get(j-1)==1 && i!=j)
                {
                    arr.get(i).add(j);
                }
            }
        }
        System.out.println(arr);
        int comp=0;
        int [] vis= new int[v+1];
        for (int i = 1; i <=v ; i++) {
            if(vis[i]==0)
            {
                comp++;
                dfs(arr,i,vis,comp);
            }

        }
        return comp;
    }
    public static  void dfs(ArrayList<ArrayList<Integer>> adj,int node,int [] vis,int comp)
    {
        vis[node]=comp;
        for(int v:adj.get(node))
        {
            if(vis[v]==0)
            {
                dfs(adj,v,vis,comp);
            }
        }
    }
}
