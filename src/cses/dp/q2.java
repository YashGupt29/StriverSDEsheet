
import java.util.Arrays;
import java.util.Scanner;

public class q2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int targeT=sc.nextInt();
        int [] arr=new int[n];
        for (int i = 0; i < n; i++) {
            arr[i]=sc.nextInt();
        }
        int [] dp=new int[targeT+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0]=0;
        for (int target = 1; target <=targeT ; target++) {
            for (int index = 0; index < n; index++) {
                if(target>=arr[index]) {
                    int take = dp[target - arr[index]];
                    if (take != Integer.MAX_VALUE) {
                        dp[target] = Math.min(dp[target],1+ take);
                    }
                }
            }
        }
        System.out.println(dp[targeT]==Integer.MAX_VALUE?-1:dp[targeT]);
    }
//    public static int helper(int index,int target,int [] arr)
//    {
//       if(target==0)
//       {
//           return 1;
//       }
//       if(index==0)
//       {
//           if(target % arr[0]==0)
//           {
//               return target/arr[0];
//           }
//           else {
//               return Integer.MAX_VALUE;
//           }
//       }
//        int take=Integer.MAX_VALUE;
//        if(target>arr[index])
//        {
//            take=1 + helper(index,target-arr[index],arr);
//        }
//        int notTake=helper(index-1,target,arr);
//
//        return Math.min(take,notTake);
//    }
}
