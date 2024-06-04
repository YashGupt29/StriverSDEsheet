package LinkedList.medium;
class Node
{
    int data;
    Node next;
    Node(int d) {data = d; next = null; }
}
public class l6 {
    static int countNodesinLoop(Node head)
    {
        int count=2;
        Node fast=head;
        Node slow=head;
        while(fast!=null && fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }
        if(fast!=null || fast.next!=null) return 0;
        while(slow!=head)
        {
            slow=slow.next;
            head=head.next;
        }
        Node temp=slow.next;
        while(slow!=temp)
        {
            count++;
        }
        return count;

    }
}
