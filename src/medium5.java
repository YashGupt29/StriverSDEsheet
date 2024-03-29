public class medium5 {
    public static void main(String[] args)
    {
        int [] arr={7,1,5,3,6,4};
        System.out.println(maxProfit(arr));

    }
    public static  int maxProfit(int[] prices)
    {
        int min=Integer.MAX_VALUE,profit=0,maxProfit=0;
        for (int price : prices) {
            if (price < min) {
                min = price;
            }
            profit = price - min;

            if (profit > maxProfit) {
                maxProfit = profit;
            }

        }
        return maxProfit;

    }
}
