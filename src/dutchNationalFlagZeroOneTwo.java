import java.util.Arrays;

public class dutchNationalFlagZeroOneTwo {
    public static void main(String[] args) {
        int[] arr ={0,1,1,0,1,2,1,2,0,0,0};
        sort012(arr);


    }
    public static void sort012(int[] arr)
    {
        int low=0,mid=0,high=arr.length-1;

while(mid<=high) {
    if (arr[mid] == 0) {
        swap(arr,low, mid);
        low++;
        mid++;
    }
   else if (arr[mid] == 1) {
        mid++;
    }
    else if (arr[mid] == 2) {
        swap(arr,mid, high);
        high--;
    }
}
        System.out.println(Arrays.toString(arr));
    }
    public static void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}
