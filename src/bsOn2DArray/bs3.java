package bsOn2DArray;

import java.util.Arrays;

public class bs3 {
    public static void main(String[] args) {
        int [][] mat = {
                {25, 37, 23, 37, 19},
                {45, 19, 2, 43, 26},
                {18, 1, 37, 44, 50}
        };
        System.out.println(Arrays.toString(findPeakGrid(mat)));

    }
    public static int[] findPeakGrid(int[][] mat) {
        int n= mat.length;
        int m=mat[0].length;
        int first=0;
        int last=m-1;
        while(first<=last)
        {
            int mid=first+(last-first)/2;
            int row=findMax(mat,mid);
            int left=mid>0?mat[row][mid-1]:-1;
            int right=mid<m-1?mat[row][mid+1]:-1;
            if(mat[row][mid]>left && mat[row][mid]>right)
            {
                return new int[]{row,mid};
            }
            if(mat[row][mid]<left)
            {
                last=mid-1;
            }
            else {
                first=mid+1;
            }


        }
        return new int[] {-1,-1};

    }
    public static int findMax(int [][] mat, int mid)
    {
        int max=0,index=-1;
        for (int i = 0; i < mat.length ; i++) {
            if(mat[i][mid]>max)
            {
                max=mat[i][mid];
                index=i;
            }
        }
        return index;
    }
}
