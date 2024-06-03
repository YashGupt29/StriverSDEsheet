package LinkedList.medium;

import java.util.HashMap;

public class l4 {
    public static boolean hasCycle(ListNode head) {
        int count=0;
        ListNode temp=head;
        HashMap<ListNode,Integer> node=new HashMap<ListNode, Integer>();
        while(temp!=null)
        {
            if(node.containsKey(temp))
            {
                return true;
            }
            else {
                node.put(temp,1);
                temp=temp.next;
            }
        }
        return false;


    }
    public boolean hasCycleOptimized(ListNode head) {
        if(head==null)
        {
            return false;
        }
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null && fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast) return true;

        }
        return false;
    }

}
