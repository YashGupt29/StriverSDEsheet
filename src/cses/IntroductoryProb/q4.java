
import java.util.Scanner;

public class q4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextLong();
        }
        in.close();
        System.out.println(sol(n, arr));
    }

    public static long sol(int n, long[] arr) {
       long count=0;
        for (int i = 1; i < n; i++) {
            if (arr[i]<arr[i-1])
            {
                count+=arr[i-1]-arr[i];
                arr[i]=arr[i-1];
            }
        }
        return count;
    }
}

