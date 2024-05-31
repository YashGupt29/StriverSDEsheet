package LinkedList.basic;
class Node{
    int data;
    Node next;
    Node()
    {
        this.data=0;
        this.next=null;
    }
    Node(int data)
    {
        this.data=data;
        this.next=null;
    }
    Node(int data,Node next)
    {
        this.data=data;
     this.next=next;
    }
}
public class b1 {
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
    private static boolean check(Node head,int val)
    {
        Node temp=head;
        while(temp!=null)
        {
            if(val==temp.data)
            {
                return true;
            }
            temp=temp.next;
        }
        return false;
    }
    public static void main(String[] args) {
        int [] arr={1,2,3,4,5};
        Node head=convertll(arr);
//        Node temp=head;
//        while(temp!=null)
//        {
//            System.out.print(temp.data+"-->");
//            temp=temp.next;
//
//        }
        System.out.println(check(head,5));


    }

}
