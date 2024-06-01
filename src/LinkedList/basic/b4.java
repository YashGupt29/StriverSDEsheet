package LinkedList.basic;
class NodeD
{
    int data;
    NodeD next;
    NodeD back;
    NodeD(int data,NodeD next,NodeD back)
    {
        this.data=data;
        this.next=next;
        this.back=back;
    }
    NodeD(int data)
    {
        this.data=data;
        this.next=null;
        this.back=null;
    }

}
public class b4 {
    public static void main(String[] args) {
        int [] arr={1,2,3,4,5};
        NodeD head=doubllyLinkedList(arr);
        head=deleteTail(head);
        printLinkedList(head);


    }
    public static void printLinkedList(NodeD head) {
        NodeD current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
    }
    public static NodeD deleteHead(NodeD head)
    {
        head=head.next;
        head.back=null;
        return head;

    }
    public  static NodeD doubllyLinkedList(int [] arr)
    {
        NodeD head=new NodeD(arr[0]);
        NodeD prev=head;
        for (int i = 1; i <arr.length ; i++) {
            NodeD temp=new NodeD(arr[i],null,prev);
            prev.next=temp;
            prev=prev.next;
        }
        return head;

    }
    public static  NodeD deleteTail(NodeD head)
    {
        NodeD temp=head;
        while(temp.next!=null)
        {
            temp=temp.next;
        }
        temp=temp.back;
        temp.next=null;
        return head;
    }
}
