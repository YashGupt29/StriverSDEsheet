import java.util.ArrayList;

public class sortArrayList {
    public static void main(String[] args) {

    }
    public static void sortArray(ArrayList<Integer> arr, int n) {
        int count0=0,count1=0,count2=0;
       for(int i=0;i<arr.size();i++)
       {
           if(arr.get(i)==0)  count0++;
           if(arr.get(i)==1)  count1++;
           if(arr.get(i)==2)  count2++;
       }
       for(int i=0;i<count0;i++)
       {
           arr.set(i,0);
       }
       for(int j=count0;j<count0+count1;j++)
       {
           arr.set(j,1);
       }
       for(int k=count0+count1;k<n;k++)
       {
           arr.set(k,2);
       }
    }
}
