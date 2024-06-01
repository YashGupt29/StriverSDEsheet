package LinkedList.basic;
 class ListNode {
     int val;
     ListNode next;
      ListNode(int x) { val = x; }
  }
public class b3 {

    public static void main(String[] args) {
        int [] arr={3,1,5,8};
        Node head=convertll(arr);

    }
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
    public static void printLinkedList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
    }
    public static  void deleteNode(ListNode node){
        node.val=node.next.val;
        node.next=node.next.next;

    }
}
