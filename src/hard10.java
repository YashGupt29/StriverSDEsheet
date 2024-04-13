import java.util.ArrayList;

public class hard10 {
    public static void main(String[] args) {
        int[] a = {4 ,3 ,2 ,1};
        int n = 4;
        int cnt = numberOfInversions(a, n);
        System.out.println("The number of inversions are: " + cnt);
    }
    public static int numberOfInversionslessOptimal(int []a, int n) {
        int inversion=0;
        for (int i = 0; i <a.length ; i++) {
            for (int j = i; j <a.length ; j++) {
                if(a[i]>a[j])
                {
                    inversion+=1;
                }


            }

        }
        return inversion;
    }
    public static int numberOfInversions(int []a, int n)
    {
        return mergeSort(a,0,n-1);


    }
    public static  int mergeSort(int []a,int left, int right)
    {
        int count=0;
        if(left>=right) return count;
        if(left<right){
            int mid=left+(right-left)/2;
            count+=mergeSort(a,left,mid);
            count+=mergeSort(a,mid+1,right);
            count+=merge(a,left,mid,right);

        }
        return count;

    }
    public static  int  merge(int []a,int left,int mid,int right){
        ArrayList<Integer> list= new ArrayList<>();
        int count=0;
        int i=left;
        int j=mid+1;
        while(i<=mid && j<=right) {
            if(a[i]<=a[j])
            {
                list.add(a[i]);
                i++;
            }
            else {
                list.add(a[j]);
                j++;
                count += mid - i + 1;
            }
        }
        while(i<=mid){
            list.add(a[i]);
            i++;
        }
        while(j<=right)
        {
            list.add(a[j]);
            j++;
        }
        for (int k = left; k <= right ; k++) {
            a[k]=list.get(k-left);

        }
        return count;

    }
}
