package recursion.hard;

public class r5 {
    public static void main(String[] args) {
        int N = 4;
        int M = 3;
        int E = 5;

        // Define the edges of the graph
        int[][] edges = {
                {0, 1},
                {1, 2},
                {2, 3},
                {3, 0},
                {0, 2}
        };

        // Initialize the adjacency matrix for the graph
        boolean[][] graph = new boolean[N][N];
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            graph[u][v] = true;
            graph[v][u] = true;
        }

        // Call the graphColoring function and print the result
        System.out.println(graphColoring(graph, M, N) ? 1 : 0);

    }
    public static boolean graphColoring(boolean graph[][], int m, int n) {
        int [] colours=new int[n];
        if(graphHelper(graph,m,n,0,colours))
        {
            return true;
        }
        return false;

    }
    public static boolean graphHelper(boolean[][] graph, int m, int n, int node, int [] colours)
    {
        if(node==n)
        {
            return true;
        }
        for (int i = 1; i <=m ; i++) {
            if(isSafe(graph,node,i,colours))
            {
                colours[node]=i;
                if(graphHelper(graph,m,n,node+1,colours)) return true;
                colours[node]=0;
            }
        }
        return  false;

    }
    public static boolean isSafe(boolean[][] graph,int node,int col,int [] colours)
    {
        for (int i = 0; i < graph[node].length; i++) {
            if(graph[node][i] && colours[i]==col)
            {
                return false;
            }
        }
        return true;
    }
}
