package LinkedList.medium;

import java.util.HashMap;

public class l5 {
    public ListNode detectCycle(ListNode head) {
        int count=0;
        HashMap<ListNode,Integer> node=new HashMap<>();
        ListNode temp=head;
        while(temp!=null)
        {
            if(node.containsKey(temp))
            {
                return temp;

            }
            node.put(temp,count++);
            temp=temp.next;
        }
        return null;
    }

        public ListNode detectCycleOptimized(ListNode head) {
            ListNode slow=head;
            ListNode fast=head;
            while(fast!=null && fast.next!=null)
            {
                slow=slow.next;
                fast=fast.next.next;
                if(slow==fast)
                {
                    break;
                }
            }
            if(slow==null || fast==null || fast.next==null) return null;
            while(slow!=head)
            {
                slow=slow.next;
                head=head.next;
            }
            return slow;
        }

}
