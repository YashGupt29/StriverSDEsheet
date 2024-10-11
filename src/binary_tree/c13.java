package binary_tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class c13 {
    public static void main(String[] args) {
        Integer [] arr={1,2,3,null,null};
        System.out.println(serialize(Node.arrayToBinaryTree(arr)));
        ArrayList<Integer> a=serialize(Node.arrayToBinaryTree(arr));
        Node node =deSerialize(a);
        System.out.println(serialize(node));
    }
    public static ArrayList<Integer> serialize(Node root) {
        ArrayList<Integer> ans=new ArrayList<>();
        Queue<Node> queue=new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty())
        {
            int size=queue.size();
            for (int i = 0; i < size; i++) {
                Node node=queue.poll();
                if(node==null)
                {
                    ans.add(null);
                }
                else {
                   ans.add(node.data);
                   queue.add(node.left);
                   queue.add(node.right);
                }
            }
        }
        return ans;
    }

    // Function to deserialize a list and construct the tree.
    public static Node deSerialize(ArrayList<Integer> a) {
       Node root=new Node(a.getFirst());
       Queue<Node> queue=new LinkedList<>();
       queue.add(root);
       while (!queue.isEmpty())
       {
           for (int i = 1; i < a.size(); i++)
           {
              Node node=queue.poll();
              if(a.get(i)!=null)
              {
                  Node left=new Node(a.get(i));
                  queue.add(left);
                  node.left=left;
              }

              if(a.get(++i)!=null)
              {
                  Node right=new Node(a.get(i));
                  queue.add(right);
                  node.right=right;
              }
           }
       }
       return root;

    }
}
