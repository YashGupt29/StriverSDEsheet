
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
    public class q3 {
        public static void main(String[] args) throws IOException {
            int MOD = (int) (1e9) + 7;
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            String[] firstLine = br.readLine().split(" ");
            int n = Integer.parseInt(firstLine[0]);
            int target = Integer.parseInt(firstLine[1]);

            int[] arr = new int[n];
            String[] coins = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(coins[i]);
            }
            int [] dp=new int[target+1];
            dp[0]=1;//0 sum->1 way
                for (int t = 1; t <=target ; t++) {
                    for (int index = 0; index < n; index++)
                    {
                                if(t<arr[index]) continue;

                                    dp[t] = (dp[t] + dp[t - arr[index]]);
                                    if (dp[t] > MOD) {
                                        dp[t] = dp[t] - MOD;
                                    }


                    }
                }

            System.out.println(dp[target] %MOD);
            br.close();
        }

    }
