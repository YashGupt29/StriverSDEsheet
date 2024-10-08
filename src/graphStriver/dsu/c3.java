package graphStriver.dsu;

import java.util.HashMap;
import java.util.Map;

public class c3 {
    public static void main(String[] args) {
        int [][] arr={{0,0},{0,1},{1,0},{1,2},{2,1},{2,2}};
        System.out.println(removeStones(arr));
    }
    public static int removeStones(int[][] stones) {
        int maxRows=0;
        int maxCols=0;
        int n=stones.length;
        for(int i=0;i<stones.length;i++)
        {
            maxRows=Math.max(maxRows,stones[i][0]);
            maxCols=Math.max(maxCols,stones[i][1]);
        }
        UnionFind dsu=new UnionFind(maxRows + maxCols +2);
        HashMap<Integer,Integer> uniques=new HashMap<>();
        for(int i=0;i<stones.length;i++)
        {
            int nodeRow=stones[i][0];
            int nodeCols=stones[i][1] + maxRows + 1;
            dsu.merge(nodeRow,nodeCols);
            uniques.put(nodeRow,1);
            uniques.put(nodeCols,1);
        }
        int cnt=0;
        //number of components
        for (Map.Entry<Integer, Integer> it : uniques.entrySet()) {
            if (dsu.find(it.getKey()) == it.getKey()) {
                cnt++;
            }
        }
        return n- cnt;

    }
    public static int removeStonesBrute(int[][] stones) {
        int maxRows=0;
        int maxCols=0;
        for(int i=0;i<stones.length;i++)
        {
            maxRows=Math.max(maxRows,stones[i][0]);
            maxCols=Math.max(maxCols,stones[i][1]);
        }
        int n=stones.length;
        UnionFind dsu=new UnionFind(n);
        int cnt=0;
        for (int node = 0; node < stones.length; node++) {
            int row=stones[node][0];
            int col=stones[node][1];
            for (int i = 0; i < stones.length; i++) {
                if(i!=node && stones[i][0]==row)
                {
                    if(dsu.find(node) !=dsu.find(i))
                    {
                        cnt++;
                        dsu.merge(node,i);
                    }
                }
                if(i!=node && stones[i][1]==col)
                {
                    if(dsu.find(node) !=dsu.find(i))
                    {
                        cnt++;
                        dsu.merge(node,i);
                    }
                }
            }
        }
        return cnt;

    }
}
