package LinkedList.medium;

import java.util.HashMap;

public class l4 {
    public static boolean hasCycle(ListNode head) {
        int count=0;
        ListNode temp=head;
        HashMap<ListNode,Integer> node=new HashMap<ListNode, Integer>();
        while(temp!=null)
        {
            if(node.containsKey(temp))
            {
                return true;
            }
            else {
                node.put(temp,1);
                temp=temp.next;
            }
        }
        return false;


    }

}
