public class bs7 {
    public static void main(String[] args) {
        int [] arr={ 1, 2, 4, 4, 5};
        System.out.println(count(arr,arr.length,6));

    }
    public static int countBrute(int[] arr, int n, int x) {
        int count=0;
        for (int i = 0; i <n ; i++) {
            if(arr[i]==x)
            {
                count++;
            }

        }
        return count;
    }
    public static  int count(int [] arr,int n,int x)
    {
        return lastAppearence(arr,arr.length,x)-firstAppearence(arr,arr.length,x)+1;

    }
    public static int firstAppearence(int []arr, int n, int x) {
        int first=0;
        int last=arr.length-1;
        int ans=0;
        while(first<=last)
        {
            int mid=first+(last-first)/2;
            if(arr[mid]==x)
            {
                ans=mid;
            }
            if(arr[mid]>=x)
            {

                last=mid-1;

            }
            else {
                first=mid+1;
            }

        }
        return ans;
    }
    public static  int lastAppearence(int [] arr,int n,int x)
    {
        int first=0;
        int last=arr.length-1;
        int ans=-1;
        while(first<=last)
        {int mid=first+(last-first)/2;
            if(arr[mid]==x)
            {
                ans=mid;
            }
            if(arr[mid]>x)
            {
                last=mid-1;
            }
            else {
                first=mid+1;
            }

        }
        return ans;
    }

}
