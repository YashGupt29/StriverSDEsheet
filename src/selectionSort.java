import java.util.Arrays;

public class selectionSort {
    public static void main(String[] args) {
        int [] arr={12,46,24,52,20,9};
        System.out.println(Arrays.toString(sortbyInsertion(arr)));

    }
    static  int [] sortBySelection(int [] arr)
    {
        for(int i=0;i<arr.length-1;i++)
        {
            int min=i;
            for(int j=i+1;j<arr.length;j++)
            {
                if(arr[j]<arr[min])
                {
                    min=j;
                }
            }
            int temp=arr[min];
            arr[min]=arr[i];
            arr[i]=temp;

        }

        return  arr;

    }
    static int []  sortByBubble(int [] arr)
    {
        int n=arr.length;
        for(int i=n-1;i>=0;i--)
        {
            for(int j=0;j<i;j++)
            {
                if(arr[j]>arr[j+1])
                {
                    int temp=arr[j+1];
                    arr[j+1]=arr[j];
                    arr[j]=temp;
                }

            }
        }
        return arr;
    }
    static  int [] sortbyInsertion(int [] arr)
    {
        int n=arr.length;
        for(int i=0;i<n;i++)
        {
            int j=i;
            while(j>0 && arr[j-1]>arr[j])
            {
                int temp=arr[j-1];
                arr[j-1]=arr[j];
                arr[j]=temp;
                j--;

            }

        }
        return arr;
    }

}
