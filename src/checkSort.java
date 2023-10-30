public class checkSort {
    public static void main(String[] args) {
        int [] arr={1,2,3,4,5,6};
        System.out.println(isSorted(6,arr));

    }
    public static int isSorted(int n, int []arr) {
        long startTime = System.currentTimeMillis();

        int sort=1;
        for(int i=n-1;i>=0;i--)
        {
            for(int j=0;j<i;j++)
            {
                if (arr[j] > arr[j + 1]) {
                    sort = 0;
                    break;
                }
            }
        }
        long endTime = System.currentTimeMillis();

        // Calculate the elapsed time
        long elapsedTime = endTime - startTime;

        // Print the elapsed time
        System.out.println("Elapsed time in milliseconds: " + elapsedTime);
        return sort;
    }
}
