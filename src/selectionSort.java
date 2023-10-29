import java.util.ArrayList;
import java.util.Arrays;

public class selectionSort {
    public static void main(String[] args) {
        int [] arr={12,46,24,52,20,9};
        System.out.println(Arrays.toString(sortByQuick(arr)));
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
        boolean swapped=false;
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
                    swapped=true;
                }

            }
            if(!swapped)
            {
                break;
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
    static int [] sortByMerging(int [] arr){
        mergeSort(arr,0,arr.length-1);
        return arr;
    }

    static  void mergeSort(int [] arr, int low, int high)
    {
        if(low>=high)
        {
            return;
        }
        int mid=(low+high)/2;
        mergeSort(arr,low,mid);
        mergeSort(arr,mid+1,high);
        merge(arr,low,mid,high);



    }
    static void merge(int [] arr,int low,int mid,int high)
    {
        ArrayList <Integer> temp=new ArrayList<>();
        int left=low;
        int right=mid+1;
        while(left<=mid && right<=high)
        {
            if(arr[left]<=arr[right])
            {
                temp.add(arr[left] );
                left++;
            }
            else {
                temp.add(arr[right]);
                right++;
            }
        }
        while(right<=high)
        {
            temp.add(arr[right]);
            right++;

        }
        while(left<=mid)
        {
            temp.add(arr[left]);
            left++;
        }
        for(int i=low;i<=high;i++)
        {
            arr[i]= temp.get(i - low);
        }
    }
    static int[] sortByQuick(int [] arr){
        quickSort(arr,0,arr.length-1);
        return arr;
    }
    static  void quickSort(int [] arr, int low, int high)
    {

        if(low<high)
        {
            int partitionIndex=partition(arr,low,high);
            quickSort(arr,low,partitionIndex-1);
            quickSort(arr,partitionIndex+1,high);
        }
    }
    static  int partition(int [] arr,int low ,int high)
    {
        int pivot=arr[low];
        int i=low;
        int j=high;
        while(i<j)
        {
            while(arr[i]<=pivot && i<high)
            {
                i++;
            }
            while(arr[j]>pivot && j>low)
            {
                j--;
            }
            if(i<j)
            {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[j];
        arr[j] = pivot;
        arr[low]= temp;
        return j;



    }


}
