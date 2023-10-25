public class hash1 {
    public static void main(String[] args) {
        int [] arr={1,3,2,1,3};
        int num=3;
        int [] hash=new int[13];
        for(int i=0;i<arr.length;i++)
        {
            hash[arr[i]]+=1;
        }
        System.out.println(hash[num]);

    }
}
