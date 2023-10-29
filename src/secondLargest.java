import java.util.Arrays;

public class secondLargest {
    public static void main(String[] args) {
        int [] arr={5, 12, 7, 10, 9, 15};
        System.out.println(Arrays.toString(getSecondOrderElements(6, arr)));


    }
    public static int [] getSecondOrderElements(int n, int []arr) {
        int secondMax=getSecondMax(n,arr);
        int secondMin=getSecondSmallest(n,arr);
        return new int[]{secondMax,secondMin};

    }
    static  int getSecondMax(int n,int [] arr)
    {
        int max=arr[0];
        int secondMax=Integer.MIN_VALUE;
        for(int i=0;i<n;i++)
        {
            if(arr[i]>max)
            {
                secondMax=max;
                max=arr[i];

            }
            else if(arr[i]<max && arr[i]>secondMax){
                secondMax=arr[i];

            }
        }
        return secondMax;
    }
    static  int getSecondSmallest(int n,int [] arr)
    {
        int min=arr[0];
        int secondMin=Integer.MAX_VALUE;
        for(int i=0;i<n;i++)
        {
            if(arr[i]<min)
            {
                secondMin=min;
                min=arr[i];
            }
            if(arr[i]>min && arr[i]<secondMin)
            {
                secondMin=arr[i];
            }
        }
        return secondMin;
    }
}
