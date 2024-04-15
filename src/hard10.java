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

    public static  int  merge(int []arr,int low,int mid,int high){
        ArrayList<Integer> temp = new ArrayList<>(); // temporary array
        int left = low;      // starting index of left half of arr
        int right = mid + 1;   // starting index of right half of arr

        //storing elements in the temporary array in a sorted manner//

        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp.add(arr[left]);
                left++;
            } else {
                temp.add(arr[right]);
                right++;
            }
        }

        // if elements on the left half are still left //

        while (left <= mid) {
            temp.add(arr[left]);
            left++;
        }

        //  if elements on the right half are still left //
        while (right <= high) {
            temp.add(arr[right]);
            right++;
        }

        // transfering all elements from temporary to arr //
        for (int i = low; i <= high; i++) {
            arr[i] = temp.get(i - low);
        }
        return 2;

    }
}
