package LinkedList.medium;


import java.util.ArrayList;
import java.util.List;

public class l7 {
    public static void main(String[] args) {
        int arr []={2,2,2,2,2,2};
        ListNode head= convertll(arr);
        head=segregate(head);
        printLinkedList(head);

    }
    static ListNode segregate(ListNode head) {
        ListNode zero=new ListNode(-1);
        ListNode zerohead=zero;
        ListNode one=new ListNode(-1);
        ListNode headone=one;
        ListNode two=new ListNode(-1);
        ListNode headtwo=two;
        ListNode temp=head;
        ListNode newhead=new ListNode(-1);
        int count=0;
        while(temp!=null)
        {
            if(temp.val==0)
            {
                zero.next=temp;
                zero=temp;
                temp=temp.next;
                if(count==0) newhead=temp;
                count++;

            } else if (temp.val==1) {
                one.next=temp;
                one=temp;
                temp=temp.next;
                if(count==0) newhead=temp;
                count++;
            } else if (temp.val==2) {
                two.next=temp;
                two=temp;
                temp=temp.next;
                if(count==0) newhead=temp;
                count++;
            }

        }
        if(zero!=null) zero.next=headone.next!=null?headone.next:headtwo.next;
        if(one!=null) one.next=headtwo.next;
        if(two!=null) two.next=null;
        return zero.next;

    }
    public static  ListNode sortList(ListNode head) {
        if(head==null || head.next==null)
        {
            return head;
        }
        ListNode slow=head;
        ListNode fast=head;
        ListNode prev=head;
        while(fast!=null && fast.next!=null)
        {
            prev=slow;
            slow=slow.next;
            fast=fast.next.next;
        }
        prev.next=null;
        ListNode l1=sortList(head);
        ListNode l2=sortList(slow);
        return mergeList(l1,l2);

    }
    public static  ListNode mergeList(ListNode l1,ListNode l2)
    {
        ListNode dummy=new ListNode(1);
        ListNode temp=dummy;
        while(l1!=null && l2!=null)
        {
            if(l1.val<l2.val)
            {
                temp.next=l1;
                temp=l1;
                l1=l1.next;

            }
            else {
                temp.next=l2;
                temp=l2;
                l2=l2.next;
            }
        }
        if(l1!=null) {
            temp.next=l1;
        }
        else {
            temp.next=l2;
        }
        return dummy.next;
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
