package LinkedList.basic;
class Node{
    int data;
    Node next;

    Node(int x){
        data = x;
        next = null;
    }
}
public class b2 {
    private static  Node convertll(int [] arr)
    {
        Node head=new Node(arr[0]);
        Node mover=head;

        for (int i = 1; i <arr.length ; i++) {
            Node temp=new Node(arr[i]);
            mover.next=temp;
            mover=temp;
        }
        return head;
    }
    static Node insertAtBeginning(Node head, int x)
    {
        Node temp=new Node(x);
        temp.next=head;
        return temp;

    }

   static Node insertAtEnd(Node head, int x)
    {
        Node temp=head;
        while(temp.next!=null)
        {
            temp=temp.next;
        }
        Node last=new Node(x);
        temp.next=last;

        return head;
    }
    static Node insertAtK(Node head,int x,int k)
    {
        int count=1;
        Node temp=head;
        while(count<k-1)
        {
            temp=temp.next;
            count++;
        }
        Node newNode=new Node(x);
        newNode.next=temp.next;
        temp.next=newNode;
        return head;

    }
    public static void printLinkedList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
    }

    public static void main(String[] args) {
        int [] arr={3,1,5,8};
        Node head=convertll(arr);
         head=insertAtK(head,4,3);

        printLinkedList(head);



    }
}
