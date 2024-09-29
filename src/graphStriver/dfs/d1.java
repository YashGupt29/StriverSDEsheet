package graphStriver.dfs;

import java.util.ArrayList;

public class d1 {
    public static void main(String[] args) {
        int [][] arr={{1,1,0},{1,1,0},{0,0,1}};
        System.out.println(findCircleNum(arr));
    }
    public static int findCircleNum(int[][] isConnected) {
        ArrayList<ArrayList<Integer>> arr=new ArrayList<>();
        for (int i = 0; i <=isConnected.length ; i++) {
            arr.add(new ArrayList<>());

        }
        for (int i = 1; i <=isConnected.length ; i++) {
            for (int j = 1; j <= isConnected.length; j++) {
                if(isConnected[i-1][j-1]==1 && i!=j)
                {
                    arr.get(i).add(j);
                }
            }
        }
        int comp=0;
        int n=isConnected.length;
        int [] vis=new int[n+1];
        for (int i = 1; i <=n; i++)
        {
            if(vis[i]==0)
            {
                comp++;
                dfs(arr,i,comp,vis);
            }
        }

        return comp;
    }
    public static void dfs(ArrayList<ArrayList<Integer>> adj ,int node,int comp,int []vis)
    {
        vis[node]=comp;
        for(int v:adj.get(node))
        {
            if(vis[v]==0)
            {
                dfs(adj,v,comp,vis);
            }
        }

    }
}
