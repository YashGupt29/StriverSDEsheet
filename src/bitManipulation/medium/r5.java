package bitManipulation.medium;

import java.util.Arrays;

public class r5 {
    public static void main(String[] args) {
        int [] arr={4, 2, 4, 5, 2, 3, 3, 1};
        System.out.println(Arrays.toString(twoOddNum(arr, 3)));

    }
    public static int [] twoOddNum(int [] arr, int N)
    {
        int ans=arr[0];
        int [] ansArr=new int [2];
        int num1=0;
        int num2=0;
        for (int i = 1; i < arr.length; i++) {
            ans=ans^arr[i];
        }
        int rightmost=(ans & ans-1) ^ ans; //for checking which bit is different

        for (int i = 0; i < arr.length ; i++) {
            if((rightmost & arr[i])==0)
            {
               num1 ^= arr[i];
            }
            else {
                num2 ^= arr[i];
            }

        }
        if(num1>num2)
        {
            ansArr[0]=num1;
            ansArr[1]=num2;
        }
        else {
            ansArr[0]=num2;
            ansArr[1]=num1;
        }
        return ansArr;


    }
}
