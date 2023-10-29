import java.util.Arrays;

public class sortByRecursion {
    public static void main(String[] args) {
        int [] arr={12,46,24,52,20,9};
        byRecursionInsertion(arr,0);
        System.out.println(Arrays.toString(arr));
    }
    static void  byRecursionBubble(int [] arr,int n)
    {
        boolean swap=false;

        if(n<=0)
        {
            return;
        }

        for(int j=0;j<n;j++)
        {
            if(arr[j]>arr[j+1])
            {
                int temp=arr[j];
                arr[j]=arr[j+1];
                arr[j+1]=temp;
                swap=true;

            }
        }
        if(!swap) return;
        byRecursionBubble(arr,n-1);



    }
    static void  byRecursionInsertion(int [] arr,int index)
    {
        if(index>=arr.length)
        {
            return;
        }
        int j=index;
        while(j>0 && arr[j-1]>arr[j])
        {
            int temp=arr[j];
            arr[j]=arr[j-1];
            arr[j-1]=temp;
            j--;
        }
        byRecursionInsertion(arr,index+1);


    }
}
