package dailychallenge;

import java.util.ArrayList;
import java.util.List;

public class d2 {
    public static void main(String[] args) {
        int [][] arr={{1,496},{2,8112},{6,1395},{7,7068}};
        System.out.println(averageWaitingTime(arr));
    }
    public static double averageWaitingTime(int[][] customers) {
        int sum=0;
        int target=customers[0][1]+customers[0][0];
        sum += target - customers[0][0];
        for (int i = 1; i < customers.length ; i++) {
            if(customers[i][0]<target)
            {
                target += customers[i][1];
            }
            else {
                target = customers[i][1] + customers[i][0];
            }
            sum += target - customers[i][0];
        }
        return (double) sum / customers.length;

    }
}
