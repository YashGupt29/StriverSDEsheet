package graphStriver.Lec4;

import java.util.Arrays;

public class s11 {
    public static void main(String[] args) {
        int [][] arr={{0,1,3},{1,2,1},{1,3,4},{2,3,1}};
        System.out.println(findTheCity(4,arr,4));
    }
    public static int findTheCity(int n, int[][] edges, int distanceThreshold) {

        int [][] dist=new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    dist[i][j] = (int) 1e9;
                } else {
                    dist[i][j] = 0;
                }
            }
        }
        for (int i = 0; i < edges.length; i++) {
            dist[edges[i][0]][edges[i][1]]=edges[i][2];
            dist[edges[i][1]][edges[i][0]]=edges[i][2];
        }
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if(dist[i][j]>dist[i][k] + dist[k][j] )
                    {
                        dist[i][j]=dist[i][k] + dist[k][j];
                    }
                }
            }
        }
        System.out.println(Arrays.deepToString(dist));
        int minReachableCity=Integer.MAX_VALUE;
        int city=Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int reachableCities=0;
            for (int j = 0; j < n; j++) {
                if(i!=j && dist[i][j]<=distanceThreshold)
                {
                    reachableCities++;
                }
            }
           if(minReachableCity>=reachableCities)
           {
               minReachableCity=reachableCities;
               city=Math.max(i,city);
           }
        }
        return city;
    }

}
