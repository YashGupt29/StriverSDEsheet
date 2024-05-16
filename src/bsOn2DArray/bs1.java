package bsOn2DArray;

public class bs1 {
    public static void main(String[] args) {
        int N = 4;
        int M = 4;

        int[][] Arr = {
                {0, 1, 1, 1},
                {0, 0, 1, 1},
                {1, 1, 1, 1},
                {0, 0, 0, 0}
        };
        System.out.println(rowWithMax1sOptimized(Arr,N,M));
        
    }
   public static int rowWithMax1s(int[][] arr, int n, int m) {

        int maxCount=0;
        int row=-1;
       for (int i = 0; i < arr.length; i++) {
           int count=0;
           for (int j = 0; j <arr[0].length ; j++) {
               if(arr[i][j]==1)
               {
                   count++;
               }

           }
           if(count>maxCount)
           {
               maxCount=count;
               row=i;
           }

       }
       return row;

    }
    public static int rowWithMax1sOptimized(int[][] arr, int n, int m)
    {

        int max_Count=0;
        int index=-1;
        for (int i = 0; i <n ; i++)
        {
             int count=0;
             if(lowerbound(arr[i],m)!=-1)
             {
                 count=m-lowerbound(arr[i],m);

             }
             if(count>max_Count)
             {
                 max_Count=count;
                 index=i;
             }

        }
        return index;


    }
    public static int lowerbound(int [] arr,int n)
    {
        int first=0;
        int last=n-1;
        int lowerBound=-1;
        while(first<=last)
        {
            int mid=first+(last-first)/2;
            if(arr[mid]==1)
            {
                 lowerBound=mid;
            }
            if(1>arr[mid])
            {
                first=mid+1;

            }
            else{
                last=mid-1;
            }
        }
        return lowerBound;
    }
}
