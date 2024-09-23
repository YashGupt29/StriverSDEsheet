package dp.D1;

import java.util.Arrays;

public class lic6 {
    public static void main(String[] args) {
            int [] arr={1, 2, 5, 3, 2};
        System.out.println(lengthOfLBS(arr));
    }
   public static int lengthOfLBS(int [] arr)
   {
       int n=arr.length;
       int [] dp1=new int[n];
       int [] dp2=new int[n];
       Arrays.fill(dp1,1);
       Arrays.fill(dp2,1);
       for (int index = 0; index < n; index++) {
           for (int prev = 0; prev <index; prev++) {
               if(arr[index]>arr[prev] )
               {
                   dp1[index]= Math.max(1 + dp1[prev],dp1[index]);
               }
           }
       }
       for (int index = n-1; index >=0; index--) {
           for (int prev = n-1; prev > index ; prev--) {
               if(arr[index]>arr[prev] )
               {
                   dp2[index]= Math.max(1 + dp2[prev],dp2[index]);
               }
           }
       }
       System.out.println(Arrays.toString(dp1));
       System.out.println(Arrays.toString(dp2));

       int max=0;
       for (int i = 0; i < n; i++) {
           if(dp1[i]!=1 && dp2[i]!=1)
           {
               max=Math.max(max,dp1[i]+dp2[i]-1);
           }

       }
       return max;
   }
}
