package recursion;

public class r7 {
    public static void main(String[] args)
    {
        int [] arr={5,2,3,10,6,8};
        System.out.println(perfectSum(arr,0,10));

    }


    public static int perfectSum(int arr[],int n, int sum)
    {
        return perfectSumHelper(arr,sum,0,0,0);

    }
    public static int perfectSumHelper(int arr[],int sum,int count,int index,int ans )
    {
        if(index>=arr.length)
        {
            if(ans==sum)
            {
                count++;
            }
            return count;
        }
        if(ans<=sum) {
            count = perfectSumHelper(arr, sum, count, index + 1, ans + arr[index]);
            count = perfectSumHelper(arr, sum, count, index + 1, ans);
        }
        return count;
    }

}
