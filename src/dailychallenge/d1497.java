package dailychallenge;

public class d1497 {
    public static void main(String[] args) {
        int [] arr={1,2,3,4,5,10,6,7,8,9};
        int k=5;
        System.out.println(canArrange(arr,k));
    }
    public static boolean canArrange(int[] arr, int k) {
        int n=arr.length;
        int [] hash=new int[100000];
        for(int i=0;i<arr.length;i++)
        {
            hash[arr[i]]++;
        }
        int pair=0;
        for(int i=0;i<arr.length;i++)
        {
            int num=Math.abs(arr[i]-k);
            if(hash[num]>=1)
            {
                pair+=1;
                hash[num]=0;
                hash[i]=0;
            }
        }
        System.out.println(pair);
        return pair==n/2;
    }
}
