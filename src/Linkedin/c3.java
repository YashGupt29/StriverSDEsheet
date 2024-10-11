package Linkedin;

import java.util.Arrays;

public class c3 {
    public static void main(String[] args) {
        long [] arr1={1 ,3 ,5 ,7};
        long [] arr2={0 ,2, 6, 8, 9};
        merge(4,5,arr1,arr2);
    }
    public static void merge(int n, int m, long arr1[], long arr2[]) {
        int i=n-1;
        int j=0;
        while(i>=0 && j<m)
        {
            if(arr1[i]>arr2[j])
            {
                arr1[i]=arr1[i] ^ arr2[j];
                arr2[j]=arr1[i] ^ arr2[j];
                arr1[i]=arr1[i] ^ arr2[j];
            }
            i--;
            j++;
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
    }

}
