package dailychallenge;

import java.util.ArrayList;

public class d1 {
    public static void main(String[] args) {
        System.out.println(findTheWinner(6,5));

    }
    public static int findTheWinner(int n, int k) {
        int [] ans=new int[1];
        helper(n,k,new ArrayList<>(),1,k,ans,new boolean[n+1]);
        return ans[0];

    }
    public static void helper(int n, int k, ArrayList<Integer> arr, int cnt, int real, int[] ans, boolean[] used) {
        if (arr.size() == n - 1) {
            int sum = 0;
            for (int i = 0; i < arr.size(); i++) {
                sum = sum + arr.get(i);
            }
            ans[0] = ((n * (n + 1)) / 2) - sum;
            return;
        }

        while (used[cnt]) {
            cnt = (cnt % n) + 1;
        }

        if (k == 1) {
            arr.add(cnt);
            used[cnt] = true;
            helper(n, real, arr, (cnt % n) + 1, real, ans, used);
        } else {
            helper(n, k - 1, arr, (cnt % n) + 1, real, ans, used);
        }
    }
}
