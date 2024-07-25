package dailychallenge;

import java.util.ArrayList;
import java.util.List;

public class d1380 {
    public static void main(String[] args) {
        int [][] arr={{7,8},{1,2}};
        System.out.println(luckyNumbers(arr));
    }
    public static List<Integer> luckyNumbers (int[][] matrix) {
        int row= matrix.length;
        ArrayList<Integer> ans=new ArrayList<>();
        int col=matrix[0].length;
        int lucky_number=-1;
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        int rownum=-1;
        for (int i = 0; i < col; i++) {
           max=findMax(matrix,i)[0];
           rownum=findMax(matrix,i)[1];
            for (int j = 0; j <col ; j++) {
                if(max<=matrix[rownum][j])
                {
                    lucky_number=max;
                }
                else{
                    lucky_number=-1;
                    break;
                }

            }
            if(lucky_number!=-1)
            {
                ans.add(lucky_number);
            }

        }
        return ans;

    }
    public static int[] findMax(int [][] matrix,int col)
    {
        int max=Integer.MIN_VALUE;
        int row=-1;
        for (int j = 0; j < matrix.length ; j++) {
            if(matrix[j][col]>max)
            {
                max=matrix[j][col];
                row=j;
            }
        }
        return new int [] {max,row};

    }
}
