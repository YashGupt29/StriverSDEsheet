    package dpAtcoderr;
    import java.io.BufferedReader;
    import java.io.InputStreamReader;
    import java.io.IOException;
    import java.util.Arrays;
    public class q2 {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            // Reading n and k from the first line
            String[] firstLine = br.readLine().split(" ");
            int n = Integer.parseInt(firstLine[0]);
            int k = Integer.parseInt(firstLine[1]);

            // Reading the array from the second line
            String[] input = br.readLine().split(" ");
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(input[i]);
            }

            // Output the result
            System.out.println(solve(n, arr, k));
        }

        public static int solve(int n,int [] arr,int k)
        {
            int [] dp=new int[n];
            for (int index = 1; index < n; index++) {
                int min=Integer.MAX_VALUE;
                for (int i = 1; i <= k; i++) {
                    if(index>=i)
                    {
                        int cost=Math.abs(arr[index-i]-arr[index]) + dp[index-i];
                        min=Math.min(min,cost);
                    }
                }
                dp[index]=min;
            }
            return dp[n-1];
        }
    }
