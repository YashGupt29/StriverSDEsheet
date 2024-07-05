package dailychallenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class q1 {
    public static void main(String[] args) {
        int [] arr={6,8,4,1,9,6,6,10,6};
        ListNode head=LinkedList.convertArrayToLinkedList(arr);
//        nodesBetweenCriticalPoints(head);
        System.out.println(Arrays.toString(nodesBetweenCriticalPoints(head)));

    }
    public static int[] nodesBetweenCriticalPoints(ListNode head) {
        int [] ans=new int[2];
        ListNode temp=head;
        ListNode prev=new ListNode();
        int count=1;
        List<Integer> arr=new ArrayList<>();
        while(temp.next!=null)
        {
            while(temp.next!=null && temp.next.val<=temp.val)
            {
                prev=temp;
                count+=1;
                temp=temp.next;
            }
            if(temp.next!=null && temp.next.val>temp.val && temp.val<prev.val)
            {
                arr.add(count);
            }

            while(temp.next!=null && temp.next.val>temp.val)
            {
                prev=temp;
                count+=1;
                temp=temp.next;
            }
            if(temp.next!=null  && temp.next.val<temp.val && temp.val>prev.val)
            {
                arr.add(count);
            }


        }
       if(arr.isEmpty() || arr.size()==1)
       {
           return new int[]{-1,-1};
       }
       ans[0]= findMinDifference(arr);
       ans[1]=arr.getLast()-arr.getFirst();
       return ans;
    }
    public static int findMinDifference(List<Integer> list) {
        if (list == null || list.size() < 2) {
            throw new IllegalArgumentException("List must contain at least two elements");
        }

        Collections.sort(list);
        int minDiff = Integer.MAX_VALUE;

        for (int i = 1; i < list.size(); i++) {
            int diff = list.get(i) - list.get(i - 1);
            if (diff < minDiff) {
                minDiff = diff;
            }
        }

        return minDiff;
    }
}
