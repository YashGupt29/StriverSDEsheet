public class hard10 {
    public static void main(String[] args) {
        int a[]={4, 3, 2, 1};
        System.out.println(numberOfInversions(a,4));

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

    }
}
