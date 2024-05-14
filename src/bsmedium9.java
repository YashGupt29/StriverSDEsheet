import java.util.ArrayList;
import java.util.Collections;

public class bsmedium9 {
    public static void main(String[] args) {
        int[] array = {12 ,34 ,67 ,90};

        // Create an ArrayList
        ArrayList<Integer> arrayList = new ArrayList<>();

        // Add elements from array to ArrayList
        for (int element : array) {
            arrayList.add(element);
        }
        System.out.println(findPages(arrayList,4,2));

    }
    public static int findPages(ArrayList<Integer> arr, int n, int m) {
        int first=Collections.max(arr);
        int last=findSum(arr);
        while(first<=last)
        {
            int mid=first+(last-first)/2;
            if(calculatePage(arr,mid)<=m)
            {
                last=mid-1;//chota krna hai mid ko taaki kam book aae taaki ma zada ho

            }
            else {
                first=mid+1;//bada krna mid ko taaki jada book ajae to m kam ho
            }
        }
        return first;

    }
    public static int  calculatePage(ArrayList<Integer> arr, int mid)
    {
        int count=1;
        int sum=0;
        for (int i = 0; i < arr.size(); i++) {
            if(sum+arr.get(i)<=mid)
            {
                sum+=arr.get(i);
            }
            else {
                count++;
                sum=arr.get(i);
            }

        }
        return count;
    }
    public static int findSum(ArrayList<Integer> arr)
    {
        int sum=0;
        for(int num:arr)
        {
            sum+=num;
        }
        return sum;
    }

}
