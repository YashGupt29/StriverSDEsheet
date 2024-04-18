public class bs11 {
    public static void main(String[] args) {
        int [] nums={3, 4, 5, 1, 2 };
        System.out.println(findMinIndex(nums));

    }
    public static int findKRotation(int []arr){
        return  findMinIndex(arr);
    }
    public static int findMinIndex(int[] arr) {
        int first = 0;
        int last = arr.length - 1;
        int min = Integer.MAX_VALUE;
        int minIndex = -1;

        while (first <= last) {
            int mid = first + (last - first) / 2;
            if(arr[first]<=arr[last])
            {
                if(arr[first]<min)
                {
                    minIndex=first;
                    min=arr[first];
                }
                break;
            }
            if (arr[mid] < min) {
                min = arr[mid];
                minIndex = mid;
            }
            if (arr[first] <= arr[mid]) {
                if (arr[first] < min && min <arr[mid]) {
                    last = mid - 1;
                } else {
                    first = mid + 1;
                }
            } else {
                if (arr[mid] < min && min < arr[last]) {
                    first = mid + 1;
                } else {
                    last = mid - 1;
                }
            }
        }
        return minIndex;
    }

}
