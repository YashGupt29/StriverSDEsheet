import java.util.ArrayList;
    import java.util.Collections;

public class bsmedium11 {
    public static void main(String[] args) {
        int[] array = {10, 20, 30, 40};

        // Create an ArrayList
        ArrayList<Integer> arrayList = new ArrayList<>();

        // Add elements from array to ArrayList
        for (int element : array) {
            arrayList.add(element);
        }
        System.out.println(findLargestMinDistance(arrayList,2));
    }

    public static int findLargestMinDistance(ArrayList<Integer> boards, int k)
    {
        int first= Collections.max(boards);
        int last=findSum(boards);
        while(first<=last)
        {
            int mid =first+(last-first)/2;
            if(checkPainter(boards,mid,k))
            {
                last=mid-1;
            }
            else {
                first=mid+1;
            }

        }
        return first;
    }

    public  static  boolean checkPainter(ArrayList<Integer> arr,int mid,int k)
    {
        int sum=0;
        int count=1;
        for (int i = 0; i <arr.size() ; i++) {
            if(sum+arr.get(i)<=mid)
            {
                sum+=arr.get(i);
            }
            else {
                count++;
                sum=arr.get(i);
            }

        }
        return count<=k;

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
