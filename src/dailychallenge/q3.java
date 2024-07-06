package dailychallenge;

import java.util.PriorityQueue;

public class q3 {
    public static void main(String[] args) {
        int [] arr={3,2,1,5,6,4};
        System.out.println(findKthLargest(arr,2));

    }
    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap=new PriorityQueue<>();
        for(int num:nums)
        {
            minHeap.offer(num);
            if(minHeap.size()>k)
            {
                minHeap.poll();
            }
        }
        return minHeap.peek();
    }
}
