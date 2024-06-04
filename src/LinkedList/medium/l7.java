package LinkedList.medium;


import java.util.ArrayList;

public class l7 {
    public static void main(String[] args) {
        int arr []={1,2,3,4};
        ListNode head= convertll(arr);
        head=deleteMiddle(head);
        printLinkedList(head);

    }
    public static ListNode deleteMiddle(ListNode head) {
        if(head==null)
        {
            return null;
        }
        ListNode slow=head;
        ListNode fast=head;
        ListNode prev=slow;
        while(fast!=null && fast.next!=null)
        {
            prev=slow;
            slow=slow.next;
            fast=fast.next.next;
        }
        prev.next=prev.next.next;
        return head;
    }
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if(head.next==null)
        {
            return null;
        }
        ListNode fast=head;
        ListNode slow=head;
        for(int i=0;i<n;i++)
        {
            fast=fast.next;
        }
        while(fast!=null && fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next;
        }
        slow.next=slow.next.next;
        return head;

    }
    public static ListNode removeNthFromEndBrute(ListNode head, int n) {
        int pos=listLengths(head)-n;
        ListNode temp=head;
        int count=1;
        if(pos==0)
        {
            return head.next;
        }
        while(count<pos)
        {
            temp=temp.next;
            count++;
        }


            temp.next=temp.next.next;

        return head;

    }

    private static int listlengths(ListNode head) {

        ListNode temp=head;
        int count=0;
        while(temp!=null)
        {
            count++;
            temp=temp.next;
        }
        return count;
    }

    public static int listLengths(ListNode head)
    {
        ListNode temp=head;
        int count=0;
        while(temp!=null)
        {
            count++;
            temp=temp.next;
        }
        return count;
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
