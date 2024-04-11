public class twoD {
    public static void main(String[] args) {
        int [][] arr={{12,13},{21,32},{41,25}};
        get(arr);
    }
     public  static void get(int arr[][])
    {
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        for (int i = 0; i <arr.length ; i++)
        {
            for(int j=0;j<arr[0].length;j++)
            {
                max=Math.max(arr[i][j],max);
                min=Math.min(arr[i][j],min);
            }

        }
        System.out.println("Maximum value: " + max);
        System.out.println("Minimum value: " + min);

    }
}
