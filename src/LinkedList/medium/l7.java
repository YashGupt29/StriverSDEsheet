package LinkedList.medium;


import java.util.ArrayList;

public class l7 {
    public static void main(String[] args) {
        int arr []={1,2,3,4,5};
        ListNode head= convertll(arr);
        head=oddEvenList(head);
        printLinkedList(head);

    }
    public static ListNode oddEvenList(ListNode head) {
        ListNode odd=head;
        ListNode even=head.next;
        ListNode evenhead=even;
        while(odd!=null && odd.next!=null && odd.next.next!=null && even!=null )
        {
            ListNode frontodd=odd.next.next;

            odd.next=frontodd;
            odd=frontodd;

            ListNode fronteven=even.next.next;
            even.next=fronteven;
            even=fronteven;
        }
        odd.next=evenhead;
        if(even!=null)
        {
            even.next=null;
        }

        return head;
    }
    private static ListNode convertll(int [] arr)
    {
        ListNode head=new ListNode(arr[0]);
        ListNode mover=head;

        for (int i = 1; i <arr.length ; i++) {
            ListNode temp=new ListNode(arr[i]);
            mover.next=temp;
            mover=temp;
        }
        return head;
    }
    public static void printLinkedList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
    }
    public static boolean isPalindrome(ListNode head)
    {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode slow=head;
        ListNode fast=head.next;
        while(fast!=null && fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode revNode=reverseList(slow);
        ListNode second=revNode;
        ListNode first=head;
        while(second.next!=null)
        {
            if(first.val!=second.val)
            {
                reverseList(revNode);
                return false;
            }
            first=first.next;
            second=second.next;
        }
        reverseList(revNode);

        return true;

    }
    public static ListNode reverseList(ListNode head)
    {
        if(head==null || head.next==null)
        {
            return head;
        }
        ListNode newHead=reverseList(head.next);
        ListNode front=head.next;
        front.next=head;
        head.next=null;
        return newHead;
    }
}
