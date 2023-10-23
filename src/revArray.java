import java.util.Arrays;

public class revArray {
    public static void main(String[] args) {
        int[] arr ={5,4,3,2,1};
        System.out.println(Arrays.toString(revArr(arr)));


    }
    static int[] revArr(int[] arr){
        int p1=0;
        int p2=arr.length-1;
       while (p1<p2)
        {
            int temp = arr[p1];
            arr[p1]=arr[p2];
            arr[p2]=temp;
            p1++;
            p2--;
        }
return  arr;

    }
}
