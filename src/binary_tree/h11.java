package binary_tree;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class h11 {
    public static void main(String[] args) {
        Integer [] arr={1,2,3,null,null,4,5};
        System.out.println(serialize(TreeNode.arrayToBinaryTree(arr)));
        String s=serialize(TreeNode.arrayToBinaryTree(arr));
        deserialize(s);
    }
    public static String serialize(TreeNode root) {
       StringBuilder sb=new StringBuilder();
       Queue<TreeNode> queue=new LinkedList<>();
       queue.add(root);
       while(!queue.isEmpty())
       {
           int size= queue.size();
           for (int i = 0; i < size; i++) {
               TreeNode node= queue.poll();
               if(node==null)
               {
                   sb.append("#").append(",");
               }
               else {
                   sb.append(node.val).append(",");
                   queue.add(node.left);
                   queue.add(node.right);
               }
           }

       }
       return sb.toString();
    }
    public static TreeNode deserialize(String data) {
        if(data.isEmpty())
        {
            return null;
        }
        Queue<TreeNode> queue=new LinkedList<>();
        String [] str=data.split(",");
        TreeNode root=new TreeNode(Integer.parseInt(str[0]));
        queue.add(root);
        while (!queue.isEmpty())
        {
            for (int i = 1; i < str.length; i++) {
                TreeNode node=queue.poll();
                if(!Objects.equals(str[i], "#"))
                {
                    TreeNode left=new TreeNode(Integer.parseInt(str[i]));
                    queue.add(left);
                    node.left=left;
                }
                if(!Objects.equals(str[++i],"#"))
                {
                    TreeNode right=new TreeNode(Integer.parseInt(str[i]));
                    queue.add(right);
                    node.right=right;
                }
            }
        }
        return root;
    }
}
