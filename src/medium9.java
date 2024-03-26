import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class medium9 {
    public static void main(String[] args) {
        int [] arr={2,6,7,4,8,6,7};
        System.out.println (superiorElements(arr));


    }
    public static List< Integer > superiorElements(int []a) {
        // Write your code here.
        ArrayList<Integer> mp=new ArrayList<>();
        int index=0;
        int n=a.length;
        mp.add(a[n-1]);
        for (int i = n-2; i >=0 ; i--) {
            if(a[i]>mp.get(index))
            {
                mp.add(a[i]);
                index+=1;
            }
        }
        return mp;
    }
}
