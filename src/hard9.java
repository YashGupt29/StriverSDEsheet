import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class hard9 {

    public static void main(String[] args) {
        int a[]={1, 2, 3, 2};
        System.out.println(Arrays.toString(findMissingRepeatingNumbersOptimalistic(a)));

    }
    public static int[] findMissingRepeatingNumbers(int []a) {
//        Arrays.sort(a);

        int repeat=-1;
        int missing=-1;
        for (int i = 1; i <= a.length; i++) {
            int count=0;
            for (int j = 0; j <a.length ; j++) {
                if(i==a[j])
                {
                    count++;
                }
            }
            if(count==2){
                repeat=i;

            }
            else if(count==0)
            {
                missing=i;
            }
            if(repeat!=-1 && missing!=-1) break;

        }
        return new int[] {repeat,missing};
    }
    public static int[] findMissingRepeatingNumbersOptimal(int []a)
    {
        int missing=-1,repeating=-1;
        HashMap<Integer,Integer> mp=new HashMap<>();
        for (int i = 0; i <a.length ; i++) {
            int freq=1;
            if(mp.containsKey(a[i]))
            {
                freq++;
            }
            mp.put(a[i],freq);
        }
        for (int i = 1; i <=a.length ; i++) {
            if(!mp.containsKey(i))
            {
                missing=i;
            }
            else if(mp.get(i)==2)
            {
                repeating=i;
            }

        }
        return new int[]{repeating,missing};

    }
    public static int[] findMissingRepeatingNumbersOptimalistic(int []a){
        long missing,repeating;
        long n=a.length;
        long sumn=(n*(n+1))/2;
        long sumSquaren=(n*(n+1)*(2*n+1))/6;
        long sum=0;
        long sumSquare=0;
        for (int i = 0; i <a.length ; i++) {
            sum+=a[i];
            sumSquare+= (long) Math.pow(a[i],2);
        }
        long diff=sum-sumn;
        long diffSquare=sumSquare-sumSquaren;
        long add=diffSquare/diff;
        repeating=(add+diff)/2;
        missing=add-repeating;
        return new int[] {(int) repeating, (int) missing};


    }

}
