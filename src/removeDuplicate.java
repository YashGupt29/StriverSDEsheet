import java.util.ArrayList;
import java.util.Objects;

public class removeDuplicate {
    public static void main(String[] args) {
       int arr []={1,2,2,3,3,3,4,4,5,5};
        System.out.println(removeDuplicates(arr,arr.length));



    }
    public static int removeDuplicates(int [] arr, int n)
    {
        ArrayList list= new ArrayList();


        for(int i=0;i<n-1;i++)
        {
            if(arr[i]!=arr[i+1])
            {
                list.add(arr[i]);
            }
        }
        if(arr[n-1]==arr[n-2])
        {
            list.add(arr[n-1]);
        }
        return list.toArray().length;

    }
}
