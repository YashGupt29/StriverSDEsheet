package LinkedList.medium;

public class l3 {
    public ListNode reverseList(ListNode head) {
        if(head==null || head.next==null)
        {
            return head;
        }
        ListNode newNode=reverseList(head.next);
        ListNode front=head.next;
        front.next=head;
        head.next=null;
        return newNode;
    }
}
