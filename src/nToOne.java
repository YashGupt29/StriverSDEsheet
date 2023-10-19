import java.util.Arrays;

public class nToOne {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(printNos(5)));

    }
    public static int[] printNos(int x) {
        int count=1;
        int [] arr=new int [x];
        recursiveFunction(x,arr,count);
        return arr;

    }
    public static <count> void recursiveFunction(int x, int []ans, int count)
    {
        if(x==0)
        {
            return;
        }
        ans[x-1]=count;
        count=count+1;
        recursiveFunction(x-1,ans, count);

    }

}
