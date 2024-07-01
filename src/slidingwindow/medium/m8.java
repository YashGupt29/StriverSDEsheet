package slidingwindow.medium;

public class m8 {
    public static void main(String[] args) {
        int [] arr={11,49,100,20,86,29,72};
        System.out.println(maxScore(arr,4));

    }
    public static int maxScore(int[] cardPoints, int k) {
        int lSum=0,rSum=0,maxSum=0;
        for (int i = 0; i < k; i++) {
            lSum+=cardPoints[i];
        }
        maxSum=lSum;
        int rightIndex=cardPoints.length-1;
        for (int i = k-1; i >=0; i--) {
            lSum-=cardPoints[i];
            rSum+=cardPoints[rightIndex];
            rightIndex--;
            maxSum=Math.max(maxSum,lSum+rSum);
        }
        return maxSum;

    }
}
