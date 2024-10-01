package graphStriver.dfs;

public class dfs12 {
    public static void main(String[] args) {
        int [][] arr={{1,3},{0,2},{1,3},{0,2}};
        System.out.println(isBipartite(arr));
    }
    static int [] vis;
    public static boolean isBipartite(int[][] graph) {
        int n=graph.length;
        int m=graph[0].length;
        vis=new int[n+1];
        for (int i = 0; i < n; i++) {
            if(vis[i]==0)
            {
                if(!dfs(graph,i,1))
                {
                    return false;
                }
            }

        }
        return true;

    }
    public static boolean dfs(int [][] graph,int node,int color)
    {
        vis[node]=color;
        for(int v :graph[node])
        {
            if(vis[v]==0)
            {
                if(!dfs(graph,v,color ^ 1 ^ 2))
                {
                    return false;
                }
            } else if (vis[v]==vis[node]) {
                return false;
            }
        }
        return true;
    }
}
