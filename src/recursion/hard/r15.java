package recursion.hard;

import java.util.ArrayList;

public class r15 {
    public static void main(String[] args) {
        int m[][] = {{1, 0, 0, 0},
                {1, 1, 0, 1},
                {1, 1, 0, 0},
                {0, 1, 1, 1}};
        System.out.println(findPath(m,4));
    }
    public static ArrayList<String> findPath(int[][] m, int n) {
        ArrayList<String> ans=new ArrayList<>();
        StringBuilder a=new StringBuilder();
        if(m[0][0]==0) return ans;
        findPathHelper(m,0,0,ans,n,a);
        if(ans.isEmpty())
        {
            ans.add("-1");
        }

        return ans;
    }
    public static void findPathHelper(int [][] arr,int row,int col,ArrayList<String> ans,int n,StringBuilder a)
    {
        if(row==n-1 && col==n-1)
        {
            ans.add(a.toString());
            return;
        }
        int temp = arr[row][col];
        arr[row][col] = 0;

        if(check(arr,row,col+1,n))
        {
            a.append("R");
            findPathHelper(arr,row,col+1,ans,n,a);
            a.deleteCharAt(a.length()-1);
        }
        if(check(arr,row+1,col,n))
        {
            a.append("D");
            findPathHelper(arr,row+1,col,ans,n,a);
            a.deleteCharAt(a.length()-1);
        }
        if (check(arr, row, col - 1, n)) {
            a.append('L');
            findPathHelper(arr, row, col - 1, ans, n, a);
            a.deleteCharAt(a.length() - 1);
        }


        if (check(arr, row - 1, col, n)) {
            a.append('U');
            findPathHelper(arr, row - 1, col, ans, n, a);
            a.deleteCharAt(a.length() - 1);
        }
        arr[row][col]=temp;


    }
    public static boolean check(int [][] arr,int row,int col,int n)
    {
        return row>=0 && col>=0 && row < n && col<n  && arr[row][col]==1;

    }
}
