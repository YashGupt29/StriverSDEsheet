package bitManipulation.medium;

public class m1 {
    public static void main(String[] args) {
        System.out.println(minBitFlips(10,7));

    }
    public static int minBitFlips(int start, int goal) {

        int ans=start ^ goal;
        int count=0;
        while (ans!=0)
        {
            if(ans%2==1)
            {
                count++;
            }
            ans=ans/2;
        }
        return count;
    }
}
