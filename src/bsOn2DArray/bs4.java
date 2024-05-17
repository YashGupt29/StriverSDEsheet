package bsOn2DArray;

public class bs4 {
    public static void main(String[] args) {
        int[][] arr = {{1, 3, 5},
                {2, 6, 9},
                {3, 6, 9}};
        int [] arr2={1,3,5};
//        System.out.println(findLessThanEquals(arr2,5));

        System.out.println( median(arr,3,3));
    }
    public static  int median(int[][] matrix, int R, int C) {
        int first=findMaxMin(matrix)[1];
        int last=findMaxMin(matrix)[0];
        while(first<=last)
        {
            int mid=first+(last-first)/2;
            int count=0;
            for (int i = 0; i <matrix.length ; i++)
            {
                count+=findLessThanEquals(matrix[i],mid);
            }
            if(count<=(R*C)/2)
            {
                first=mid+1;
            }
            else {
                last=mid-1;
            }

        }
        return first;

    }
    public static int findLessThanEquals(int [] arr,int target)
    {
        int first=0;
        int last=arr.length-1;
        while(first<=last)
        {
            int mid=first+(last-first)/2;
            if(arr[mid]<=target)
            {
                first=mid+1;
            }
            else {
                last=mid-1;
            }
        }
        return first;
    }
    public static int [] findMaxMin(int[][] matrix)
    {
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        int n=matrix[0].length;
        for (int i = 0; i < matrix.length ; i++) {
            if(matrix[i][0]<min)
            {
                min=matrix[i][0];
            }
            if(matrix[i][n-1]>max)
            {
                max=matrix[i][n-1];
            }
        }
        return new int [] {max,min};
    }
}
