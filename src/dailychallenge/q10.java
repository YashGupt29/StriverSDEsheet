package dailychallenge;

import java.util.HashMap;

public class q10 {
    public static void main(String[] args) {
        int [][] arr={{0,0},{1,0},{1,0},{2,1},{2,1},{2,0}};
        System.out.println(winningPlayerCount(4,arr));

    }
    public static int winningPlayerCount(int n, int[][] pick) {
        int count=0;
        HashMap<Integer,Integer> mpp=new HashMap<>();
        for (int i = 0; i < pick.length; i++) {
            if(pick[i][0]==0)
            {
                count++;
                continue;
            }
            mpp.put(pick[i][0],mpp.getOrDefault(pick[i][0],0)+1);
             if(mpp.containsKey(pick[i][0]))
             {
                 if(mpp.get(pick[i][0])==pick[i][1] && mpp.get(pick[i][0])>pick[i][0])
                 {
                     count++;
                 }

             }
        }
        return count;

    }
}
