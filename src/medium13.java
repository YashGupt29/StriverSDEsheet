import java.util.ArrayList;
import java.util.List;

public class medium13 {
    public static void main(String[] args) {
        int [][] arr= {{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(spiralOrder(arr));

    }
    public static  List<Integer> spiralOrder(int[][] matrix)
    {
        int n= matrix.length;
        int m=matrix[0].length;
        ArrayList<Integer> mp=new ArrayList<>();
        int top=0,left=0,right=m-1,bottom=n-1;

       while(top<=bottom && left<=right)
       {
           //for moving left to right
           for (int i = left; i <=right; i++) {
               mp.add(matrix[top][i]);
           }
           top++;
           //for moving top to bottom
           for (int i = top; i <=bottom ; i++) {
               mp.add(matrix[i][right]);
           }
           right--;
           //for moving right to left
           if(top<=bottom)
           {
               for (int i = right; i >=left ; i--) {
                   mp.add(matrix[bottom][i]);
               }
               bottom--;
           }
           //for moving bottom to top
           if(left<=right)
           {
               for (int i = bottom; i >=top ; i--) {
                   mp.add(matrix[i][left]);;
               }
               left++;
           }
       }
       return mp;

    }
}
