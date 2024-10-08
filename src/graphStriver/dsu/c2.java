package graphStriver.dsu;

public class c2 {
    public static void main(String[] args) {
    int [][] arr={{1,5},{1,7},{1,2},{1,4},{3,7},{4,7},{3,5},{0,6},{0,1},{0,4},{2,6},{0,3},{0,2}};
    int n=12;
        System.out.println(makeConnected(n,arr));
    }
    static int setSize;
    static int [] par;
    static int [] rank;
    public static int makeConnected(int n, int[][] connections) {
        int originalEdges=connections.length;
         setSize=0;
         par=new int [n];
         rank=new int[n];
        for(int i=0;i<n;i++)
        {
            par[i]=i;
            rank[i]=1;
        }
        for(int [] edge :connections)
        {
            int node=edge[0];
            int directedNode=edge[1];
            if(find(node)!=find(directedNode))
            {
                merge(node,directedNode);
            }
        }
        System.out.println(setSize);
        int cablesleft=originalEdges-setSize;
        int nodesLeft=(n-1) -setSize;
        return nodesLeft>cablesleft?-1:nodesLeft;
    }
    public static int find(int x)
    {
        if(x!=par[x])
        {
            par[x]=find(par[x]);
        }
        return par[x];
    }
    public static void  merge(int x,int y)
    {
        int xRoot=find(x);
        int yRoot=find(y);
        if(xRoot!=yRoot)
        {
            if(rank[xRoot]>=rank[yRoot])
            {
                par[yRoot]=xRoot;
                rank[xRoot]+=rank[yRoot];
            }
            else {
                par[xRoot]=yRoot;
                rank[yRoot]+=rank[xRoot];
            }
        }
        setSize++;
    }
}
