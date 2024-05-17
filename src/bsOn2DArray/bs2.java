package bsOn2DArray;

public class bs2 {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        };
        int target = 20;
        System.out.println(searchMatrix(matrix,target));

    }
    public static boolean searchMatrix(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++) {
            if(findTarget(matrix[i],target))
            {
                return true;

            }

        }
        return false;

    }
    public static boolean findTarget(int [] arr,int target)
    {
       int first=0;
       int last=arr.length-1;
       while(first<=last)
       {
           int mid=first+(last-first)/2;
           if(arr[mid]==target)
           {
               return true;
           }
           if(target>arr[mid])
           {
               first=mid+1;
           }
           else {
               last=mid-1;
           }
       }
       return false;

    }
}
