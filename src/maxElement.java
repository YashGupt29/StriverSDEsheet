import java.util.Arrays;

public class maxElement {
    public static void main(String[] args) {
        int [] arr={1,2,3,4,5};
        System.out.println(largestElement(arr,5));
        System.out.println(largestElemen(arr,5));
        System.out.println(sort(arr,5));



    }
    static int sort (int [] arr,int n)
    {
        long startTime = System.nanoTime();
        Arrays.sort(arr);
        long endTime = System.nanoTime();
        long elapsedTime = endTime - startTime;
        System.out.println("sort algo"+elapsedTime);
        return arr[n-1];
    }
    static int largestElement(int[] arr, int n) {
        long startTime = System.nanoTime();
int count=0;
        int low=0;
      int high=n-1;
      while(low<high)
      {
          while (arr[high] > arr[low]) {
              low++;
          }
          int temp = arr[high];
          arr[high] = arr[low];
          arr[low] = temp;
          count++;
      }
        long endTime = System.nanoTime();
        long elapsedTime = endTime - startTime;
        System.out.println("my algo"+elapsedTime);
        System.out.println(count);
        return arr[high];

    }
    static int largestElemen(int[] arr, int n) {
        long startTime = System.nanoTime();
        int count=0;
        int max=arr[0];
        for(int i=0;i<n;i++)
        {
            if(arr[i]>max)
            {
                max=arr[i];
            }
            count++;
        }
        long endTime = System.nanoTime();
        long elapsedTime = endTime - startTime;
        System.out.println(count);
        System.out.println("max algo"+elapsedTime);
        return max;

    }
}
