package binary_tree;

import java.util.*;

public class h3 {
    public static void main(String[] args) {
        Integer [] arr={1,3,2,5,null,null,9,6,null,7};
        System.out.println(widthOfBinaryTree(TreeNode.arrayToBinaryTree(arr)));

    }
    public static int widthOfBinaryTree(TreeNode root) {
        if(root==null) return 0;
       Queue<Pair> queue=new LinkedList<>();
       int max=0;
       queue.add(new Pair(root,1));
       while(!queue.isEmpty())
       {
           int size= queue.size();
           int first=0;
           int last=0;
           for (int i = 0; i < size; i++) {

               Pair curr=queue.poll();
               TreeNode node=curr.node;
               int level=curr.hd-1;
               if(i==0)
               {
                   first=level;
               }
               if(i==size-1)
               {
                   last=level;
               }
               if(node.left!=null)
               {
                   queue.add(new Pair(node.left,2 * level + 1));
               }
               if(node.right!=null)
               {
                   queue.add(new Pair(node.right,2 * level + 2));
               }
           }
           max=Math.max(max,last-first+1);
       }
       return max;


    }
}
