package graphStriver.Lec4;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class s10 {
    public static void main(String[] args) {
        int [] arr={9 ,12, 18, 19};
        System.out.println(minimumMultiplications(arr,5,5));
    }
    static  int minimumMultiplications(int[] arr, int start, int end) {
        if(start==end)
        {
            return 0;
        }
        Queue<Pair> queue=new LinkedList<>();
        int [] dist=new int[100000];
        Arrays.fill(dist,(int)(1e9));
        queue.add(new Pair(start,0));
        dist[start]=0;
        while (!queue.isEmpty())
        {
           Pair curr=queue.poll();
           int node=curr.node;
           int steps=curr.no;

           for(int i:arr)
           {
               int newNode=(i * node) % 100000;
               if(dist[newNode] > steps +1)
               {
                   dist[newNode]=steps +1;
                   if(newNode==end)
                   {
                       return steps + 1;
                   }
                   queue.add(new Pair(newNode,steps+1));
               }

           }
        }
        return -1;
    }
    static class Pair{
        int node;
        int no;
        Pair(int node,int no)
        {
            this.node=node;
            this.no=no;
        }
    }
}
