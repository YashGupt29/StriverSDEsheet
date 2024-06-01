package LinkedList.medium;

public class l2 {
    public ListNode reverseList(ListNode head) {
        if(head==null)
        {
            return null;
        }

        ListNode temp=head.next;
        ListNode prev=head;
        while(temp!=null)
        {
            if(prev==head)
            {
                prev.next=null;
            }
            ListNode front=temp.next;
            temp.next=prev;
            prev=temp;
            temp=front;
        }
        return prev;
    }
}
