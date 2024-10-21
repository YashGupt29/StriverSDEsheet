package Linkedin;

import java.util.ArrayList;
import java.util.Arrays;

public class c15 {
    public static void main(String[] args) {
        int [] arr={12, 34, 45, 9, 8, 90, 3};
        segregateEvenOdd(arr);
    }
    static void segregateEvenOdd(int arr[]) {
        Arrays.sort(arr);
        int left=0;
        int right=arr.length-1;
        while(left<right)
        {
            while(left<right && (arr[left] & 1)==0)
            {
                left++;
            }
            while(left<right && (arr[right] & 1)!=0)
            {
                right--;
            }
            if (left < right) {
                arr[left] = arr[left] ^ arr[right];
                arr[right] = arr[left] ^ arr[right];
                arr[left] = arr[left] ^ arr[right];
            }
        }
        Arrays.sort(arr,0,left-1);
        Arrays.sort(arr,right,arr.length-1);
    }
}
