package Linkedin;

import java.util.Arrays;

public class c5 {
    public static void main(String[] args) {
        int [] arr={0, 0, 0, 3, 1, 4};
        pushZerosToEnd(arr);
    }
    static void pushZerosToEnd(int[] arr) {
        int n = arr.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            if(arr[i]!=0)
            {
                arr[count]=arr[i];
                count++;
            }
        }
        while(count<n)
        {
            arr[count]=0;
            count++;
        }
        System.out.println(Arrays.toString(arr));

    }
}
