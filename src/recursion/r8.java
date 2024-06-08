package recursion;

public class r8 {
    public static void main(String[] args) {
        int [] arr={1, 2, 3};
        System.out.println(isSubsetPresent(3,5,arr));
    }
    public static boolean isSubsetPresent(int n, int k,int []a) {
        return isSubsetPresentHelper(a,0,0,k,false);
    }
    public static boolean isSubsetPresentHelper(int [] arr,int index,int sum,int k,boolean isPresent)
    {
        if(index>=arr.length)
        {
           if(sum==k)
           {
               isPresent=true;
           }
            return isPresent;
        }
        if(!isPresent || sum+arr[index]<=k)
        {
            isPresent=isSubsetPresentHelper(arr,index+1,sum+arr[index],k,isPresent);
            isPresent=isSubsetPresentHelper(arr,index+1,sum,k,isPresent);
        }
        return isPresent;
    }
}
