import java.util.Arrays;

public class recursionIntro {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(printNos(5)));
    }

    public static int[] printNos(int x) {
        int [] arr=new int [x];
        recursiveFunction(x,arr);
        return arr;

    }
    public static void recursiveFunction(int x, int []ans)
    {
        if(x==0)
        {
            return;
        }
        ans[x-1]=x;
        recursiveFunction(x-1,ans);

    }
}
