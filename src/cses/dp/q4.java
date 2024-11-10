package cses.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class q4 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Reading the first line to get n and targets
        String[] firstLine = br.readLine().split(" ");
        int n = Integer.parseInt(firstLine[0]);
        int x = Integer.parseInt(firstLine[1]);

        int[] arr = new int[n];
        String[] inputArray = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(inputArray[i]);
        }
        int MOD = 1_000_000_007;
        int [] dp=new int[x+1];
        dp[0]=1; //there is only one way to make sum 0 by using no coins
       for(int coins:arr) {
            for (int target = 1; target <=x ; target++) {
               if(target>=coins)
               {
                   dp[target]=(dp[target] + dp[target-coins]) % MOD;
               }
            }
        }
        System.out.println(dp[x]);
    }
}
