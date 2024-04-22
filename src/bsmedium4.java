public class bsmedium4 {
    public static void main(String[] args) {
        int [] arr={1,10,3,10,2};
        System.out.println(minDays(arr,3,1));

    }
    public static int minDays(int[] bloomDay, int m, int k) {
        if((long)m*(long)k>bloomDay.length) return -1;

        int first=minMax(bloomDay)[0];
        int last=minMax(bloomDay)[1];
        while(first<=last)
        {
            int mid=first+(last-first)/2;
            if(isPossible(bloomDay,mid,m,k))
            {
                last=mid-1;
            }
            else {
                first=mid+1;
            }

        }
        return first;

    }
    public static boolean isPossible(int [] arr,int day,int m,int k)
    {
        int count=0;
        int noOfBoquoe=0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]<=day)
            {
                count+=1;

            }
            else {
                noOfBoquoe+=count/k;
                count=0;
            }

        }
        noOfBoquoe+=count/k;
        return noOfBoquoe>=m;
    }
    public static int [] minMax(int [] arr)
    {
        int min=Integer.MAX_VALUE;
        int max=Integer.MAX_VALUE;
        for (int i = 0; i <arr.length ; i++) {
            if(arr[i]>max)
            {
                max=arr[i];
            }
            if(arr[i]<min)
            {
                min=arr[i];
            }

        }
        return new int[]{min,max};
    }
}
